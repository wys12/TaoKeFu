<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/manage.css" rel="stylesheet" type="text/css" />
</head>
<body class="easyui-layout" style="width: 951px; margin: 0px auto;">
	<div data-options="region:'north'" style="height: 136px;">
		<div id="header">
			<div id="top_login">
				<form action="admin/login" method="post" id="myform">
					<label> æ¬¢è¿ã<span>ææ</span>ãä½¿ç¨æ°é»ç®¡çç³»ç»
					</label>
				</form>

			</div>
			<div id="nav">

				<div id="a_b01">
					<img src="#" alt="" />
				</div>
				<!--mainnav end-->
			</div>
		</div>
	</div>
	<div data-options="region:'south'" style="height: 130px;">
		<div id="footer">
			<p class="">
				24å°æ¶å®¢æ·æå¡ç­çº¿ï¼010-68988888 &#160;&#160;&#160;&#160; <a href="#">å¸¸è§é®é¢è§£ç­</a>
				&#160;&#160;&#160;&#160; æ·å®¢æç­çº¿ï¼010-627488888 <br />
				ææåç½ææä¸ç½ä¸¾æ¥çµè¯ï¼010-627488888 &#160;&#160;&#160;&#160; ä¸¾æ¥é®ç®±ï¼ <a
					href="#">jubao@jb-aptech.com.cn</a>
			</p>
			<p class="copyright">
				Copyright &copy; 1999-2009 News China gov, All Right Reserver <br />
				æ·å®¢æ  çæææ
			</p>
		</div>
	</div>
	<div data-options="region:'east',title:'å·¥å·æ '" style="width: 185px;">
		<div id="cc" class="easyui-calendar"
			style="width: 180px; height: 180px; border: 0px; border-bottom: 1px solid #95B8E7;"></div>
	</div>
	<div data-options="region:'west',title:'å¯¼èªæ ',collapsible:false"
		style="width: 160px;">
		<div id="sideNav">
			<div title="ç¨æ·ç®¡ç" data-options="iconCls:'icon-mini-add'">
				<ul class="treeNav">
					<li><span>ç¨æ·ä¿¡æ¯</span></li>
				</ul>
			</div>
			<div title="èä½ç®¡ç" data-options="iconCls:'icon-mini-add'">
				<ul class="treeNav">
					<li><span>èä½ä¿¡æ¯</span></li>
					<li><span>èä½ç¼è¾</span></li>
					<li><span>èä½æ·»å </span></li>
				</ul>
			</div>
			<div title="ç®åç®¡ç" data-options="iconCls:'icon-mini-add'">
				<ul class="treeNav">
					<li><span>ç®åä¿¡æ¯</span></li>
					<li><span>ç®åç¼è¾</span></li>
					<li><span>ç®åæ·»å </span></li>
				</ul>
			</div>
		</div>

	</div>
	<div
		data-options="region:'center', title:'ä¸»çé¢', tools: [{    
	    iconCls:'icon-full',    
	    handler:function(){full();}    
	  },{    
	    iconCls:'icon-unfull',    
	    handler:function(){unfull();}    
	  }]">
		<div id="main" style="width: 500px; height: 250px;">
			<div title="æ¬¢è¿">
				<h1
					style="width: 400px; text-align: center; height: 100%; margin: 0px auto;">
					<label> æ¬¢è¿ã<span>ææ</span>ãä½¿ç¨æ·å®¢æç®¡çç³»ç»
					</label>
				</h1>
			</div>
		</div>
	</div>


	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="back/js/manage.js"></script>
</body>
</html>