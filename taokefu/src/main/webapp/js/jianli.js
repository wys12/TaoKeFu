var s="";
function loadInfo(number){
	if(number!=null && number!=""){
		$("#expectEditId").attr("class","expectEdit");
		s=number;
		shouInfo(s);
	}else{
		location.href = "login.html";
	}
}	
var listTkfUser =[];var listUsResume =[];var listExperience =[];var listSucceed =[];
var listEducationa =[];var listCollect =[];var listTake =[];
function shouInfo(number){
	var params={tkf_id:number.l_id};
	$.post("tkfuser/findTkfUser",{us_id:number.l_id},function(data){
		listTkfUser=data;
	}
	,"json");
	$.post("tkfuser/findUsResume",params,function(data){
		listUsResume=data;
		$(".descriptionShow").html(data[0].des_content);
		$(".expectShow").html(data[0].hj_city+','+data[0].hj_name+',月薪'+data[0].hj_min_salary+'-'+data[0].hj_max_salary+','+(data[0].hj_nature=='-0'?'全职':(data[0].hj_nature=='-1'?'兼职':'实习')));
	},"json");
	$.post("tkfuser/findExperience",params,function(data){
		listExperience=data;
		$(".experienceShow").html('<ul class="wlist clearfix"><li class="clear"><span class="c9">'+data[0].exp_start_year+'-'+data[0].exp_end_year+'</span><div><img width="56" height="56" alt="'+data[0].exp_company_name+'" src="style/images/logo_default.png"><h3>'+data[0].exp_job_name+'</h3><h4>'+data[0].exp_company_name+'</h4></div></li></ul>');
	},"json");
	$.post("tkfuser/findSucceed",params,function(data){
		listSucceed=data;
		$(".workShow").html('<ul class="slist clearfix"><li class="noborder"><div class="workList c7"><div class="f16">'+data[0].suc_name+'：<a target="_blank" href="'+data[0].suc_link+'">'+data[0].suc_link+'</a></div><p>产品</p></div></li></ul>');
	},"json");
	$.post("tkfuser/findEducationa",params,function(data){
		setTimeout(function showInfos(){
			//学历信息
			$(".educationalShow").html('<ul class="elist clearfix"><li class="clear"><span class="c9">'+data[0].edu_start_year+'-'+data[0].edu_end_year+'</span><div><h3>'+data[0].edu_shool_name+'</h3><h4>'+data[0].edu_major+'，'+data[0].edu_educationa+'</h4></div></li></ul>');
			//基本信息
			$(".basicShow").html('<span>'+listTkfUser[0].us_name+' | '+listTkfUser[0].us_sex+' | 经验: '+listTkfUser[0].us_work_year+' | '+listExperience[0].exp_city+'<br> '+listExperience[0].exp_job_name+'·'+listExperience[0].exp_company_name+' | '+listTkfUser[0].us_educationa+' · '+data[0].edu_shool_name+'<br> '+listTkfUser[0].us_phone+' | '+listTkfUser[0].us_email+'<br></span>'
					+'<div class="m_portrait"><div></div><img width="120" height="120" alt="'+listUsResume[0].usr_name+'" src="'+(listTkfUser[0].us_picpath==null?'style/images/default_headpic.png':listTkfUser[0].us_picpath)+'">');
			showHopeJob();
			showExperience();
		}, 80);

	},"json");
}
//期望工作
function showHopeJob(){
	$("#select_hjCity").val(listUsResume[0].hj_city);
	$("#hjCity").val(listUsResume[0].hj_city);
	$("#hjPosition").val(listUsResume[0].hj_name);
	$("#hjSalary").val(listUsResume[0].hj_min_salary+'-'+listUsResume[0].hj_max_salary);
	$("#select_hjSalary").val(listUsResume[0].hj_min_salary+'-'+listUsResume[0].hj_max_salary);
}
//工作经历 
function showExperience(){
	$("#exp_company_nameId").val(listUsResume[0].hj_city);
	$("#exp_job_nameId").val(listUsResume[0].hj_city);
	$("#expectPosition").val(listUsResume[0].hj_name);
	$("#expectSalary").val(listUsResume[0].hj_min_salary+'-'+listUsResume[0].hj_max_salary);
	$("#select_expectSalary").val(listUsResume[0].hj_min_salary+'-'+listUsResume[0].hj_max_salary);
}
//教育背景
function showEducationa(){
	$("#select_expectCity").val(listUsResume[0].hj_city);
	$("#expectCity").val(listUsResume[0].hj_city);
	$("#expectPosition").val(listUsResume[0].hj_name);
	$("#expectSalary").val(listUsResume[0].hj_min_salary+'-'+listUsResume[0].hj_max_salary);
	$("#select_expectSalary").val(listUsResume[0].hj_min_salary+'-'+listUsResume[0].hj_max_salary);
}
//自我描述
function showDescription(){
	$("#select_expectCity").val(listUsResume[0].hj_city);
	$("#expectCity").val(listUsResume[0].hj_city);
	$("#expectPosition").val(listUsResume[0].hj_name);
	$("#expectSalary").val(listUsResume[0].hj_min_salary+'-'+listUsResume[0].hj_max_salary);
	$("#select_expectSalary").val(listUsResume[0].hj_min_salary+'-'+listUsResume[0].hj_max_salary);
}
$("#education").click(function(){
	var schoolName=$('.schoolName').val();
	//alert("schoolName "+schoolName);
});
$("#expId").click(function(){

});

$(".c_edit").click(function(){
	//alert(JSON.stringify(listTkfUser));
	$("#names").html('<input type="text" placeholder="姓名" value="'+listUsResume[0].usr_name+'" name="us_name"/>');
	if(listTkfUser[0].us_sex=="男"){ 
		$("#us_sexId li").removeClass("current");
		$("#us_sexId li:eq(1)").attr("class","current");
	}else if(listTkfUser[0].us_sex=="女"){
		$("#us_sexId li").removeClass("current");
		$("#us_sexId li:eq(1)").css("class","current");
	}
	$("#us_phone").val(listTkfUser[0].us_phone);
	$("#us_email").val(listTkfUser[0].us_email);
	$("#topDegrees").val(listTkfUser[0].us_educationa);
	$("#select_topDegrees").val(listTkfUser[0].us_educationa);
	//alert($("#select_workyear").val()+"=="+listTkfUser[0].us_work_year);
	$("#workyears").val(listTkfUser[0].us_work_year);
	$("#select_workyears").val(listTkfUser[0].us_work_year);
	$("#currentState").val(listTkfUser[0].us_intro);
	$("#select_currentState").val(listTkfUser[0].us_intro);
});

$("#userInfo").click(function(){
	formURL('tkfuser/insertTkfUser',"#profileForm",userInfo);
});
function hbId(){
	formURL('tkfuser/insertUsResume',"#expectForm",hbInfo);
};
function hbInfo(){
	shouInfo(s);
}
function userInfo(){
	$("#basicShow").attr("class","basicShow");
	$("#basicEdit").attr("class","basicEdit dn");
	$("#user_c_edit").attr("class","c_edit");
	shouInfo(s);
}
function formURL(urlParams,dataParams,successFunction){
	$.ajax({
		cache:true,
		type:'POST',
		url:urlParams,
		data:$(dataParams).serialize(),
		async:false,
		error: function(request) {
			alert("修改失败！！！");
		},
		success:function(data){
			successFunction();
		}
	})
}