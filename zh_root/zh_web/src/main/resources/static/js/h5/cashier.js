$(function() {
	getOrderInfoBytransId();
	// 获得支付方式列表
	getPaytype();
	//确认付款
	$('.btnPay').click(
		function() {
			var repayResult=checkPayState();
			var target = $(".list li").find(".active").parent();
			var payMappingId = target.attr('payMappingId');
			if(!repayResult){
				if(payMappingId!=null && payMappingId!=''){
					window.location.href = "../../h5PayApi/getForwardPayUrl?typeId="+payMappingId+"&transId="+transId;
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
var transId = getQueryString("transId");
var appId = getQueryString("appId");
var platType = getQueryString("platType");
var res=null;
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

//查询支付方式
if(appId != null && platType != null){
	function getPaytype(){
		$.ajax({
			url : "../../orderOpenApi/findPayTypeInfoOfAppId",
			data : {
				"appId" : appId,
				"platType" : platType
			},
			type : 'get',
			async : false,
			dataType : "json",
			success : function(result) {
				if (result.returnCode == '100') {
					var str='';
					$(result.data).each(function(index){
						str+='<li payMappingId="'+this.id+'"><img src="'+this.imageLogoUrl+'"/><a>'+this.payChannelName+'</a><em></em><span></span></li>';
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
				}
			}
		});
	}
}

// 根据交易流水号获得订单详情信息
function getOrderInfoBytransId() {
	var cporderInfo = '';
	// 向后台发送处理数据
	$.ajax({
		url : "../../orderOpenApi/findOrderInfoByTransId",
		data : {
			"transId" : transId
		},
		type : 'get',
		async : false,
		dataType : "json",
		success : function(result) {
			$('#product').find('span').html(result.data.wareName);
			$('#money').find('span').html(result.data.payMoney/100+'元');
			$('.btnPay').find('span').html(result.data.payMoney/100+'元');
			cporderInfo = result;
		}
	});
	return cporderInfo;
}
//支付时，查询是否重复支付。
function checkPayState () {
	var payState='';
	$.ajax({
		url : "../../orderOpenApi/isPayOfTransId",
		data : {
			"transId" : transId
		},
		type : 'get',
		async : false,
		dataType : "json",
		success : function(result) {	
			payState = result.data;
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
