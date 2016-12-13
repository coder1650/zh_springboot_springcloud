package com.zh.model.entity.configInfo;

import java.util.Date;

public class SysCpMerchantConfig {
    private String id;

    private String channelCode;

    private String channelName;

    private String merchantName;

    private String merchantNo;

    private String partnerId;
    
    private String appId;

    private String appSecret;

    private String rsaPriKey;

    private String rsaPubKey;
    
    private String aliPubKey;

    private String md5Key;

    private String status;

    private String pubKeyCertUrl;

    private String priKeyCertUrl;

    private Integer limitMoney;

    private Date createTime;

    private Date updateTime;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    public String getRsaPriKey() {
        return rsaPriKey;
    }

    public void setRsaPriKey(String rsaPriKey) {
        this.rsaPriKey = rsaPriKey == null ? null : rsaPriKey.trim();
    }

    public String getRsaPubKey() {
        return rsaPubKey;
    }

    public void setRsaPubKey(String rsaPubKey) {
        this.rsaPubKey = rsaPubKey == null ? null : rsaPubKey.trim();
    }

    public String getMd5Key() {
        return md5Key;
    }

    public void setMd5Key(String md5Key) {
        this.md5Key = md5Key == null ? null : md5Key.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPubKeyCertUrl() {
        return pubKeyCertUrl;
    }

    public void setPubKeyCertUrl(String pubKeyCertUrl) {
        this.pubKeyCertUrl = pubKeyCertUrl == null ? null : pubKeyCertUrl.trim();
    }

    public String getPriKeyCertUrl() {
        return priKeyCertUrl;
    }

    public void setPriKeyCertUrl(String priKeyCertUrl) {
        this.priKeyCertUrl = priKeyCertUrl == null ? null : priKeyCertUrl.trim();
    }

    public Integer getLimitMoney() {
        return limitMoney;
    }

    public void setLimitMoney(Integer limitMoney) {
        this.limitMoney = limitMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId == null ? null : appId.trim();
	}

	public String getAliPubKey() {
		return aliPubKey;
	}

	public void setAliPubKey(String aliPubKey) {
		this.aliPubKey = aliPubKey == null ? null : aliPubKey.trim();
	}
    
    
}