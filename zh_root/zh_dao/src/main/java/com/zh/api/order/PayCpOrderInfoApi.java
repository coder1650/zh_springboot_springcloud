package com.zh.api.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zh.entity.order.PayCpOrderInfo;
import com.zh.mapper.order.PayCpOrderInfoMapper;

@RestController
@RequestMapping("/orderApi")
public class PayCpOrderInfoApi {
	@Autowired
	private PayCpOrderInfoMapper payCpOrderInfoMapper;
	
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public String insertPayCpOrderInfo(@RequestBody PayCpOrderInfo payCpOrderInfo){
		
		payCpOrderInfoMapper.insertPayCpOrderInfo(payCpOrderInfo);
		
		return "SUCCESS";
		
	}
	
	

}
