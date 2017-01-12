package com.zh.model.remoteService.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zh.model.entity.configInfo.PayTypeInfo;
import com.zh.model.entity.order.PayCpOrderInfo;

@FeignClient("zh-service")
public interface OrderServiceRemoteService {
	
	@RequestMapping(value="/orderService/getTransId",method=RequestMethod.POST)
	public String getTransId(PayCpOrderInfo payCpOrderInfo);
	
	@RequestMapping(value="/orderService/getPayUrl",method=RequestMethod.GET)
	public String getPayUrl(@RequestParam("transId") String transId,@RequestParam("cpPayMappingId") String cpPayMappingId);
	
	@RequestMapping(value="/orderService/findPayTypeInfoOfAppId",method=RequestMethod.GET)
	public List<PayTypeInfo> findPayTypeInfoOfAppId(@RequestParam("appId") String appId,@RequestParam("platType") String platType);
	
	
	@RequestMapping(value="/orderService/findByTransId",method=RequestMethod.GET)
	public PayCpOrderInfo findByTransId(@RequestParam("transId") String transId);
	
	/**
	 * 判断指定trans_id的订单是否已经支付
	 * @param transId
	 * @return
	 */
	@RequestMapping(value="/orderService/isPayOfTransId",method=RequestMethod.GET)
	public boolean isPayOfTransId(@RequestParam("transId") String transId);
	

}
