$("#main").tabs({
	fit:true,
	border:false
});
$("#sideNav").accordion({
	fit:true,
	border:false,
});
$(".treeNav").tree({
	onClick: function(node){//node是指树节点，  node.text是节点文本内容
		var nodeContent = node.text;
		if($("#main").tabs('exists',nodeContent)){
			$("#main").tabs('close',nodeContent)
		}
		if($("#main").tabs('exists',"欢迎")){
			$("#main").tabs('close',"欢迎")
		}
		
		info(nodeContent, "职位信息", "back/job_info.jsp");
		info(nodeContent, "职位编辑", "back/job_edit.jsp");
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

$.extend($.fn.layout.methods,{
	full:function(jq){
		return jq.each(function(){
			var layout=$(this);
			var center=layout.layout("panel","center");
			center.panel("maximize");
			center.parent().css("z-index",10);
			
			$(window).on("resize.full",function(){
				layout.layout("unFull").layout("resize");
			})
		});
	},
	unfull:function(jq){
		return jq.each(function(){
			var layout=$(this);
			var center=layout.layout("panel","center");
			center.parent().css("z-index","inherit");
			center.panel("restore");
			$(window).off("resize.full");
		});
	}
});

function full(){
	$("body").layout("full");
	$("#center_content").addClass("panel-fit");
}

function unfull(){
	$("body").layout("unfull");
}

