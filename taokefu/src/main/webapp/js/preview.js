function loadInfo(number){
	if(number!=null && number!=""){
		alert(number);
		shouInfo(number);
	}else{
		alert("请先登录");
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
			$(".basicShow").html('<span>'+listUsResume[0].usr_name+' | '+listTkfUser[0].us_sex+' | '+listExperience[0].exp_work+'工作经验 | '+listExperience[0].exp_city+'<br> '+listExperience[0].exp_job_name+'·'+listExperience[0].exp_company_name+' | '+data[0].edu_educationa+' · '+data[0].edu_shool_name+'<br> '+listTkfUser[0].us_phone+' | '+listTkfUser[0].us_email+'<br></span>'
					+'<div class="m_portrait"><div></div><img width="120" height="120" alt="'+listUsResume[0].usr_name+'" src="'+(listTkfUser[0].us_picpath==null?'style/images/default_headpic.png':listTkfUser[0].us_picpath)+'">');
		}, 80);
		
	},"json");
}
