package com.zh.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zh.model.constant.PayStateConstant;
import com.zh.model.entity.configInfo.PayTypeInfo;
import com.zh.model.entity.order.PayCpOrderInfo;
import com.zh.model.remoteService.dao.ConfigInfoMapperRemoteService;
import com.zh.model.remoteService.dao.OrderMapperRemoteService;
import com.zh.service.util.CreateTransId;

@RestController
@RequestMapping("/orderServiceApi")
public class OrderServiceController {
	@Autowired
	private OrderMapperRemoteService orderMapperService;
	@Autowired
	private ConfigInfoMapperRemoteService configInfoMapperRemoteService;
	
	@RequestMapping(value="/getTransId",method=RequestMethod.POST,produces="application/json")
	public String savePayCpOrderInfo(@RequestBody PayCpOrderInfo orderInfo){
		String transId = CreateTransId.getTransId();
		orderInfo.setTransId(transId);
		orderMapperService.insertPayCpOrderInfo(orderInfo);
		return transId;
	}
	
	/**
	 * 根据app_id查询支持的支付方式
	 * @param appId
	 * @param platType
	 * {@link com.zh.model.remoteService.service.OrderServiceRemoteService#findPayTypeInfoOfAppId}
	 * @return
	 */
	@RequestMapping(value="/findPayTypeInfoOfAppId",method=RequestMethod.GET,produces="application/json")
	public List<PayTypeInfo> findPayTypeInfoOfAppId(@RequestParam("appId") String appId,@RequestParam("platType") String platType){
		List<PayTypeInfo> payTypeInfos = configInfoMapperRemoteService.findPayTypeInfoOfAppId(appId, platType);
		return payTypeInfos;
	}
	
	/**
	 * 根据trans_id查询订单信息
	 * @param transId
	 * {@link com.zh.model.remoteService.service.OrderServiceRemoteService#findByTransId}
	 * @return
	 */
	@RequestMapping(value="findByTransId",method=RequestMethod.GET,produces="application/json")
	public PayCpOrderInfo findByTransId(@RequestParam("transId") String transId){
		return orderMapperService.findByTransId(transId);
	}
	
	/**
	 * 判断指定trans_id的订单是否已经支付
	 * @param transId
	 * @return
	 */
	@RequestMapping(value="isPayOfTransId",method=RequestMethod.GET,produces="application/json")
	public boolean isPayOfTransId(@RequestParam("transId") String transId){
		String payState = orderMapperService.findPayStateOfOrderByTransId(transId);
		if(PayStateConstant.PAY_SUCCESS.equals(payState)){
			return true;
		}
		return false;
		
	}
	
}
