package com.jf.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.common.base.ArgException;
import com.jf.common.base.ResponseMsg;
import com.jf.common.constant.Const;
import com.jf.common.utils.DateUtil;
import com.jf.entity.IntegralDtl;
import com.jf.entity.IntegralDtlCustom;
import com.jf.entity.MemberAccount;
import com.jf.entity.MemberAccountExample;
import com.jf.service.IntegralDtlService;
import com.jf.service.MemberAccountService;

import net.sf.json.JSONObject;

/**
  *	我的积分 
  * @author  chenwf: 
  * @date 创建时间：2017年4月21日 上午11:53:34 
  * @version 1.0 
  * @parameter  
  * @return  
*/
@Controller
public class IntegralDtlController extends BaseController{
	
	@Resource
	private IntegralDtlService integralDtlService;
	
	@Resource
	private MemberAccountService memberAccountService;
	
	/**
	 * 
	 * 方法描述 ：获取我的积分明细列表
	 * @author  chenwf: 
	 * @date 创建时间：2017年4月21日 上午11:54:30 
	 * @version
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/api/y/getIntegralDtlList")
	@ResponseBody
	public ResponseMsg getIntegralDtlList(HttpServletRequest request){
		try {
			JSONObject reqPRM = (JSONObject) request.getAttribute("reqPRM");
			JSONObject reqDataJson = reqPRM.getJSONObject("reqData");// 获取请求参数
			
			Object[] obj = {"pageSize","currentPage"};
			this.requiredStr(obj,request);
			Integer memberId = getMemberId(request);//会员标识id
			Integer pageSize = Integer.valueOf(reqDataJson.getString("pageSize"));//页数
			Integer currentPage = Integer.valueOf(reqDataJson.getString("currentPage"));//页码
			if(currentPage == null || pageSize == null){
				currentPage = 0;
				pageSize = 5;
			}
			Date date = new Date();
			String lastYear = DateUtil.getFormatDate(DateUtil.addYear(date, -1),"yyyy");
			Map<String, Object> returnData = new HashMap<String, Object>();
			
			MemberAccountExample memberAccountExample = new MemberAccountExample();
			memberAccountExample.createCriteria().andMemberIdEqualTo(memberId).andDelFlagEqualTo("0");
			List<MemberAccount> memberAccounts = memberAccountService.selectByExample(memberAccountExample);
			Integer totalIntegral = 0;
			Map<String,Object> params = new HashMap<String,Object>();
			if(CollectionUtils.isNotEmpty(memberAccounts)){
				totalIntegral = memberAccounts.get(0).getIntegral();
				params.put("accId", memberAccounts.get(0).getId());
			}else{
				throw new ArgException("此账户号不存在");
			}
			//获取进出账总积分  2017-01-01 00:00:00
			Integer inAccount = 0;
			Integer outAccount = 0;
			String firstDay = lastYear+"-01-01 00:00:00";
			String lastDay = lastYear+"-12-31 23:59:59";
			params.put("firstDay", firstDay);
			params.put("lastDay", lastDay);
			List<IntegralDtl> dtls = integralDtlService.getImportAccountIntegral(params);
			if(CollectionUtils.isNotEmpty(dtls)){
				for (IntegralDtl integralDtl : dtls) {
					if(integralDtl.getTallyMode().equals(Const.INTEGRAL_TALLY_MODE_INCOME)){
						inAccount = integralDtl.getIntegral();
					}
					if(integralDtl.getTallyMode().equals(Const.INTEGRAL_TALLY_MODE_ACCOUNT)){
						outAccount = integralDtl.getIntegral();
					}
				}
			}
			//上一年的剩余积分
			Integer surplusIntegral = inAccount - outAccount;
			if(surplusIntegral < 0){
				surplusIntegral = 0;
			}
			String context = DateUtil.getFormatDate(date,"yyyy")+"年12月31日前过期积分:"+surplusIntegral;
			params.put("pageSize", pageSize);
			params.put("currentPage", currentPage*pageSize);
			
			List<IntegralDtlCustom> integralDtlCustomList= integralDtlService.getIntegralDtlList(params);
			/*Integer count = integralDtlService.getIntegralDtlCount(params);
			Page page = new Page(currentPage, pageSize,count);*/
			List<Map<String,Object>> integralDtlList = new ArrayList<Map<String,Object>>();
			if(integralDtlCustomList != null && integralDtlCustomList.size() > 0){
				
				for(IntegralDtlCustom custom : integralDtlCustomList){
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", custom.getId() == null ? "" : custom.getId());
					map.put("name", custom.getName() == null ? "" : custom.getName());//名称
					map.put("tallyMode", custom.getTallyMode() == null ? "" : custom.getTallyMode());//进账出账
					map.put("integral", custom.getIntegral() == null ? "" : custom.getIntegral());//进出账分数
					String createDate = DateUtil.getFormatDate(custom.getCreateDate(), "yyyy-MM-dd");
					map.put("createDate", createDate == null ? "" : createDate);//进出帐时间
					
					integralDtlList.add(map);
				}
			}
			returnData.put("totalIntegral", totalIntegral);
			returnData.put("integralDtlList", integralDtlList);
			returnData.put("totalPage", "");//总页数
			returnData.put("context", context);
			return new ResponseMsg(ResponseMsg.SUCCESS,ResponseMsg.SUCCESS_MSG,returnData);
		} catch (ArgException args){
			return new ResponseMsg(ResponseMsg.ERROR,args.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMsg(ResponseMsg.ERROR,e.getMessage());
		}
	}
}
