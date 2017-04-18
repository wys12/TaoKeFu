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
	showBox_Job();
	//alert("查看和编辑职位");
	/*$.post("",function(data){
		
	},"json");*/
}
//进入发布职位信息
function showCreate(){
	showBox_Job();
	//alert("发布职位");
	/*$.post("",function(data){
		
	},"json");*/
}
function showBox_Job(){
	var str="";
	str='<dl><dt>产品</dt><dd><ul class="reset job_main"><li><span>产品经理</span><ul class="reset job_sub dn"><li>产品经理</li></ul></li>'
		+'<li><span>产品设计师</span><ul class="reset job_sub dn" style="margin-left: -160px;"><li>网页产品设计师</li><li>无线产品设计师</li>'
		+'</ul></li><li><span>高端产品职位</span><ul class="reset job_sub dn" style="margin-left: -310px;"><li>产品部经理</li><li>产品总监</li></ul></li></ul></dd></dl>';
	$("#box_job").html(str);
}
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	if (r != null) return unescape(r[2]); return null; //返回参数值
}
$("#formSubmit").click(function(){
	$.ajax({
		cache:true,
		type:"POST",
		url:'job/insertCompanyJob',
		data:$('#jobForm').serialize(),
		async:false,
		success:function(data){
			alert(data);
		}
	})
});
