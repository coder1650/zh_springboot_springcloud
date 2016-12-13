package com.zh.model.remoteService.aliService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("zh-ali-service")
public interface AliPayRemoteService {
	
	@RequestMapping(value="/payApi/getPayUrl",method=RequestMethod.GET)
	public String getPayUrl(@RequestParam("transId") String transId,@RequestParam("channelCode") String channelCode,
			@RequestParam("cpMerchantId") String cpMerchantId,@RequestParam("payChannelId") String payChannelId);

}
