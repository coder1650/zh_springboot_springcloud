package com.zh.dao.mapper.configInfo;

import org.apache.ibatis.jdbc.SQL;


public class ChannelConfigInfoSqlProvider {
	
	public String findCpAppPayMappingById(final String id){
		return new SQL(){{
			SELECT("*");
			FROM("SYS_CP_APP_PAY_MAPPING S");
			WHERE("S.ID=#{id}");
		}}.toString();
	}
	
	public String findCpMerchantConfigById(final String id){
		return new SQL(){{
			SELECT("*");
			FROM("SYS_CP_MERCHANT_CONFIG S");
			WHERE("S.ID=#{id}");
		}}.toString();
	}
	
	public String findPayChannelConfigById(final String id){
		return new SQL(){{
			SELECT("*");
			FROM("SYS_PAY_CHANNEL_CONFIG S");
			WHERE("S.ID=#{id}");
		}}.toString();
	}

}
