function beginToPay() {
	debugger
	var appUserId = $("#userId").val();
	var date = new Date();
	var cporderid = "2017"+date.getDay()+date.getMilliseconds();
	var price = $("#price").val();
	if (appUserId === ''||price === '') {
		$("#code_msg").text("userId或price不能为空！").addClass("error_msg");
		return;
	}else {
		$("#code_msg").text("");
	}
	var res = serverOrder(appUserId, cporderid,price);
	if(res !== null && res !== ""){
		var redirecturl = "zypayh5/front/sh/calbakpay!transPaystate?uid=u0001";
		var cpurl = "zypayh5/index.html";
//		var reqStr = getEctryData(transid,redirecturl,cpurl);
		window.location.href =  "cashier_h5.html?appId=5000001436&platType=1&transId="+res;
		//"http://localhost:8090/zypaypc/pc/exbegpay?"+reqStr
	}
}
	//下单接口,得到平台生成的交易流水号
	function serverOrder(appUserId,cpOrderNo,price) {
		var res = '';
		 $.ajax({
			async:false,
			url : "../../orderOpenApi/getTransId",
			data :{
	            "appId": "5000001436",
	            "wareId":2,
	            "wareName":"线下支付一分钱测试",
	            "cpOrderNo":cpOrderNo,
	            "applyMoney":price,
	            "currency":"RMB",
	            "userId":appUserId,
	            "cpReInfo":"h5123test",
	            "notifyUrl": "zypayh5/front/sh/notify!transPaystate?uid=u0001&"
	        },
			type : 'POST',
			async : false,
			dataType : "json",
			success : function(result) {
				res = result.data;
			}	        
		});
		 return res;
	}
	//加密商户打开收银台数据
	function getEctryData(transid,redirecturl,cpurl) {
		var encStr ;
		$.ajax({
			async:false,
			url : "/zypayh5/front/sh/order!enctryOPenCashierReq",
			data: {
		            "uid": "u0001",
		            "transid": transid,
		            "redirecturl":redirecturl,
		            "cpurl":cpurl
		        },
			type : 'post',
			dataType : "json",
			success : function(result) {
				encStr = result.data;
			}
		});
		 return encStr;
	}
//查询支付状态
function checkPayState () {
    $.ajax({
        url : "/zypayh5/front/sh/query!queryPayResult",
        data : {
            "uid":"u0001",
            "appid" : "5000001436",
            "cporderid" : "20164871"
        },
        type : 'post',
        async : false,
        dataType : "json",
        success : function(result) { 
        	$('#showResult').show();
            if(result.result=='0'){
            	$('#showResult').html('该订单支付成功！')
            }else{
            	$('#showResult').html('该订单支付失败！')
            }
        }
    });
}
//查询支付状态
function checkOfflinePayState() {
    $.ajax({
        url : "/zypayh5/front/sh/query!queryOfflinePayResult",
        data : {
            "uid":"u0001",
            "appId" : "5000001436",
            "transactionId" : '2016275'
        },
        type : 'post',
        async : false,
        dataType : "json",
        success : function(result) { 
        	$('#showResult').show();
            if(result.result=='0'){
            	$('#showResult').html('该订单支付成功！')
            }else{
            	$('#showResult').html('该订单支付失败！')
            }
        }
    });
 }
