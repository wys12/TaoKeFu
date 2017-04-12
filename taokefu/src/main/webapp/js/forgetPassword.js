$("#forgetDiv").dialog({
	title:"",
	top:80,
	width:400,
	height:400,
	border:false,
	modal:true
});
/*$.post("admin/sendEmail");
$.post("点击找回,照这个请求中判断验证码是否一致");*/
var new_pwd1=$("#new_pwd1");
var new_pwd2=$("#new_pwd2");

function forget(){
	var email=$("#ad_email").val();
	var name=$("#ad_name").val();
	if(email=="" || email==null){
		$("#msg1").html("用户名不能为空!!!");
	}
	if(name=="" || name==null){
		$("#msg2").html("邮箱不能为空!!!")
	}
	if(email!=null && email!="" && name!=null && name!=""){
		$.post("admin/forget",{ad_email:email,ad_name:name},function(data){
			if(data=="false"){
				$("#msg2").html("用户名和邮箱不匹配！！！");
			}
		},"json");
	}
}
$(function(){  
	$('#new_pwd2').bind('input propertychange', function() { 
		if(new_pwd1!=new_pwd2){
			$("#msg").html('两次密码不一致！！！');
		}else if(new_pwd1==new_pwd2){
			$("#msg").html('');
		}else{
			$("#msg").html('');
		}
	});  
})  

function new_pwd(){
	var new_pwd1=document.getElementById("new_pwd1").value;
	var new_pwd2=document.getElementById("new_pwd2").value;
	if(new_pwd1!=new_pwd2){
		$("#msg3").html('两次密码不一致！！！');
	}else{
		$("#msg3").html('');
	}
}

function msg(){
	if(new_pwd1!=new_pwd2  ){
		$("#msg").val("两次密码不一致！！！");
	}else if(new_pwd1!=null){
		$("#msg").val("密码不能为空！！！");
	}else if($("#ad_email").val() !=null){
		alert("请输入邮箱");
	}else if($("#name").val() !=null){
		alert("请输入用户名");
	}else{
		$("#forgetForm").submit();
	}
}
$('#sbm').click(function (){
	var email=$("#ad_email").val();
	var new_pwd2=document.getElementById("new_pwd2").value;
	var code=document.getElementById("code").value;
	alert(email);
	$.post("admin/forgets",{ad_pwd:new_pwd2,code:code,ad_email:email},function(data){
		if(data=="0"){
			location.href="adminLogin.jsp";
		}else if(data=="1"){
			location.href="forgetPassword.jsp";
		}
	},'json');
});
