package com.zh.aliService.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.zh.aliService.service.AliPayService;
import com.zh.model.constant.PayConstant;
import com.zh.model.entity.configInfo.SysCpMerchantConfig;
import com.zh.model.entity.configInfo.SysPayChannelConfig;
import com.zh.model.entity.order.PayCpOrderInfo;
import com.zh.model.remoteService.dao.ConfigInfoMapperRemoteService;
import com.zh.model.remoteService.dao.OrderMapperService;

@Service(value="aliWapPayServiceImpl")
public class AliWapPayServiceImpl implements AliPayService{
	
	@Autowired
	private OrderMapperService orderMapperService;
	@Autowired
	private ConfigInfoMapperRemoteService configInfoMapperRemoteService;

	@Override
	public String getPayUrl(String transId,String cpMerchantId,String payChannelId) throws AlipayApiException {
		PayCpOrderInfo payCpOrderInfo =  orderMapperService.findByTransId(transId);
		SysCpMerchantConfig cpMerchantConfig = configInfoMapperRemoteService.findCpMerchantConfigById(cpMerchantId);
		SysPayChannelConfig payChannelConfig = configInfoMapperRemoteService.findPayChannelConfigById(payChannelId);
		double total_amount =new BigDecimal(payCpOrderInfo.getPayMoney()).divide(new BigDecimal(100)).doubleValue();
		
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do",cpMerchantConfig.getAppId(),cpMerchantConfig.getRsaPriKey(),
				PayConstant.JSON_FORMAT,PayConstant.CHARSET,cpMerchantConfig.getAliPubKey());
		 AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
		 alipayRequest.setReturnUrl(payChannelConfig.getRedirectUrl());
		 alipayRequest.setNotifyUrl(payChannelConfig.getNotifyUrl());//在公共参数中设置回跳和通知地址
		 
		 alipayRequest.setBizContent("{" +
		        "    \"out_trade_no\":\""+payCpOrderInfo.getTransId()+"\"," +
		        "    \"total_amount\":"+total_amount+"," +
		        "    \"subject\":\"Iphone6 16G\"," +
		        "    \"seller_id\":\"2088123456789012\"," +
		        "    \"product_code\":\"QUICK_WAP_PAY\"" +
		        "  }");//填充业务参数
		 String form = alipayClient.pageExecute(alipayRequest).getBody();		
		return form;
	}
	
	

}
