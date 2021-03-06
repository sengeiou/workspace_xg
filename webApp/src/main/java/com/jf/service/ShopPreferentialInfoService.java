package com.jf.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.jf.common.base.BaseService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jf.common.utils.StringUtil;
import com.jf.dao.ShopPreferentialInfoCustomMapper;
import com.jf.dao.ShopPreferentialInfoMapper;
import com.jf.entity.Coupon;
import com.jf.entity.CouponCustom;
import com.jf.entity.CouponExample;
import com.jf.entity.FullCut;
import com.jf.entity.FullCutExample;
import com.jf.entity.FullDiscount;
import com.jf.entity.FullDiscountExample;
import com.jf.entity.FullGive;
import com.jf.entity.FullGiveCustom;
import com.jf.entity.FullGiveExample;
import com.jf.entity.Product;
import com.jf.entity.ShopPreferentialInfo;
import com.jf.entity.ShopPreferentialInfoExample;

/**
  * @author  chenwf: 
  * @date 创建时间：2018年5月19日 下午5:03:46 
  * @version 1.0 
  * @parameter  
  * @return  
*/
@Service
@Transactional
public class ShopPreferentialInfoService extends BaseService<ShopPreferentialInfo, ShopPreferentialInfoExample> {
	@Autowired
	private ShopPreferentialInfoMapper shopPreferentialInfoMapper;
	@Autowired
	private ShopPreferentialInfoCustomMapper shopPreferentialInfoCustomMapper;
	@Resource
	private FullCutService fullCutService;
	@Resource
	private FullDiscountService fullDiscountService;
	@Resource
	private FullGiveService fullGiveService;
	@Resource
	private CouponService couponService;
	@Resource
	private MemberCouponService memberCouponService;
	@Resource
	private ProductService productService;

	@Autowired
	public void setShopPreferentialInfoMapper(ShopPreferentialInfoMapper shopPreferentialInfoMapper) {
		this.setDao(shopPreferentialInfoMapper);
		this.shopPreferentialInfoMapper = shopPreferentialInfoMapper;
	}

	public Map<String, String> getShopPreferentialInfo(List<Integer> mchtIds) {
		Date date = new Date();
		String disInfo = "";
		Map<String,String> shopPreferentialInfoMap = new HashMap<String, String>();
		ShopPreferentialInfoExample preferentialInfoExample = new ShopPreferentialInfoExample();
		preferentialInfoExample.createCriteria().andTypeEqualTo("2").andBeginDateLessThanOrEqualTo(date).andEndDateGreaterThan(date)
		.andDelFlagEqualTo("0").andStatusEqualTo("1").andMchtIdIn(mchtIds);
		preferentialInfoExample.setOrderByClause("id desc");
		List<ShopPreferentialInfo> preferentialInfos = selectByExample(preferentialInfoExample);
		if(CollectionUtils.isNotEmpty(preferentialInfos)){
			for (ShopPreferentialInfo shopPreferentialInfo : preferentialInfos) {
				Integer mchtId = shopPreferentialInfo.getMchtId();
				if(!shopPreferentialInfoMap.containsKey(mchtId)){
					String type = shopPreferentialInfo.getType();
					Integer preferentialId = shopPreferentialInfo.getPreferentialId();
					if(type.equals("2")){
						FullCut cut = fullCutService.selectByPrimaryKey(preferentialId);
						if(cut != null){
							String rult = cut.getRule();
							String[] rults = rult.split("\\|");
							BigDecimal dis = new BigDecimal("0");
							for (int i = 0; i < rults.length; i++) {
								String[] rsi = rults[i].split(",");
								BigDecimal min = new BigDecimal(rsi[1]);
								if(min.compareTo(dis) > 0){
									dis = min;
									disInfo = "满"+rsi[0]+"减"+rsi[1]+"";
								}
							}
						}
					}
					shopPreferentialInfoMap.put(mchtId.toString(), disInfo);
				}
			}
		}
		return shopPreferentialInfoMap;
	}

	public Map<String, Object> getMchtShopPreferInfoByMchtId(Integer mchtId, Map<String, Object> map,Integer memberId,String type, String system) {
		Date date = new Date();
		map.put("preferentialType", "0");
		Map<String, Object> preMap = new HashMap<>();
		ShopPreferentialInfoExample shopPreInfoExample = new ShopPreferentialInfoExample();
		shopPreInfoExample.createCriteria().andBeginDateLessThanOrEqualTo(date).andEndDateGreaterThan(date)
		.andMchtIdEqualTo(mchtId).andStatusEqualTo("1").andDelFlagEqualTo("0");
		List<ShopPreferentialInfo> preferentialInfos = selectByExample(shopPreInfoExample);
		List<Coupon> couponList = new ArrayList<>();
//		if(system.equals(Const.WX_XCX)){
//			couponList = couponService.findModelsByMchtId(mchtId);
//		}
		if(CollectionUtils.isNotEmpty(preferentialInfos) || CollectionUtils.isNotEmpty(couponList)){
			for (ShopPreferentialInfo model : preferentialInfos) {
				String preType = model.getType();
				Integer preferentialId = model.getPreferentialId();
				preMap.put(preType, preferentialId);
				
			}
			if(CollectionUtils.isNotEmpty(couponList)){
				String preType = "1";
				String preIdStr = "";
				for (Coupon model : couponList) {
					preIdStr += model.getId() + ",";
				}
				preMap.put(preType, preIdStr.substring(0,preIdStr.length()-1));
			}
		}
		//优惠类型(1优惠劵 2满减 3满赠 4多买优惠)
		for (String preferentialInfoType : preMap.keySet()) {
			String value = preMap.get(preferentialInfoType)+"";
			map.put("preferentialType", preferentialInfoType);
			if(preferentialInfoType.equals("1")){
				String couponIdGroup = value;
				if(!StringUtil.isBlank(couponIdGroup)){
					List<Integer> couponIdList = new ArrayList<>();
					for (String couponId : couponIdGroup.split(",")) {
						couponIdList.add(Integer.valueOf(couponId));
					}
					if(CollectionUtils.isNotEmpty(couponIdList)){
						CouponExample couponExample = new CouponExample();
						couponExample.createCriteria().andIdIn(couponIdList).andStatusEqualTo("1")
						.andRecBeginDateLessThanOrEqualTo(date).andRecEndDateGreaterThan(date).andDelFlagEqualTo("0");
						List<Coupon> coupons = couponService.selectByExample(couponExample);
						if(type.equals("1")){
							List<CouponCustom> couponCustomList = new ArrayList<CouponCustom>();
							if(CollectionUtils.isNotEmpty(coupons)){
								for (Coupon coupon : coupons) {
									CouponCustom couponCustom = new CouponCustom();
									BeanUtils.copyProperties(coupon, couponCustom);
									Map<String, Object> couponMap = memberCouponService.getMemberIsReceiveCoupon(coupon,memberId);
									couponCustom.setIsHasCoupon((boolean)couponMap.get("isHasCoupon"));
									couponCustom.setCouponReceiveMsg(couponMap.get("couponReceiveMsg")+"");
									couponCustomList.add(couponCustom);
								}
							}
							map.put("coupons", couponCustomList);
						}else{
							map.put("coupons", coupons);
						}
					}
				}
			}else if(preferentialInfoType.equals("2")){
				FullCutExample fullCutExample = new FullCutExample();
				fullCutExample.createCriteria().andIdEqualTo(Integer.parseInt(value)).andDelFlagEqualTo("0");
				List<FullCut> fullCuts = fullCutService.selectByExample(fullCutExample);
				map.put("fullCuts", fullCuts);
			}else if(preferentialInfoType.equals("3")){
				FullGiveExample fullGiveExample = new FullGiveExample();
				fullGiveExample.createCriteria().andIdEqualTo(Integer.parseInt(value)).andDelFlagEqualTo("0");
				List<FullGive> fullGives = fullGiveService.selectByExample(fullGiveExample);
				List<FullGiveCustom> fullGiveCustoms=new ArrayList<>();
				if(CollectionUtils.isNotEmpty(fullGives)){
					FullGive fullGive = fullGives.get(0);
					FullGiveCustom fullGiveCustom=new FullGiveCustom();
					BeanUtils.copyProperties(fullGive, fullGiveCustom);
					if("1".equals(fullGive.getProductFlag())){
						Product product=productService.selectByPrimaryKey(fullGive.getProductId());
						fullGiveCustom.setProductName(product.getName());
					}
					if("1".equals(fullGive.getCouponFlag())){
						String[] couponIds=fullGive.getCouponIdGroup().split(",");
						StringBuffer couponNameGroup=new StringBuffer();
						for (int i = 0; i < couponIds.length; i++) {
							Coupon coupon=couponService.selectByPrimaryKey(Integer.valueOf(couponIds[i]));
							couponNameGroup.append(",").append(coupon.getName());
						}
						fullGiveCustom.setCouponNameGroup(couponNameGroup.toString().substring(1));
					}
					fullGiveCustoms.add(fullGiveCustom);	
				}
				map.put("fullGives", fullGiveCustoms);
			}else if(preferentialInfoType.equals("4")){
				FullDiscountExample fullDiscountExample = new FullDiscountExample();
				fullDiscountExample.createCriteria().andIdEqualTo(Integer.parseInt(value)).andDelFlagEqualTo("0");
				List<FullDiscount> fullDiscounts = fullDiscountService.selectByExample(fullDiscountExample);
				map.put("fullDiscounts", fullDiscounts);
			}
		}
		return map;
	}

	public List<ShopPreferentialInfo> findModelsByMchtId(Integer mchtId, String type) {
		Date currentDate = new Date();
		ShopPreferentialInfoExample shopPreferentialInfoExample = new ShopPreferentialInfoExample();
		shopPreferentialInfoExample.createCriteria().andTypeEqualTo(type).andBeginDateLessThanOrEqualTo(currentDate).andEndDateGreaterThan(currentDate)
		.andStatusEqualTo("1").andDelFlagEqualTo("0").andMchtIdEqualTo(mchtId);
		List<ShopPreferentialInfo> shopPreferentialInfos = selectByExample(shopPreferentialInfoExample);
		return shopPreferentialInfos;
	}

	
	
	
}
