<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<meta charset="UTF-8">
<title>忘记密码</title>
<link type="text/css" rel="stylesheet" href="css/forgetPassword.css">
<link type="text/css" rel="stylesheet" href="easyui/1.3.3/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/1.3.3/themes/black/easyui.css">
</head>
<body>
	<div id="forgetDiv">
		<form id="forgetForm" action="admin/forgets" method="post">
				<label id="msg1" style="color:red;  font-size: 16px;"></label>
				<input id="ad_name"  placeholder="请求输入用户名" required="required" />
				<label id="msg2" style="color:red;  font-size: 16px;"></label>
				<input type="text" id="ad_email" placeholder="请求输入找出密码邮箱" required="required" style="width: 160px;"/>
				<a href="javascript:void(0)" onclick="forget()">忘记密码</a>	
				<input type="password" id="new_pwd1" name="ad_pwd" required="required" placeholder="请输入新密码" />		
				<label id="msg3" style="color:red;  font-size: 16px;"></label>
				<input type="password" id="new_pwd2" onkeyup="new_pwd()" name="ad_pwd" required="required" placeholder="确认新密码" />
				<label id="msg4" style="color:red;  font-size: 16px;">${errorMsg}</label>
				<input type="text" name="code" id="code" required="required" placeholder="请输入验证码" style="width: 100px;"/>
				<button type="button" id="sbm" >提交</button>		
		</form>
	</div>
	<script type="text/javascript" src="easyui/1.3.3/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/1.3.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/1.3.3/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/forgetPassword.js"></script>
</body>
</html>