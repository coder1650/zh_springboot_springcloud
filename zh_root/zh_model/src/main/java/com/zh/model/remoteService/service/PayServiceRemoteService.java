package com.zh.model.remoteService.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("zh-service")
public interface PayServiceRemoteService {
	
	@RequestMapping(value="/payServiceApi/getForwardPayUrl",method=RequestMethod.GET)
	public String getForwardPayUrl(@RequestParam("transId") String transId,@RequestParam("payMappingId") int payMappingId);

}
