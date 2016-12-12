package com.zh.entity.configInfo;

import java.util.Date;

public class SysPayChannelConfig {
    private String id;

    private String channelCode;

    private String payChannelCode;

    private String channelName;

    private String imageLogoUrl;

    private String applyPayUrl;

    private String payVersion;

    private String redirectUrl;

    private String notifyUrl;

    private String refundNotifyUrl;

    private String payStopUrl;

    private String status;

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

    public String getPayChannelCode() {
        return payChannelCode;
    }

    public void setPayChannelCode(String payChannelCode) {
        this.payChannelCode = payChannelCode == null ? null : payChannelCode.trim();
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getImageLogoUrl() {
        return imageLogoUrl;
    }

    public void setImageLogoUrl(String imageLogoUrl) {
        this.imageLogoUrl = imageLogoUrl == null ? null : imageLogoUrl.trim();
    }

    public String getApplyPayUrl() {
        return applyPayUrl;
    }

    public void setApplyPayUrl(String applyPayUrl) {
        this.applyPayUrl = applyPayUrl == null ? null : applyPayUrl.trim();
    }

    public String getPayVersion() {
        return payVersion;
    }

    public void setPayVersion(String payVersion) {
        this.payVersion = payVersion == null ? null : payVersion.trim();
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl == null ? null : redirectUrl.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public String getRefundNotifyUrl() {
        return refundNotifyUrl;
    }

    public void setRefundNotifyUrl(String refundNotifyUrl) {
        this.refundNotifyUrl = refundNotifyUrl == null ? null : refundNotifyUrl.trim();
    }

    public String getPayStopUrl() {
        return payStopUrl;
    }

    public void setPayStopUrl(String payStopUrl) {
        this.payStopUrl = payStopUrl == null ? null : payStopUrl.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
}