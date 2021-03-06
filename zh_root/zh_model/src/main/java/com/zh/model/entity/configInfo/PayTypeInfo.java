package com.zh.model.entity.configInfo;

/**
 * 支付类型信息
 * @author Administrator
 *
 */
public class PayTypeInfo {
	
	/**
	 * 主键id
	 */
	private int id;
	
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
	
	/**
	 * 支付方式对应的logo
	 */
	private String imageLogoUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getImageLogoUrl() {
		return imageLogoUrl;
	}

	public void setImageLogoUrl(String imageLogoUrl) {
		this.imageLogoUrl = imageLogoUrl;
	}
	
}
