<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="jobInfo"></table>
	<div id="jobDetail">
		<form action="job/list" method="post">
			<p>
				<label> 职位 </label> <input id="intname" />
			</p>
			<p>
				<label>部门 </label> <input id="intitle" />
			</p>
			<p>
				<label> 发布时间 </label> <input id="inauthor" />
			</p>
		<!-- 	<p>
				<label> 摘要 </label>
				<textarea id="insummary" cols="40" rows="3"></textarea>
			</p> -->
			<p>
				<label> 职位要求 </label>
			<div id="incontent"
				style="width: 700px; height: 200px; border: 1px solid gray"></div>
			</p>
			<!-- <p>
				<label> 上传图片 </label> <input name="file" type="file" /><br> <img
					src="" style="width: 100px; height: 100px" id="ipic">
			</p> -->
		</form>
	</div>
	<script type="text/javascript" src="back/js/job_info.js"></script>
</body>
</html>