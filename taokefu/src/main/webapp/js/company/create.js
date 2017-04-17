loadInfo();
function loadInfo(){
	var URLParams = getUrlParam('positionId');
	//alert('|'+URLParams+'|');
	if(URLParams!=null && URLParams!=""){
		showEidt();
	}else if(URLParams==null){
		showCreate();
	}else if(URLParams==""){
		alert("错误的请求参数！！！");
		location.href='index.html';
	}
}
//进入查看的职位信息
function showEidt(){
	alert("查看和编辑职位");
	/*$.post("",function(data){
		
	},"json");*/
}
//进入发布职位信息
function showCreate(){
	alert("发布职位");
	/*$.post("",function(data){
		
	},"json");*/
}
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	if (r != null) return unescape(r[2]); return null; //返回参数值
}
