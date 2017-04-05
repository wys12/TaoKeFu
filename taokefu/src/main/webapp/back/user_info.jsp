<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet"
	href="easyui/themes/default/easyui.css">
</head>
<body>
	<table id="userInfo"></table>
	<div id="modifyDiv">
		<form id="modifyForm" method="post" enctype="multipart/form-data">
			<p>
				用户编号:&nbsp;&nbsp;<input id="us_id" name="us_id" readonly="readonly" />
			</p>
			<p>
				用户姓名:&nbsp;&nbsp;<input id="us_name" name="us_name" />
			</p>
			<p>
				用户性别:&nbsp;&nbsp;<input id="us_sex" name="us_sex" />
			</p>
			<p>
				用户电话:&nbsp;&nbsp;<input id="us_phone" name="us_phone" />
			</p>
			<p>
				用户邮箱:&nbsp;&nbsp;<input id="us_email" name="us_email" />
			</p>
			<p>
				工作年限:&nbsp;&nbsp;<input id="us_work_year" name="us_work_year" />
			</p>
			<p>
				个人简介:&nbsp;&nbsp;<input id="us_intro" name="us_intro" />
			</p>
			<p>
				<img src="" id="pic" width="100" height="100">
			</p>
			<p>
				<a class="closeBtn" href="javascript:void(0)">关闭</a>&nbsp;&nbsp; <a
					class="updateBtn" href="javascript:void(0)">修改</a>
			</p>
		</form>
	</div>
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="back/js/user_info.js"></script>
</body>
</html>