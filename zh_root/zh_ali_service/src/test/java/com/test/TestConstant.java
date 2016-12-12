package com.test;

import org.junit.Test;

import com.zh.constant.ChannelCode;

public class TestConstant {
	
	@Test
	public void testChannelCode(){
		System.out.println(ChannelCode.CHANNEL_TYPE.手机网站支付.getType().equals("100103"));
	}

}
