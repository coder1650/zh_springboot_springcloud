package com.zh.service;

public interface AliPayService {
	
	/**
	 * 获取跳转到支付宝收银台的url
	 * @param transId
	 * @return
	 */
	public String getPayUrl(String transId);

}
