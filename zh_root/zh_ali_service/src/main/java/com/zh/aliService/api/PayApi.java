package com.zh.aliService.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.zh.aliService.service.AliPayService;
import com.zh.model.constant.ChannelCode;
import com.zh.model.entity.pay.ForwardPayParam;

@RestController
@RequestMapping("/aliPayApi")
public class PayApi {
	
	@Autowired
	private AliPayService aliWapPayServiceImpl;
	
	@RequestMapping(value="/getPayUrl",method=RequestMethod.POST,produces="application/json")
	public  String getPayUrl(@RequestBody ForwardPayParam forwardPayParam) throws AlipayApiException{
		if(ChannelCode.ALI_CHANNEL_TYPE.手机网站支付.getType().equals(forwardPayParam.getPayChannelCode())){
			String payUrl = aliWapPayServiceImpl.getPayUrl(forwardPayParam);
			return payUrl;
		}else{
			return null;
		}
	}

}
