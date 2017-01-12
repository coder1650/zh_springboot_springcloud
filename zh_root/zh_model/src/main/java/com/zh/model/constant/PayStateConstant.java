package com.zh.model.constant;

/**
 * 订单支付状态相关常量
 * @author Administrator
 *
 */
public class PayStateConstant {
	
	/**
	 * 0-发起支付
	 */
	public final static String PAY_BEGIN = "0";
	/**
	 * 1-支付处理中
	 */
	public final static String PAY_DEALING = "1";
	/**
	 * 2-支付成功
	 */
	public final static String PAY_SUCCESS = "2";
	/**
	 * 9-支付失败
	 */
	public final static String PAY_FAIL = "-9";

}
