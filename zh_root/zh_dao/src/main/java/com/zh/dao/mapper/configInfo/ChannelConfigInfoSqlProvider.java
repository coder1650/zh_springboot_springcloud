package com.zh.dao.mapper.configInfo;

import org.apache.ibatis.jdbc.SQL;


public class ChannelConfigInfoSqlProvider {
	
	public String findCpAppPayMappingById(final int id){
		return new SQL(){{
			SELECT("*");
			FROM("SYS_CP_APPPAY_MAPPING S");
			WHERE("S.ID=#{id}");
		}}.toString();
	}
	
	public String findCpMerchantConfigById(final int id){
		return new SQL(){{
			SELECT("*");
			FROM("SYS_CP_MERCHANT_CONFIG S");
			WHERE("S.CP_MERCHANT_ID=#{id}");
		}}.toString();
	}
	
	public String findPayChannelConfigById(final int id){
		return new SQL(){{
			SELECT("*");
			FROM("SYS_PAY_CHANNEL_CONFIG S");
			WHERE("S.PAY_CHANNEL_ID=#{id}");
		}}.toString();
	}
	
	public String findPayTypeInfoOfAppId(final String appId,final String platType){
		return new SQL(){{
			SELECT("mapping.id,mapping.app_id as appId,channel.channel_name as payChannelName,channel.pay_channel_code as payChannelCode,channel.image_logo_url as imageLogoUrl");
			FROM("sys_cp_apppay_mapping mapping");
			LEFT_OUTER_JOIN("sys_cp_merchant_config merch ON mapping.cp_merchant_id = merch.cp_merchant_id");
			LEFT_OUTER_JOIN("sys_pay_channel_config channel ON mapping.pay_channel_id = channel.pay_channel_id");
			WHERE("mapping.app_id=#{appId} AND sysdate() BETWEEN mapping.validate_time and mapping.expire_date AND channel.plat_type=#{platType} AND mapping.state='0'");
		}}.toString();
	}

}
