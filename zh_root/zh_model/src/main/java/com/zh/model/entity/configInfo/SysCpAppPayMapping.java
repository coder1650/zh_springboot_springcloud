package com.zh.model.entity.configInfo;

import java.util.Date;

public class SysCpAppPayMapping {
    private String id;

    private String appId;

    private int cpMerchantId;

    private int payChannelId;

    private int cpId;

    private String cpName;

    private String payChannelCode;

    private Date validateTime;

    private Date expireDate;

    private String state;

    private String priorityLevel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public int getCpMerchantId() {
        return cpMerchantId;
    }

    public void setCpMerchantId(int cpMerchantId) {
        this.cpMerchantId = cpMerchantId;
    }

    public int getPayChannelId() {
        return payChannelId;
    }

    public void setPayChannelId(int payChannelId) {
        this.payChannelId = payChannelId;
    }

    public int getCpId() {
        return cpId;
    }

    public void setCpId(int cpId) {
        this.cpId = cpId;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName == null ? null : cpName.trim();
    }

    public String getPayChannelCode() {
        return payChannelCode;
    }

    public void setPayChannelCode(String payChannelCode) {
        this.payChannelCode = payChannelCode == null ? null : payChannelCode.trim();
    }

    public Date getValidateTime() {
        return validateTime;
    }

    public void setValidateTime(Date validateTime) {
        this.validateTime = validateTime;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel == null ? null : priorityLevel.trim();
    }
}