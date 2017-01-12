package com.zh.web.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zh.model.constant.PayConstant;
import com.zh.model.entity.configInfo.PayTypeInfo;
import com.zh.model.entity.order.PayCpOrderInfo;
import com.zh.model.remoteService.service.OrderServiceRemoteService;

/**
 * 订单操作相关接口(对外暴露)
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/orderOpenApi")
public class OrderController {
	@Autowired
	private OrderServiceRemoteService orderServiceRemoteService;
	
	
	/**
	 * 商户下单后返回trans_id(平台生成交易流水号)
	 * @param orderInfo
	 * @return
	 */
	@RequestMapping(value="/getTransId",method=RequestMethod.POST,produces="application/json")
	public String savePayCpOrderInfo(PayCpOrderInfo orderInfo){
		orderInfo.setPayMoney(orderInfo.getApplyMoney());
		return orderServiceRemoteService.getTransId(orderInfo);
	}
	
	/**
	 * 根据app_id查询支持的支付方式
	 * @param appId
	 * @param platType
	 * @return
	 */
	@RequestMapping(value="/findPayTypeInfoOfAppId",method=RequestMethod.GET,produces="application/json")
	public List<PayTypeInfo> findPayTypeInfoOfAppId(@RequestParam("appId") String appId,@RequestParam("platType") String platType){
		List<PayTypeInfo> tt = orderServiceRemoteService.findPayTypeInfoOfAppId(appId, platType);
		return  tt;
	}
	
	@RequestMapping(value="/findOrderInfoByTransId",method=RequestMethod.GET,produces="application/json")
	public PayCpOrderInfo findOrderInfoByTransId(@RequestParam("transId") String transId){
		return orderServiceRemoteService.findByTransId(transId);
	}
	
	/**
	 * 判断指定trans_id的订单是否已经支付
	 * @param transId
	 * @return
	 */
	@RequestMapping(value="isPayOfTransId",method=RequestMethod.GET,produces="application/json")
	public boolean isPayOfTransId(@RequestParam("transId") String transId){
		return orderServiceRemoteService.isPayOfTransId(transId);
	}
	
	
	/**
	 * 根据trans_id和应用支付方式关系id获取支付url
	 * @param transId
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/getPayUrl",method=RequestMethod.GET,produces="application/json")
	public String getPayUrl(@RequestParam("transId") String transId,@RequestParam("cpPayMappingId") String cpPayMappingId,
			HttpServletResponse httpResponse) throws IOException{
//		cpPayMappingId = "aeabf77dc04c11e6b00598be94487602";
//		transId = "TEST32201612131616123561279";
		String payUrl = orderServiceRemoteService.getPayUrl(transId, cpPayMappingId);
		httpResponse.setContentType("text/html;charset=" + PayConstant.CHARSET);
		httpResponse.getWriter().write(payUrl);//直接将完整的表单html输出到页面
		httpResponse.getWriter().flush();
		return null;
	}

}
