package com.zh.model.remoteService.aliService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zh.model.entity.pay.ForwardPayParam;

@FeignClient("zh-ali-service")
public interface AliPayRemoteService {
	
	@RequestMapping(value="/aliPayApi/getPayUrl",method=RequestMethod.POST)
	public String getPayUrl(ForwardPayParam forwardPayParam);

}
