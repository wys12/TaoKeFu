<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployname}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆</title>
<link type="text/css" rel="stylesheet" href="easyui/1.3.3/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/1.3.3/themes/black/easyui.css">
<link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body>
	<div id="loginDiv">
		<form action="admin/login" id="loginForm"  method="post">
			<p><label>${errorMsg }&nbsp;</label><c:remove var="errorMsg" scope="session"/>
			<p><input name="ad_name" placeholder="请输入用户名" required="required" id="uname" class="easyui-validatebox" data-options="validType:'minLength[5]'"/><p>
			<p><input name="ad_pwd" type="password" placeholder="请输入密码" required="required" id="upwd"/><p>
			<p><input name="vcode" placeholder="请输入验证码" id="vcode"  required="required"/><img src="vcode.jpg" title="看不清，换一张"/></p>
			<p><input type="submit" value="登陆"  id="loginBtn"/><a href="forgetPassword.jsp">忘记密码？</a> </p> 
		</form>
	</div>
	<script type="text/javascript" src="easyui/1.3.3/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/1.3.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/1.3.3/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/adminLogin.js"></script>
</body>
</html>