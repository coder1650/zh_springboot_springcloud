package com.zh.aliService.service;

import com.alipay.api.AlipayApiException;
import com.zh.model.entity.pay.ForwardPayParam;

public interface AliPayService {
	
	/**
	 * 获取跳转到支付宝收银台的url
	 * @param transId
	 * @return
	 */
	public String getPayUrl(ForwardPayParam forwardPayParam) throws AlipayApiException;

}
