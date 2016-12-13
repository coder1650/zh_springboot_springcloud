package com.zh.dao.api.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zh.dao.mapper.order.PayCpOrderInfoMapper;
import com.zh.model.entity.order.PayCpOrderInfo;

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
	
	@RequestMapping(value="findByTransId",method=RequestMethod.GET)
	public PayCpOrderInfo findByTransId(@RequestParam("transId") String transId){
		return payCpOrderInfoMapper.findByTransId(transId);
	}
	
	

}
