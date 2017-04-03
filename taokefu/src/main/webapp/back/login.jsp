<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="/taokefu/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet"
	href="easyui/themes/default/easyui.css">
<link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body>

	<div id="loginDiv">
		<form action="admin/login" id="loginForm">
			<p><label>${errorMsg }</label></p><c:remove var="errorMsg" scope="session"/>
			<p><input name="ad_name" placeholder="请输入用户名" required="required" id="uname"></p>
			<p><input type="password" name="ad_pwd" placeholder="请输入密码" required="required" id="upwd"></p>
			<p><img src="vcode.jpg" title="看不清,换一张"/>&nbsp;<input name="vcode" placeholder="请输入验证码"  id="vcode" required="required"></p>
			<p><input type="submit" value="登陆" id="loginBtn"></p>
		</form>
	</div>

	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="back/js/login.js"></script>
</body>
</html>