package com.zh.model.entity.pay;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.zh.model.constant.ChannelCode;
import com.zh.model.util.StringUtil;



/**
 * 生成第三方渠道交易号公用util
 * @author liuling
 *
 */
public class ThirdOrderUtil {
	public static String getServerOrder(String channelType){
		if (StringUtil.isEmpty(channelType)) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String beforeStr = "";
		if (ChannelCode.ALI_CHANNEL_CODE.equals(channelType)) {
			beforeStr = "ZFB";
		}else if (ChannelCode.WECHAT_CHANNEL_CODE.equals(channelType)) {
			beforeStr = "WX";
		}else if (ChannelCode.UNIONPAY_CHANNEL_CODE.equals(channelType)) {
			beforeStr = "YL";
		}else{
			beforeStr = "TY";
		}
		return beforeStr + dateFormat.format(new Date())+ StringUtil.getFixLenthString(6);
	}
}
