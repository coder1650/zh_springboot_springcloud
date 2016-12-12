package com.zh.remote.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zh.entity.order.PayCpOrderInfo;

@FeignClient("zh-dao")
public interface OrderMapperService {
	
	@RequestMapping(value="/orderApi/findByTransId",method=RequestMethod.GET)
	public PayCpOrderInfo findByTransId(@RequestParam("transId") String transId);

}
