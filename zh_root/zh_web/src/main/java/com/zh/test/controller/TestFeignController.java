package com.zh.test.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zh.demo.User;
import com.zh.entity.order.PayCpOrderInfo;
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
	
	@RequestMapping(value="/insertOrder",method=RequestMethod.GET)
	public String insertOrder(){
		PayCpOrderInfo order = new PayCpOrderInfo();
		order.setAppId("111111");
		order.setTransId("121212");
		order.setApplyMoney(10000);
		order.setPayMoney(9888);
		order.setCreateTime(new Date());
		return userRemoteService.insertPayCpOrderInfo(order);
	}

}
