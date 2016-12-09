package com.zh.test.remoteService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zh.demo.User;
import com.zh.entity.order.PayCpOrderInfo;


@FeignClient("zh-dao")
public interface UserRemoteService {
	
	@RequestMapping("/findUserByName")
	public User findUserByName(@RequestParam(value="userName") String userName);
	
	//插入订单信息
	@RequestMapping(value="/orderApi/insert",method=RequestMethod.POST)
//	@Headers("Content-Type: application/json")
	public String insertPayCpOrderInfo(PayCpOrderInfo payCpOrderInfo);

}
