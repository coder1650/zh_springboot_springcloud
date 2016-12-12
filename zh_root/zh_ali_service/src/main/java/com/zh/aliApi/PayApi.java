package com.zh.aliApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zh.constant.ChannelCode;
import com.zh.service.AliPayService;

@RestController
@RequestMapping("/payApi")
public class PayApi {
	
	@Autowired
	private AliPayService aliWapPayServiceImpl;
	
	@RequestMapping(value="/getPayUrl",method=RequestMethod.GET)
	public String getPayUrl(@RequestParam("transId") String transId,@RequestParam("channelCode") String channelCode){
		if(ChannelCode.CHANNEL_TYPE.手机网站支付.getType().equals(channelCode)){
			return aliWapPayServiceImpl.getPayUrl(transId);
		}else{
			return null;
		}
	}

}
