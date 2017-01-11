package com.zh.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zh.model.constant.ChannelCode;
import com.zh.model.entity.configInfo.PayTypeInfo;
import com.zh.model.entity.configInfo.SysCpAppPayMapping;
import com.zh.model.entity.order.PayCpOrderInfo;
import com.zh.model.remoteService.aliService.AliPayRemoteService;
import com.zh.model.remoteService.dao.ConfigInfoMapperRemoteService;
import com.zh.model.remoteService.dao.OrderMapperService;
import com.zh.service.util.CreateTransId;

@RestController
@RequestMapping("/orderService")
public class OrderServiceController {
	@Autowired
	private OrderMapperService orderMapperService;
	@Autowired
	private ConfigInfoMapperRemoteService configInfoMapperRemoteService;
	@Autowired
	private AliPayRemoteService aliPayRemoteService;
	
	@RequestMapping(value="/getTransId",method=RequestMethod.POST)
	public String savePayCpOrderInfo(@RequestBody PayCpOrderInfo orderInfo){
		String transId = CreateTransId.getTransId();
		orderInfo.setTransId(transId);
		orderMapperService.insertPayCpOrderInfo(orderInfo);
		return transId;
	}
	
	/**
	 * 根据app_id查询支持的支付方式
	 * @param appId
	 * @param platType
	 * {@link com.zh.model.remoteService.service.OrderServiceRemoteService#findPayTypeInfoOfAppId}
	 * @return
	 */
	@RequestMapping(value="/findPayTypeInfoOfAppId",method=RequestMethod.GET)
	public List<PayTypeInfo> findPayTypeInfoOfAppId(@RequestParam("appId") String appId,@RequestParam("platType") String platType){
		List<PayTypeInfo> payTypeInfos = configInfoMapperRemoteService.findPayTypeInfoOfAppId(appId, platType);
		return payTypeInfos;
	}
	
	@RequestMapping(value="/getPayUrl",method=RequestMethod.GET)
	public String getPayUrl(@RequestParam("transId") String transId,@RequestParam("cpPayMappingId") String cpPayMappingId){
		SysCpAppPayMapping cpPayMapping = configInfoMapperRemoteService.findCpAppPayMappingById(cpPayMappingId);
		String payChannelCode = cpPayMapping.getPayChannelCode();
		String payUrl = "";
		if(payChannelCode.startsWith(ChannelCode.ALI_CHANNEL_CODE)){
			payUrl = aliPayRemoteService.getPayUrl(transId, payChannelCode,cpPayMapping.getCpMerchantId(),cpPayMapping.getPayChannelId());
		}
		return payUrl;
	}

}
