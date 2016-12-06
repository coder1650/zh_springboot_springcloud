package com.zh.test.remoteService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zh.demo.User;

@FeignClient("zh-dao")
public interface UserRemoteService {
	
	@RequestMapping("/findUserByName")
	public User findUserByName(@RequestParam(value="userName") String userName);

}
