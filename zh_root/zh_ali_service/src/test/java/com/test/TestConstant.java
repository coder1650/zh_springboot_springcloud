package com.test;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zh.model.constant.ChannelCode;
import com.zh.model.demo.User;

public class TestConstant {
	
	@Test
	public void testChannelCode() throws JsonGenerationException, JsonMappingException, IOException{
		System.out.println(ChannelCode.ALI_CHANNEL_TYPE.手机网站支付.getType().equals("100103"));
		ObjectMapper om = new ObjectMapper();
		User user = new User();
		user.setAge(18);
		user.setCreateTime(new Date());
		user.setLoginPassword("1234556");
		String json = null;
		
//		om.writeValue(json, user);
	}

}
