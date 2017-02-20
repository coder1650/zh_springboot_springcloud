package com.zh.aliService.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.zh.aliService.service.AliPayService;
import com.zh.model.constant.PayConstant;
import com.zh.model.entity.pay.ForwardPayParam;

@Service(value="aliWapPayServiceImpl")
public class AliWapPayServiceImpl implements AliPayService{
	

	@Override
	public String getPayUrl(ForwardPayParam forwardPayParam) throws AlipayApiException {
		double totalAmount =new BigDecimal(forwardPayParam.getPayMoney()).divide(new BigDecimal(100)).doubleValue();
		
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",forwardPayParam.getAppId(),forwardPayParam.getPrivateKey(),
				PayConstant.JSON_FORMAT,PayConstant.CHARSET,forwardPayParam.getPublicKey());
		 AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
		 alipayRequest.setReturnUrl(forwardPayParam.getRedirectUrl());
		 alipayRequest.setNotifyUrl(forwardPayParam.getNotifyUrl());//在公共参数中设置回跳和通知地址
		 
		 alipayRequest.setBizContent("{" +
		        "    \"out_trade_no\":\""+forwardPayParam.getRequestId()+"\"," +
		        "    \"total_amount\":"+totalAmount+"," +
		        "    \"subject\":\"Iphone6 16G\"," +
		        "    \"seller_id\":\"2088123456789012\"," +
		        "    \"product_code\":\"QUICK_WAP_PAY\"" +
		        "  }");//填充业务参数
		 return alipayClient.pageExecute(alipayRequest).getBody();		
	}
}
