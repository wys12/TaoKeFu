
findEmail();
function findEmail(){	
	$.ajax({
		type:"POST",
		url:"users/logins",
		//async:false, //同步请求
		dataType:"json",//指定返回参数为json格式
		contentType:"application/json;charset=utf-8",  //指定请求数据为json格式
		success:function(data){
			$(".c7").text(data.l_email);
		}
	});	
}

