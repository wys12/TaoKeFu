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
	cssId();
}
function cssId(){
	$("#select_expectCity").css("color", "color: rgb(153, 153, 153)"),
	$("#select_expectSalary").css("color", "color: rgb(153, 153, 153)"),
	$("#companyYearStartIds").css("color", "color: rgb(153, 153, 153)"),
	$("#companyMonthStartIds").css("color", "color: rgb(153, 153, 153)"),
	$("#companyYearEndIds").css("color", "color: rgb(153, 153, 153)"),
	$("#companyMonthEndIds").css("color", "color: rgb(153, 153, 153)"),
	$("#edu_educationaIds").css("color", "color: rgb(153, 153, 153)"),
	$("#edu_start_yearIds").css("color", "color: rgb(153, 153, 153)"),
	$("#select_topDegree").css("color", "color: rgb(153, 153, 153)"),
	$("#select_topDegree").css("color", "color: rgb(153, 153, 153)"),
	$("#hjPosition").css("color", "color: rgb(153, 153, 153)"),
	$("#select_currentState").css("color", "color: rgb(153, 153, 153)"),
	$("#edu_end_yearIds").css("color", "color: rgb(153, 153, 153)")

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
			$("#select_expectCity").val(data[0].hj_city);
			//期望工作和自我描述
			$("#expectCity").val(data[0].hj_city);
			$("#hjPosition").val(data[0].hj_name);
			$("#select_expectSalary").val(data[0].hj_min_salary+'-'+data[0].hj_max_salary);
			$("#expectSalary").val(data[0].hj_min_salary+'-'+data[0].hj_max_salary);
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
			var startTimes=startTime.split("-");
			var endTimes=endTime.split("-");
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
		listEducationa=data;
		setTimeout(function showInfos(){
			if(data!=0){
				//教育背景 学历信息
				$("#edu_shool_nameId").val(data[0].edu_shool_name);
				$("#edu_educationaId").val(data[0].edu_educationa);
				$("#edu_educationaIds").val(data[0].edu_educationa);
				$("#edu_majorId").val(data[0].edu_major);
				$("#edu_start_yearId").val(data[0].edu_start_year);
				$("#edu_start_yearIds").val(data[0].edu_start_year);
				$("#edu_end_yearId"). val(data[0].edu_end_year);
				$("#edu_end_yearIds").val(data[0].edu_end_year);
			}
			if(listExperience[0]!=null && data[0]!=null){
				$(".basicShow span").html(listTkfUser[0].us_name+' | '+listTkfUser[0].us_sex+' | 经验: '+listTkfUser[0].us_work_year+' | '
						+listExperience[0].exp_city+'<br> '+listExperience[0].exp_job_name+'·'+listExperience[0].exp_company_name+' | '
						+listTkfUser[0].us_educationa+' · '+data[0].edu_shool_name+'<br> '+listTkfUser[0].us_phone+' | '+listTkfUser[0].us_email+'<br>');
			}else if(listExperience[0]!=null){
				$(".basicShow span").html(listTkfUser[0].us_name+' | '+listTkfUser[0].us_sex+' | 经验: '+listTkfUser[0].us_work_year+' | '
						+listExperience[0].exp_city+'<br> '+listExperience[0].exp_job_name+'·'+listExperience[0].exp_company_name+' | '
						+listTkfUser[0].us_educationa+' · '+'<br> '+listTkfUser[0].us_phone+' | '+listTkfUser[0].us_email+'<br>');
			}else if(data[0]!=null){
				$(".basicShow span").html(listTkfUser[0].us_name+' | '+listTkfUser[0].us_sex+' | 经验: '+listTkfUser[0].us_work_year+' | '
						+listTkfUser[0].us_educationa+' · '+data[0].edu_shool_name+'<br> '+listTkfUser[0].us_phone+' | '+listTkfUser[0].us_email+'<br>');
			}else{
				$(".basicShow span").html(listTkfUser[0].us_name+' | '+listTkfUser[0].us_sex+' | 经验: '+listTkfUser[0].us_work_year+' | '
						+listTkfUser[0].us_educationa+'<br> '+listTkfUser[0].us_phone+' | '+listTkfUser[0].us_email+'<br>');
			}
				$(".basicShow img").attr("src",(listTkfUser[0].us_picpath==null?'style/images/default_headpic.png':listTkfUser[0].us_picpath));
		}, 80);
		//基本信息
	},"json");
}


$("#education").click(function(){
	var schoolName=$('.schoolName').val();
	//alert("schoolName "+schoolName);
});
$("#expId").click(function(){

});

$(".c_edit").click(function(){
	if(listTkfUser[0]!=null){
		$("#names input").val(listTkfUser[0].us_name);
		$("#us_phone").val(listTkfUser[0].us_phone);
		$("#us_email").val(listTkfUser[0].us_email);
		$("#select_topDegree").val(listTkfUser[0].us_educationa);
		$("#topDegree").val(listTkfUser[0].us_educationa);
		$("#select_workyear").val(listTkfUser[0].us_work_year);
		$("#workyear").val(listTkfUser[0].us_work_year);
		$("#select_currentState").val(listTkfUser[0].us_intro);
		$("#currentState").val(listTkfUser[0].us_intro);
		if(listTkfUser[0].us_sex=="男"){ 
			$("#us_sexId li").removeClass("current");
			$("#us_sexId li:eq(0)").attr("class","current");
		}else if(listTkfUser[0].us_sex=="女"){
			$("#us_sexId li").removeClass("current");
			$("#us_sexId li:eq(1)").css("class","current");
		}
	}
});
// 用户信息添加
$("#userInfo").click(function(){
	formURL('tkfuser/modifiTkfUser',"#profileForm");
});
// 期望工作添加
function hbId(){
	alert("期望工作");
	formURL('tkfuser/insertUsResume',"#expectForm");
};
// 工作经历添加
function expId(){
	var exp_start_year=$("#companyYearStartId").val()+"-"+$("#companyMonthStartId").val();
	var exp_end_year=$("#companyYearEndId").val()+"-"+$("#companyMonthEndId").val();
	var exp_company_name =$("#exp_company_nameId").val() ;
	var exp_job_name =$("#exp_job_nameId").val() ;
	var exParams = {exp_start_year:exp_start_year,exp_end_year:exp_end_year,exp_company_name:exp_company_name,exp_job_name:exp_job_name};
	$.post("tkfuser/insertExperience",exParams,function(data){
		alert(data);
	},"json");
};
// 学历信息
function eduId(){
	alert("学历信息");
	formURL('tkfuser/insertEducationa',".educationalForm");
};
//描述信息
function desId(){
	alert("描述信息");
	formURL('tkfuser/modifiUsResume',".descriptionForm");
}
function formURL(urlParams,dataParams){
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
			if(urlParams=='tkfuser/modifiTkfUser'){
				alert(data);
				$("#basicEdit").attr("class","basicEdit dn");
				$("#basicShow").attr("class","basicShow");
				$("#user_c_edit").attr("class","c_edit");
			}else if(urlParams=='tkfuser/insertEducationa'){
				alert(data);
			}
		}
	})
}