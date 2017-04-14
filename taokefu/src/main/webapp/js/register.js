 $(document).ready(function(e) {
	 	$('submitLogin').attr({"disabled":"disabled"});
    	$('.register_radio li input').click(function(e){
    		$(this).parent('li').addClass('current').append('<em></em>').siblings().removeClass('current').find('em').remove();
    	});
    	$('#email').focus(function(){
    		$('#beError').hide();
    	});
    	//验证表单
	    	 $("#loginForm").validate({
	    	        rules: {
	    	        	type:{
	    	        		required: true
	    	        	},
			    	   	email: {
			    	    	required: true,
			    	    	email: true
			    	   	},
			    	   	password: {
			    	    	required: true,
			    	    	rangelength: [3,16]
			    	   	},
			    	   	checkbox:{required:true}
			    	},
			    	messages: {
			    		type:{
	    	        		required:"请选择使用拉勾的目的"
	    	        	},
			    	 	email: {
			    	    	required: "请输入常用邮箱地址",
			    	    	email: "请输入有效的邮箱地址，如：vivi@lagou.com"
			    	   	},
			    	   	password: {
			    	    	required: "请输入密码",
			    	    	rangelength: "请输入3-16位密码，字母区分大小写"
			    	   	},
			    	   	checkbox: {
			    	    	required: "请接受拉勾用户协议"
			    	   	}
			    	},
			    	errorPlacement:function(label, element){			    		
			    		/*modify nancy*/
			    		if(element.attr("type") == "radio"){
			    			label.insertAfter($(element).parents('ul')).css('marginTop','-20px');
			    		}else if(element.attr("type") == "checkbox"){
			    			label.insertAfter($(element).parent()).css('clear','left');
			    		}else{
			    			label.insertAfter(element);
			    		};	
			    	},
	    	});
    });
 
 $(".typeinfo").onclick(function(){
	 alert("注册可用");
	 $("#btnzhuce").removeAttr("disabled");
 });
function register(){
	var email = $('#email').val();
	var password = $('#password').val();
	var type = $('#loginForm ul li input[name="type"]:checked ').val();
	var param={l_email:email,l_pwd:password,l_type:type};
	//alert(JSON.stringify(param));
	$.ajax({
		type:"POST",
		url:"users/register",
		//async:false, //同步请求
		data:JSON.stringify(param),
		dataType:"json",//指定返回参数为json格式
		contentType:"application/json;charset=utf-8",  //指定请求数据为json格式
		success:function(data){
			if(data.msg == "0"){alert(data.msg);
				location.href="index.html"; //在当前页面跳转		            		
        	}else if(data.msg == "1"){alert(data.msg);
				location.href="companyInfo01.html"; //在当前页面跳转		            		
        	}else if(data.msg=="该邮箱已被注册"){
				$('#beError').text(data.msg).show();
        	}else if(data.msg=="该邮箱已被注册"){
				$('#beError').text(data.msg).show();
        	}
        	$(form).find(":submit").attr("disabled", false);
		}
	});
}