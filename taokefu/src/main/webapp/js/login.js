var boole="0";
function login(){
	boole="0";
	//$("#loginForm").submit();//表单提交	
	var email = $('#email').val();
	var password = $('#password').val();
	var param={l_email:email,l_pwd:password};
	//alert(JSON.stringify(param));
	$.ajax({
		type:"POST",
		url:"users/login",
		//async:false, //同步请求
		data:JSON.stringify(param),
		dataType:"json",//指定返回参数为json格式
		contentType:"application/json;charset=utf-8",  //指定请求数据为json格式
		success:function(data){
			//直接跳转到upload.jsp
			//alert(data.page);
			location.href=data.page; //在当前页面跳转
			//open(data.page);  //打开新的页面
		}
	});
}
$("#ssss").click(function(){
	if(boole=="0"){
		boole="1";
		$(".pwds").attr("type","text");
	}else if(boole=="1"){
		boole="0";
		$(".pwds").attr("type","password");
	}
});

	
