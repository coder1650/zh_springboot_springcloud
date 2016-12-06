package com.zh.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zh.demo.User;
import com.zh.test.remoteService.FeignRemoteService;
import com.zh.test.remoteService.UserRemoteService;

@RestController
public class TestFeignController {
	
	@Autowired
	private FeignRemoteService feignRemoteService;
	@Autowired
	private UserRemoteService userRemoteService;
	
	@RequestMapping(value="/test01",method=RequestMethod.GET)
	public String test01(){
		return feignRemoteService.test01(5, 10);
	}
	
	@RequestMapping(value="/findUserByName",method=RequestMethod.GET)
	public User findUserByName(){
		return userRemoteService.findUserByName("zhangsan");
	}

}
