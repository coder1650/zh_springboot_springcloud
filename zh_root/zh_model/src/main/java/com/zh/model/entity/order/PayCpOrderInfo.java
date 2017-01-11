package com.zh.model.entity.order;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;


public class PayCpOrderInfo{
   
	private String id;

    private String transId;

    private String cpOrderNo;

    private String appId;

    private String wareId;

    private String wareName;

    private Integer applyMoney;

    private String currency;

    private String userId;

    private String cpReInfo;

    private String notifyUrl;

    private String redirectUrl;

    private String cpUrl;

    private String payState;

    private String channelCode;

    private String payChannelCode;

    private Integer payMoney;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date finishTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId == null ? null : transId.trim();
    }

    public String getCpOrderNo() {
        return cpOrderNo;
    }

    public void setCpOrderNo(String cpOrderNo) {
        this.cpOrderNo = cpOrderNo == null ? null : cpOrderNo.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getWareId() {
        return wareId;
    }

    public void setWareId(String wareId) {
        this.wareId = wareId == null ? null : wareId.trim();
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName == null ? null : wareName.trim();
    }

    public Integer getApplyMoney() {
        return applyMoney;
    }

    public void setApplyMoney(Integer applyMoney) {
        this.applyMoney = applyMoney;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCpReInfo() {
        return cpReInfo;
    }

    public void setCpReInfo(String cpReInfo) {
        this.cpReInfo = cpReInfo == null ? null : cpReInfo.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl == null ? null : redirectUrl.trim();
    }

    public String getCpUrl() {
        return cpUrl;
    }

    public void setCpUrl(String cpUrl) {
        this.cpUrl = cpUrl == null ? null : cpUrl.trim();
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState == null ? null : payState.trim();
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public String getPayChannelCode() {
        return payChannelCode;
    }

    public void setPayChannelCode(String payChannelCode) {
        this.payChannelCode = payChannelCode == null ? null : payChannelCode.trim();
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
}