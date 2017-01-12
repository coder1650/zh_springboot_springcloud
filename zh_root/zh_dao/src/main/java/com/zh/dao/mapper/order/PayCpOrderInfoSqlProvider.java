package com.zh.dao.mapper.order;


import org.apache.ibatis.jdbc.SQL;

import com.zh.model.entity.order.PayCpOrderInfo;

public class PayCpOrderInfoSqlProvider {
	
	public String insertPayCpOrderInfo(final PayCpOrderInfo payCpOrderInfo){
		return new SQL(){{
			INSERT_INTO("PAY_CP_ORDER_INFO");
			VALUES("TRANS_ID,CP_ORDER_NO,APP_ID,WARE_ID,WARE_NAME,APPLY_MONEY", "#{transId},#{cpOrderNo},#{appId},#{wareId},#{wareName},#{applyMoney}");
			VALUES("currency,user_id,cp_re_info,notify_url,redirect_url,cp_url", "#{currency},#{userId},#{cpReInfo},#{notifyUrl},#{redirectUrl},#{cpUrl}");
			VALUES("pay_state,channel_code,pay_channel_code,pay_money,create_time,last_update_time", "#{payState},#{channelCode},#{payChannelCode},#{payMoney},now(),now()");
			VALUES("finish_time", "now()");
		}}.toString();
		
	}
	
	public String findByTransId(final String transId){
		return new SQL(){{
			SELECT("*");
			FROM("PAY_CP_ORDER_INFO P");
			WHERE("P.TRANS_ID=#{transId}");
		}}.toString();
	}
	
	public String findPayStateOfOrderByTransId(final String transId){
		return new SQL(){{
			SELECT("P.pay_state AS payState");
			FROM("PAY_CP_ORDER_INFO P");
			WHERE("P.TRANS_ID=#{transId}");
		}}.toString();
	}

}
