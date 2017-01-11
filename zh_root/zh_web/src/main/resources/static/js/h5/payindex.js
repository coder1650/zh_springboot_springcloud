$(function () {
	//open personal center
	$('#center').click(function(){
		var $mask=$('.mask');
		var $login=$('#login');
		var $close=$('.close');
		$mask.removeClass('hide');
		$login.children().removeClass('hide');
		$close.click(function(){
			$mask.addClass('hide');
			$login.children().addClass('hide');
		})
	});
	//telephone verify
	var $telVer=$('#getVerification');
	var $errTel=$('.errTel');
	var $telVal=null;
	$('#tel').on('keyup blur', function(e){
		$telVal=$('#tel').val();
		if($telVal.length>=11){
			if(telVerify($telVal)){
				$telVer.attr('class','verTrue');
				//验证码获取
				
			}else{
				$errTel.removeClass('hide');
			}	
		}else{
			$telVer.attr('class','verFalse');
			$errTel.addClass('hide');
		}
	})
	//移动号码段验证
	function telVerify(value){
		var reg=/^1(3[4-9]|47|5[012789]|78|8[23478])\d{8}$/;
		return reg.test(value);
	}
})