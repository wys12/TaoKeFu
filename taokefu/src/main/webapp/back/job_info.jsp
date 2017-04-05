<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName}">
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
</head>
<body>
	<table id="jobInfo"></table>
	<div id="jobDetail">
		<form id="jobDetailForm" action="job/list" method="post">
			<p>职位名称:&nbsp;&nbsp;<input id="job_name" name="job_name"/></p>
			<p>职位性质:&nbsp;&nbsp;<input id="job_department" name="job_department"/></p>
			<p>发布时间 :&nbsp;&nbsp;<input id="job_ftime" name="job_ftime"/></p>
			<p>职位要求:&nbsp;&nbsp;<input id="job_request" name="job_request"/></p>
			
			<p><a class="closeBtn" href="javascript:void(0)">关闭</a>&nbsp;&nbsp;
			<a class="updateBtn" href="javascript:void(0)">修改</a></p>
			
		</form>
	</div>
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="back/js/job_info.js"></script>
</body>
</html>