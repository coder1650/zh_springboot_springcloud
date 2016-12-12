package com.zh.mapper.order;

import org.apache.ibatis.jdbc.SQL;

import com.zh.entity.order.PayCpOrderInfo;

public class PayCpOrderInfoSqlProvider {
	
	public String insertPayCpOrderInfo(final PayCpOrderInfo payCpOrderInfo){
		return new SQL(){{
			INSERT_INTO("PAY_CP_ORDER_INFO");
			VALUES("ID,TRANS_ID,CP_ORDER_NO,APP_ID,WARE_ID,WARE_NAME,APPLY_MONEY", "#{id},#{transId},#{cpOrderNo},#{appId},#{wareId},#{wareName},#{applyMoney}");
			VALUES("currency,user_id,cp_re_info,notify_url,redirect_url,cp_url", "#{currency},#{userId},#{cpReInfo},#{notifyUrl},#{redirectUrl},#{cpUrl}");
			VALUES("pay_state,channel_code,pay_channel_code,pay_money,create_time,last_update_time", "#{payState},#{channelCode},#{payChannelCode},#{payMoney},#{createTime},#{lastUpdateTime}");
			VALUES("finish_time", "#{finishTime}");
		}}.toString();
		
	}
	
	public String findByTransId(final String transId){
		return new SQL(){{
			SELECT("*");
			FROM("PAY_CP_ORDER_INFO P");
			WHERE("P.TRANS_ID=#{transId}");
		}}.toString();
	}

}
