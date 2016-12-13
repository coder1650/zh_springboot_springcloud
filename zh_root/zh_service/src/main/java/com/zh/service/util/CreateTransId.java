package com.zh.service.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateTransId {
	
	public static String getTransId(){
		//测试用
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return "TEST32"+dateFormat.format(new Date())+ StringUtil.getFixLenthString(4);
	}

}
