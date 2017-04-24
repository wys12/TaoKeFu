var str="";
var state="";
var s="";
function loadInfo(number){
	state=number.l_id;
	showResume(state,"-10");
};

function showResume(number,usr_state){
	str="";
	$("#deliveryResume").html(str);
	$.post("resume/findUserResume",{usr_id:number,usr_state:usr_state},function(data){
		for(var i=0;i<data.length;i++){
			console.info(JSON.stringify(data));
			str+='<li><div class="d_item"><h2 title="随便写"><a target="_blank" href="http://www.lagou.com/jobs/149594.html"> <em>'+data[i].us_name+'</em><span id="job_salary'+i+'"></span></a></h2>'
			+'<div class="clear"></div><div class="d_resume">职位名称： <span id="d_jobname'+i+'"></span></div>'
			+'<div class="clear"></div><div class="d_resume">公司名称：<span id="d_comname'+i+'"></span></div><span id="d_time'+i+'" class="d_time">'+data[i].res_modifiTime+'</span></div>'
			findResumeJob(data[i].job_id,i);
			findResumeCompany(data[i].c_id,i);
			/*
		 * otherInfo(data[i].job_id,data[i].c_id);	$.post("company/findResumeCompany",{comp_id:data[i].c_id},function(data1){
				//alert("1=="+data1[0].comp_name);
				$(".d_jobname"+i+"").html(data1[0].comp_name);
			},"json");<a title="公司名称" target="_blank" href="myhome.html?'+data[i].c_id+'">*/
			
		}
		//alert(JSON.stringify(data));
		$("#deliveryResume").html(str);
	},"json");
}
function findResumeJob(job_id,i){
	$.post("job/findResumeJob",{job_id:job_id},function(data2){
		$("#d_jobname"+i+"").text(data2[0].job_name);
		$("#job_salary"+i+"").text('（'+data2[0].job_min_salary+'-'+data2[0].job_max_salary+'）');
	},"json");
}
function findResumeCompany(comp_id,i){
	//alert("comp_id=="+comp_id);
	$.post("company/findResumeCompany",{comp_id:comp_id},function(data1){
		$("#d_comname"+i+"").text(data1[0].comp_name);
	},"json");
}
$("#allResume").click(function(){
	showResumeTitle("allResume");
	showResume(state,"-10");
});
/**
 * 投递成功
 */
$("#succeed_deliver").click(function(){
	showResumeTitle("succeed_deliver");
	showResume(state,"-0");
});
/**
 * 查看
 */
$("#examine").click(function(){
	showResumeTitle("examine");
	showResume(state,"-1");
});
/**
 * 通知面试
 */
$("#notification").click(function(){
	showResumeTitle("notification");
	showResume(state,"-2");
});
/**
 * 面试成功
 */
$("#succeed_interview").click(function(){
	showResumeTitle("succeed_interview");
	showResume(state,"-3");
});
/**
 * 不合适
 */
$("#inappropriate").click(function(){
	showResumeTitle("inappropriate");
	showResume(state,"-4");
});
function showResumeTitle(titleId){
	$("#ul_Resume li").removeClass("current");
	$("#"+titleId+"").attr("class","current");
}