$("#main").tabs({
	fit:true,
	border:false
});

$("#sideNav").accordion({
	fit:true,
	border:false,	
});

$(".treeNav").tree({
	onClick: function(node){  // node是指树节点， node.text是节点文本内容
		var nodeContent = node.text;
		if($("#main").tabs('exists',nodeContent)){
			$("#main").tabs('close',nodeContent)
		}
		if($("#main").tabs('exists',"欢迎")){
			$("#main").tabs('close',"欢迎")
		}

		info(nodeContent, "职位信息", "back/job_info.jsp");
		info(nodeContent, "用户信息", "back/user_info.jsp");
		info(nodeContent, "主题信息", "back/topic_info.jsp");
	}
});
function info(nodeContent,ContentStr,url){
	if(nodeContent==ContentStr){
		$("#main").tabs('add',{
			title:nodeContent,
			href:url,
			iconCls:"icon-mini-add",
			closable:true
		});
	}
}
