package com.zh.test.remoteService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("zh-dao")
public interface FeignRemoteService {
	
	@RequestMapping("/test01")
	public String test01(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
