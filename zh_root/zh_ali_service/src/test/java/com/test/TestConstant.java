package com.test;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestConstant {
	
	@Test
	public void testChannelCode() throws JsonGenerationException, JsonMappingException, IOException{
//		System.out.println(ChannelCode.ALI_CHANNEL_TYPE.手机网站支付.getType().equals("100103"));
		ObjectMapper om = new ObjectMapper();
		String s = om.writeValueAsString("123456");
		
		String str = om.readValue(s, s.getClass());
		System.out.println(str);
	}

}
