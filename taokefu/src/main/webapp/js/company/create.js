loadInfo();
function loadInfo(){
	var URLParams = getUrlParam('positionId');
	//alert('|'+URLParams+'|');
	if(URLParams!=null && URLParams!=""){
		showEidt(URLParams);
	}else if(URLParams==null){
		showCreate();
	}else if(URLParams==""){
		alert("错误的请求参数！！！");
		location.href='index.html';
	}
}
//进入查看的职位信息
function showEidt(URLParams){
	//alert("查看和编辑职位");
	$.post("job/findJobEidt",{job_id:URLParams},function(data){
		console.info(JSON.stringify(data));
		$("#positionType").val(data[0].job_department);
		$("#select_category").val(data[0].job_department);
		$("#positionName").val(data[0].job_name);
		$("#department").val(data[0].job_department);
		data[0].job_nature=="全职"?$("#ulNature li:eq(0)").attr("class","current"):(data[0].job_nature=="兼职"?$("#ulNature li:eq(1)").attr("class","current"):$("#ulNature li:eq(2)").attr("class","current"));
		$("#salaryMin").val(data[0].job_min_salary);
		$("#salaryMax").val(data[0].job_max_salary);
		$("#workAddress").val(data[0].job_city);
		$("#experience").val(data[0].job_experience);
		$("#select_experience").val(data[0].job_experience);
		$("#education").val(data[0].job_education);
		$("#select_education").val(data[0].job_education);
		$("#positionAdvantage").val(data[0].job_tempt);
		$("#job_responsibility").val(data[0].job_responsibility);
		$("#job_need").val(data[0].job_need);
		$("#positionAddress").val(data[0].job_address);
	},"json");
	$("#trButton").html('<input type="button" value="保存" id="formSubmits" class="btn_32">');
	showBox_Job();
}
$("#formSubmits").click(function(){
	$.ajax({
		cashe:true,
		type:'POST',
		url:'job/modifiJobEidt',
		async:false,
		data:$('#jobForm').serialize(),
		error:function(){
			window.location.reload();
		},
		success:function(data){
			//alert(JSON.stringify(data));
			location.href='positions.html';
		}
	});
});
//进入发布职位信息
function showCreate(){
	showBox_Job();
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
