package com.jf.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jf.common.base.ArgException;
import com.jf.common.base.ResponseMsg;
import com.jf.common.constant.BaseDefine;
import com.jf.entity.MemberInfo;
import com.jf.service.MemberAccountDtlService;
import com.jf.service.NovaPlanService;
import com.jf.service.WithdrawOrderService;

import net.sf.json.JSONObject;
/**
 * 资金管理（提现）
 * @author chenwf
 *
 */
@Controller
public class ZCapitalManageController extends BaseController{
	@Resource
	private WithdrawOrderService withdrawOrderService;
	@Resource
	private MemberAccountDtlService memberAccountDtlService;
	@Resource
	private NovaPlanService novaPlanService;
	
	
	
	/**
	 * 阅读新星攻略，获取150积分
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/api/z/addReadStrategyIntegralH5")
	@ResponseBody
	public ResponseMsg addReadStrategyIntegral(HttpServletRequest request){
		try {
			JSONObject reqPRM = (JSONObject) request.getAttribute("reqPRM");
			JSONObject reqDataJson = reqPRM.getJSONObject("reqData");
			
			MemberInfo memberInfo = (MemberInfo) request.getSession().getAttribute(BaseDefine.MEMBER_INFO);
			novaPlanService.addReadStrategyIntegral(memberInfo);
			return new ResponseMsg(ResponseMsg.SUCCESS,ResponseMsg.SUCCESS_MSG);
		} catch (ArgException args){
			return new ResponseMsg(ResponseMsg.ERROR,args.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseMsg(ResponseMsg.ERROR,"");
		}
	}
}
