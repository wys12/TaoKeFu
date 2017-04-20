var str="";
var state="";
function loadInfo(number){
	state=number.l_id;
	showResume(state,"-10");
};

function showResume(number,usr_state){
	str="";
	$("#deliveryResume").html(str);
	$.post("resume/findUserResume",{usr_id:number,usr_state:usr_state},function(data){
		for(var i=0;i<data.length;i++){
			str+='<li><div class="d_item"><h2 title="随便写"><a target="_blank" href="http://www.lagou.com/jobs/149594.html"> <em>'+data[i].us_name+'</em><span>（1k-2k）</span></a></h2>'
			+'<div class="clear"></div><a title="公司名称" class="d_jobname" target="_blank" href="myhome.html?'+data[i].c_id+'"> <span>[上海]</span></a> <span class="d_time">2017-04-01 17:15</span>'
			+'<div class="clear"></div><div class="d_resume">使用简历： <span> 在线简历 </span></div></div>'
			otherInfo(data[i].job_id,data[i].c_id);
		}
		//alert(JSON.stringify(data));
		$("#deliveryResume").html(str);
	},"json");
}
function otherInfo(job_id,c_id){
	//alert(job_id+"=="+c_id);
	findResumeJob(job_id);
	findResumeCompany(c_id);
}
function findResumeJob(job_id){
	$.post("job/findResumeJob",{job_id:job_id},function(data){
		//alert("job=="+data[0].job_name);
		$(".d_jobname").text(data[0].job_name);
	},"json");
}
function findResumeCompany(comp_id){
	$.post("company/findResumeCompany",{comp_id:comp_id},function(data){
		//alert("company=="+data[0].comp_name);
		$(".d_jobname").text(data[0].job_name);
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