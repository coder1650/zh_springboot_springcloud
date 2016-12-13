package com.zh.model.remoteService.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zh.model.entity.order.PayCpOrderInfo;

@FeignClient("zh-service")
public interface OrderServiceRemoteService {
	
	@RequestMapping(value="/orderService/getTransId",method=RequestMethod.POST)
	public String getTransId(PayCpOrderInfo payCpOrderInfo);
	
	@RequestMapping(value="/orderService/getPayUrl",method=RequestMethod.GET)
	public String getPayUrl(@RequestParam("transId") String transId,@RequestParam("cpPayMappingId") String cpPayMappingId);

}
