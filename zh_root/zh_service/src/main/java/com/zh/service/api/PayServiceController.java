package com.zh.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zh.model.constant.ChannelCode;
import com.zh.model.entity.configInfo.SysCpAppPayMapping;
import com.zh.model.entity.configInfo.SysCpMerchantConfig;
import com.zh.model.entity.configInfo.SysPayChannelConfig;
import com.zh.model.entity.order.PayCpOrderInfo;
import com.zh.model.entity.pay.ForwardPayParam;
import com.zh.model.entity.pay.ThirdOrderUtil;
import com.zh.model.remoteService.aliService.AliPayRemoteService;
import com.zh.model.remoteService.dao.ConfigInfoMapperRemoteService;
import com.zh.model.remoteService.dao.OrderMapperRemoteService;


@RestController
@RequestMapping("/payServiceApi")
public class PayServiceController {
	@Autowired
	private OrderMapperRemoteService orderMapperService;
	@Autowired
	private AliPayRemoteService aliPayRemoteService;
	@Autowired
	private ConfigInfoMapperRemoteService configInfoMapperRemoteService;
	
	@RequestMapping(value="/getForwardPayUrl",method=RequestMethod.GET,produces="application/json")
	public String getForwardPayUrl(@RequestParam("transId") String transId,@RequestParam("payMappingId") int payMappingId){
		String forwardPayUrl = null;
		PayCpOrderInfo payCpOrderInfo = orderMapperService.findByTransId(transId);
		SysCpAppPayMapping appPayMapping = configInfoMapperRemoteService.findCpAppPayMappingById(payMappingId);
		SysCpMerchantConfig merConfig = configInfoMapperRemoteService.findCpMerchantConfigById(appPayMapping.getCpMerchantId());
		SysPayChannelConfig payChannelConfig = configInfoMapperRemoteService.findPayChannelConfigById(appPayMapping.getPayChannelId());
		String requestId = ThirdOrderUtil.getServerOrder(String.valueOf(appPayMapping.getCpId()));
		ForwardPayParam param = new ForwardPayParam();
		param.setPayMoney(payCpOrderInfo.getPayMoney());
		param.setRequestId(requestId);
		param.setNotifyUrl(payChannelConfig.getNotifyUrl());
		param.setRedirectUrl(payChannelConfig.getRedirectUrl());
		param.setPayChannelCode(appPayMapping.getPayChannelCode());
		if(ChannelCode.ALI_CHANNEL_CODE.equals(merConfig.getChannelCode())){
			param.setpId(merConfig.getPartnerId());
			param.setAppId(merConfig.getAliAppId());
			param.setPrivateKey(merConfig.getRsaPriKey());
			param.setPublicKey(merConfig.getRsaPubKey());
			forwardPayUrl = aliPayRemoteService.getPayUrl(param);
		}
		return forwardPayUrl;
		
	}

}
