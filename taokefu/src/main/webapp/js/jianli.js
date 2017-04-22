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
	
	tkfUser(number);
	UsResume(params);
	experience(params);
	educationa(params);
}
function cssId(){
	$("#select_hjCity").css("color", "#333"),
	$("#select_hjSalary").css("color", "#333"),
	$("#companyYearStartIds").css("color", "#333"),
	$("#companyMonthStartIds").css("color", "#333"),
	$("#companyYearEndIds").css("color", "#333"),
	$("#companyMonthEndIds").css("color", "#333"),
	$("#edu_educationaIds").css("color", "#333"),
	$("#edu_start_yearIds").css("color", "#333"),
	$("#edu_end_yearIds").css("color", "#333")
	
}
function tkfUser(number){
	$.post("tkfuser/findTkfUser",{us_id:number.l_id},function(data){
		if(data!=0){
			listTkfUser=data;
		}
	},"json");
}
function UsResume(params){
	$.post("tkfuser/findUsResume",params,function(data){
		if(data!=0){
			listUsResume=data;
			$(".descriptionShow").html(data[0].des_content);
			$(".expectShow").html(data[0].hj_city+','+data[0].hj_name+',月薪'+data[0].hj_min_salary+'-'+data[0].hj_max_salary+','+(data[0].hj_nature=='-0'?'全职':(data[0].hj_nature=='-1'?'兼职':'实习')));
			$("#select_hjCity").val(data[0].hj_city);
			//期望工作和自我描述
			$("#hjCity").val(data[0].hj_city);
			$("#hjPosition").val(data[0].hj_name);
			$("#hjSalary").val(data[0].hj_min_salary+'-'+data[0].hj_max_salary);
			$("#select_hjSalary").val(data[0].hj_min_salary+'-'+data[0].hj_max_salary);
			$("#des_contentId").text(data[0].des_content);
		}
	},"json");
}
function experience(params){
	$.post("tkfuser/findExperience",params,function(data){
		if(data!=0){
			listExperience=data;
			$(".experienceShow").html('<ul class="wlist clearfix"><li class="clear"><span class="c9">'+data[0].exp_start_year+'-'+data[0].exp_end_year+'</span><div><img width="56" height="56" alt="'+data[0].exp_company_name+'" src="style/images/logo_default.png"><h3>'+data[0].exp_job_name+'</h3><h4>'+data[0].exp_company_name+'</h4></div></li></ul>');
			//工作经历 
			var startTime=data[0].exp_start_year;
			var endTime=data[0].exp_end_year;
			var startTimes=startTime.split(".");
			var endTimes=endTime.split(".");
			$("#exp_company_nameId").val(data[0].exp_company_name);
			$("#exp_job_nameId").val(data[0].exp_job_name);
			$("#companyYearStartId").val(startTimes[0]);
			$("#companyYearStartIds").val(startTimes[0]);
			$("#companyMonthStartId").val(startTimes[1]);
			$("#companyMonthStartIds").val(startTimes[1]);
			$("#companyYearEndId").val(endTimes[0]);
			$("#companyYearEndIds").val(endTimes[0]);
			$("#companyMonthEndId").val(endTimes[1]);
			$("#companyMonthEndIds").val(endTimes[1]);
		}
	},"json");
}
function educationa(params){
	$.post("tkfuser/findEducationa",params,function(data){
		if(data!=0){
			listEducationa=data;
			setTimeout(function showInfos(){
				//学历信息
				
				//教育背景
				$("#edu_shool_nameId").val(data[0].edu_shool_name);
				$("#edu_educationaId").val(data[0].edu_educationa);
				$("#edu_educationaIds").val(data[0].edu_educationa);
				$("#edu_majorId").val(data[0].edu_major);
				$("#edu_start_yearId").val(data[0].edu_start_year);
				$("#edu_start_yearIds").val(data[0].edu_start_year);
				$("#edu_end_yearId"). val(data[0].edu_end_year);
				$("#edu_end_yearIds").val(data[0].edu_end_year);
				//基本信息
				$(".basicShow span").html(listTkfUser[0].us_name+' | '+listTkfUser[0].us_sex+' | 经验: '+listTkfUser[0].us_work_year+' | '+listExperience[0].exp_city+'<br> '+listExperience[0].exp_job_name+'·'+listExperience[0].exp_company_name+' | '+listTkfUser[0].us_educationa+' · '+data[0].edu_shool_name+'<br> '+listTkfUser[0].us_phone+' | '+listTkfUser[0].us_email+'<br>');
				$(".basicShow img").attr("src",(listTkfUser[0].us_picpath==null?'style/images/default_headpic.png':listTkfUser[0].us_picpath));
			}, 80);
		}
	},"json");
}


$("#education").click(function(){
	var schoolName=$('.schoolName').val();
	//alert("schoolName "+schoolName);
});
$("#expId").click(function(){

});

$(".c_edit").click(function(){
	if(listUsResume[0]!=null){
		//alert(JSON.stringify(listTkfUser));
		//alert(JSON.stringify(listUsResume));
		$("#names input").val(listUsResume[0].usr_name);
		$("#us_phone").val(listTkfUser[0].us_phone);
		$("#us_email").val(listTkfUser[0].us_email);
		$("#topDegree").val(listTkfUser[0].us_educationa);
		$("#select_topDegree").val(listTkfUser[0].us_educationa);
		$("#workyear").val(listTkfUser[0].us_work_year);
		$("#select_workyear").val(listTkfUser[0].us_work_year);
		$("#currentState").val(listTkfUser[0].us_intro);
		$("#select_currentState").val(listTkfUser[0].us_intro);
		if(listTkfUser[0].us_sex=="男"){ 
			$("#us_sexId li").removeClass("current");
			$("#us_sexId li:eq(0)").attr("class","current");
		}else if(listTkfUser[0].us_sex=="女"){
			$("#us_sexId li").removeClass("current");
			$("#us_sexId li:eq(1)").css("class","current");
		}
	}
	
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