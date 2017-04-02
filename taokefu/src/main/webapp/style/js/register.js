function register(){
	var email = $('#email').val();
	var password = $('#password').val();
	//var value=$('.type').val();
	var param={us_email:email,us_pwd:password};
	alert(JSON.stringify(param));
	$.ajax({
		type:"POST",
		url:"user/register",
		//async:false, //同步请求
		data:JSON.stringify(param),
		dataType:"json",//指定返回参数为json格式
		contentType:"application/json;charset=utf-8",  //指定请求数据为json格式
		success:function(data){
			alert(data.msg);
			if(data.msg == null){
				location.href=data.page; //在当前页面跳转		            		
        	}else{
				$('#beError').text(data.msg).show();
        	}
        	$(form).find(":submit").attr("disabled", false);
		}
	});
}