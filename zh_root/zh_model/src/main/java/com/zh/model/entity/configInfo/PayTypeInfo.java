package com.zh.model.entity.configInfo;

/**
 * 支付类型信息
 * @author Administrator
 *
 */
public class PayTypeInfo {
	
	/**
	 * 应用编号
	 */
	private String appId;
	
	/**
	 * 支付渠道名称
	 */
	private String payChannelName;
	
	/**
	 * 支付渠道编码
	 */
	private int payChannelCode;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getPayChannelName() {
		return payChannelName;
	}

	public void setPayChannelName(String payChannelName) {
		this.payChannelName = payChannelName;
	}

	public int getPayChannelCode() {
		return payChannelCode;
	}

	public void setPayChannelCode(int payChannelCode) {
		this.payChannelCode = payChannelCode;
	}
	
	
	

}
