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
		<form action="admin/forget" id="forgetForm" method="post">
			<p>
				<input name="ad_namae" required="required" placeholder="请求输入用户名" />
			</p>
			<p>
				<input type="email" name="ad_email" required="required"
					placeholder="请求输入找出密码邮箱" />
			</p>
			<p>
				<input type="email" name="yzm" required="required"
					placeholder="请求输入找出密码邮箱" style="width: 150px;"/>
					<button>发送邮箱</button>
					
			</p>
			<p>
				<button type="submit" id="but">找回密码</button>
			</p>
		</form>
	</div>
	<script type="text/javascript" src="easyui/1.3.3/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/1.3.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/1.3.3/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/forgetPassword.js"></script>
</body>
</html>