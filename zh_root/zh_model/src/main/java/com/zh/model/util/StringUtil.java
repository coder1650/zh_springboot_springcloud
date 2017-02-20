package com.zh.model.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;

/**
 * 字符串工具类
 */
public final class StringUtil {
	/** Private Constructor **/
	private StringUtil(){
	}
	
	/**
	 * 判断字符串是否非null && 非空字符 
	 * 
	 * @param param
	 * @return
	 */
	public static boolean isNotEmpty(String param) {
		return param != null && !"".equals(param.trim());
	}

	/**
	 * 判断字符串是否为null || 空字符串
	 * 
	 * @param param
	 * @return
	 */
	public static boolean isEmpty(String param) {
		return param == null || "".equals(param.trim());
	}
	public static void main(String[] args) {
		
	}
	
	/* 
	 * 返回长度为【strLength】的随机数，在前面补0 
	 */  
	public static String getFixLenthString(int strLength) {  
	      
	    Random rm = new Random();  
	      
	    // 获得随机数  
	    double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);  
	  
	    // 将获得的获得随机数转化为字符串  
	    String fixLenthString = String.valueOf(pross);  
	  
	    // 返回固定的长度的随机数  
	    return fixLenthString.substring(1, strLength + 1);  
	} 
	
	/**
	 * 返回固定长度的支付串，长度不足的前补或后补指定支付串
	 * @param sourceStr 被拓展支付串
	 * @param len 拓展长度
	 * @param extStr 拼接支付串
	 * @param isPref 拼接到支付串前
	 */
	public static String getFixLenthStr(String sourceStr,int len,char extStr,boolean isPref){
		int sourceStrLen = sourceStr.length();
		if( sourceStrLen >= len){
			return sourceStr;
		}
		if(isPref){
			for(int i = 0;(sourceStrLen+i) < len;i++){
				sourceStr = extStr+sourceStr;
			}
		}else{
			for(int i = 0;(sourceStrLen+i) < len;i++){
				sourceStr = sourceStr + extStr;
			}
		}
		return sourceStr;
	}
	
	/**
	 * 对map中的数据进行拼接，用&链接
	 */
	public static String build(SortedMap<String, String> signParams) {
		StringBuffer sb = new StringBuffer();
		Set<?> es = signParams.entrySet();
		Iterator<?> it = es.iterator();
		while (it.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			sb.append(k + "=" + v + "&");
			// 要采用URLENCODER的原始值！
		}
		 String params = sb.substring(0, sb.lastIndexOf("&"));
		return params;
	}
}
