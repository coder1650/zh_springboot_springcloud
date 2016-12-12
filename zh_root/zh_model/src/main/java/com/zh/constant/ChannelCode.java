package com.zh.constant;

public class ChannelCode {
	
	public static final String ALI_CHANNEL_CODE = "1001";
	
	public enum CHANNEL_TYPE{
		当面付("100101"),移动支付("100102"),手机网站支付("100103"),即时到账("100104"),批量付款("100105"),扫码付("100106"),条码付("100107"),
		手机网站即时到账("100108");
		
		String type;
		
		private CHANNEL_TYPE(String type){
			this.type=type;
		}
		
		public String getType(){
			return type;
		}
		

		public static CHANNEL_TYPE getAlipayType(String type) {
			if("100101".equals(type)){
				return 当面付;
			}else if("100102".equals(type)){
				return 移动支付;
			}else if("100103".equals(type)){
				return 手机网站支付;
			}else if("100104".equals(type)){
				return 即时到账;
			}else if("100105".equals(type)){
				return 批量付款;
			}else if("100106".equals(type)){
				return 扫码付;
			}else if("100107".equals(type)){
				return 条码付;
			}else{
				return null;
			}
		}
	}

}
