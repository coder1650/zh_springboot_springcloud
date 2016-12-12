package com.zh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zh.entity.order.PayCpOrderInfo;
import com.zh.remote.service.OrderMapperService;
import com.zh.service.AliPayService;

@Service(value="aliWapPayServiceImpl")
public class AliWapPayServiceImpl implements AliPayService{
	
	@Autowired
	private OrderMapperService orderMapperService;

	@Override
	public String getPayUrl(String transId) {
		PayCpOrderInfo payCpOrderInfo =  orderMapperService.findByTransId(transId);
		return payCpOrderInfo.getTransId();
	}
	
	

}
