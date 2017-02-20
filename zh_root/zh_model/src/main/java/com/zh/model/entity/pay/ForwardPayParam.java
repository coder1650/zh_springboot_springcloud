package com.zh.model.entity.pay;

/**
 * 向第三方渠道请求支付所需参数
 * @author Administrator
 *
 */
public class ForwardPayParam {
	
	private String pId;
	private String merchNo;
	private String merchName;
	/**
	 * 支付宝开发平台应用id
	 */
	private String appId;
	
	/**
	 * 私钥
	 */
	private String privateKey;
	
	/**
	 * 公钥
	 */
	private String publicKey;
	
	/**
	 * 用于接收异步通知的地址
	 */
	private String notifyUrl;
	
	/**
	 * 用于接收同步通知的地址
	 */
	private String redirectUrl;
	
	/**
	 * 平台生成的用于向第三方渠道下单的订单号，在第三方渠道标示平台订单
	 */
	private String requestId;
	
	/**
	 * 支付渠道编码
	 */
	private String payChannelCode;
	
	//订单信息
	
	private int payMoney;

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getMerchNo() {
		return merchNo;
	}

	public void setMerchNo(String merchNo) {
		this.merchNo = merchNo;
	}

	public String getMerchName() {
		return merchName;
	}

	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public int getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}

	public String getPayChannelCode() {
		return payChannelCode;
	}

	public void setPayChannelCode(String payChannelCode) {
		this.payChannelCode = payChannelCode;
	}
}
