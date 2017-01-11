$(function() {
	// 获得支付方式列表
	getPaytype();
	//确认付款
	$('.btnPay').click(
		function() {
			var repayResult=checkPayState();
			var target = $(".list li").find(".active").parent();
			var channelcode = target.attr('typeId');
			if(repayResult.bean.payState==='0'){
				if(channelcode!=null && channelcode!=''){
					window.location.href = "../beg?payChannelCode="+channelcode+"&transId="+transid;
				}else{
					return false;
				}
			}else{
				$('.repay').removeClass('hide');
				$('.mask').removeClass('hide');
				if (repayResult.bean.payState==='2') {
					$('.repay').find('a').eq(0).css('color','#cdcdcd');
					$('.repay').find('a').eq(1).click(function(){
						window.location.href = "result.jsp"+"?transId="+transid;
					});
				}else{
					$('.repay').find('a').eq(0).click(function(){
						window.location.href = "../beg?payChannelCode="+channelcode+"&transId="+transid;
					});
					$('.repay').find('a').eq(1).click(function(){
						window.location.href = "result.jsp"+"?transId="+transid;
					});
				}
			}
	});
});
//获取html后请求的参数
var transid = getQueryString("transid");
var res=null;
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}
if (transid != null) {
	function getPaytype() {
		res= getOrderInfoBytransId();
		var cporderInfo = '';
		if(res.returnCode ==='1000'){
			cporderInfo = res.bean;
		}		
		if(cporderInfo != ''){
			$.ajax({
				url : "/zypayh5/front/sh/opencashier!getPaytypeInfo",
				data : {
					"uid" : "u0001",
					"appid" : cporderInfo.appId,
					"applymoney" : cporderInfo.payMoney
				},
				type : 'post',
				async : false,
				dataType : "json",
				success : function(result) {
					if (result.returnCode == '1000') {
						var str='';
						$(result.beans).each(function(index){
							str+='<li typeId="'+this.pay_channel_code+'"><img src="'+this.image_logo_url+'"/><a>'+this.channel_name+'</a><em></em><span></span></li>';
							if(index>1){
								$('.main').find('h3').removeClass();
							};
						});
						$('.list').html(str);
						$('.list li').each(function(index){
							$('.list li').eq(0).find('span').addClass('active');
							if(index>1){
								$(this).addClass('hide');
							}
						});
						$('.list em').eq(0).html('官方推荐');
						$('.list li[typeId="100303"]').find('em').html('支持信用卡分期付款');
						choosePayment();
					} else {
						window.location.href = "error.jsp?errMsg="+result.returnMessage;
					}
				}
			});
		}else {
			window.location.href = "error.jsp?errMsg="+res.returnMessage;
		}
	}
} else {
	window.location.href = "error.html";
}
// 根据交易流水号获得订单详情信息
function getOrderInfoBytransId() {
	var cporderInfo = '';
	// 向后台发送处理数据
	$.ajax({
		url : "/zypayh5/front/sh/opencashier!getCommonDetail",
		data : {
			"uid" : "u0001",
			"transid" : transid
		},
		type : 'post',
		async : false,
		dataType : "json",
		success : function(result) {
			$('#product').find('span').html(result.bean.wareName);
			$('#money').find('span').html(result.bean.payMoney+'元');
			$('.btnPay').find('span').html(result.bean.payMoney+'元');
			cporderInfo = result;
		}
	});
	return cporderInfo;
}
//支付时，查询是否重复支付。
function checkPayState () {
	var payState='';
	$.ajax({
		url : "/zypayh5/front/sh/opencashier!getOrderInfoByAcid",
		data : {
			"uid":"u0001",
			"appid" : res.bean.appId,
			"cporderid" : res.bean.cpOrderNo,
			"transid" : transid
		},
		type : 'post',
		async : false,
		dataType : "json",
		success : function(result) {	
			payState = result;
		}
	});
	return payState;
}
function choosePayment(){
	var $moPayment=$('.main h3');
	var $payList=$('.list li');
	console.log($payList)
	var $payMethod=$payList.find('span');
	//show more payment methods
	$moPayment.click(function () {
		$payList.removeClass('hide');
		$moPayment.hide();
	});
	//change payment type
	$payList.click(function(){
		$payMethod.removeClass('active');
		$(this).find('span').addClass('active');
	});
}
