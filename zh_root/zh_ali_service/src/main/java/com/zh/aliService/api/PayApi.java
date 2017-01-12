package com.zh.aliService.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.zh.aliService.service.AliPayService;
import com.zh.model.constant.ChannelCode;

@RestController
@RequestMapping("/payApi")
public class PayApi {
	
	@Autowired
	private AliPayService aliWapPayServiceImpl;
	
	@RequestMapping(value="/getPayUrl",method=RequestMethod.GET,produces="application/json")
	public  String getPayUrl(@RequestParam("transId") String transId,@RequestParam("channelCode") String channelCode,
			@RequestParam("cpMerchantId") String cpMerchantId,@RequestParam("payChannelId") String payChannelId) throws AlipayApiException{
		if(ChannelCode.ALI_CHANNEL_TYPE.手机网站支付.getType().equals(channelCode)){
			String payUrl = aliWapPayServiceImpl.getPayUrl(transId,cpMerchantId,payChannelId);
			return payUrl;
		}else{
			return null;
		}
	}

}
