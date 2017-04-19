loadInfo();
function loadInfo(){
	$("#resumeRefuseAll").attr("class","inappropriateRes");
	showResume("-1");
}
var str='';
function showResume(usr_state){
	$.post("resume/findResume",{usr_state:usr_state},function(data){
		console.info(JSON.stringify(data));
		str='';
		for(var i=0;i<data.length;i++){
			str+=('<li data-id="1686182" class="onlineResume"><label class="checkbox"> <input type="checkbox"> <i></i></label><div class="resumeShow">'
					+'<a title="预览在线简历" target="_blank" class="resumeImg" href="resumeView.html?deliverId=1686182"> <img src="style/images/default_headpic.png"></a>'
					+'<div class="resumeIntro"><h3 class="unread"><a target="_blank" title="预览jason的简历" href="preview.html?tkf_id='+data[i].usr_id+'"> '+data[i].usr_name+'</a> <em></em><a target="_blank" href="javascript:void(0)" id="'+data[i].job_id+'"></a></h3><span class="fr">投递时间：2017-04-16 16:08</span>'
					+'<div>'+data[i].us_name+' / '+data[i].us_sex+' / '+data[i].us_educationa+' / '+data[i].us_work_year+' / '+data[i].hj_city+' <br> '+data[i].exp_job_name+' · '+data[i].exp_company_name+' | '+data[i].edu_educationa+'· '+data[i].edu_shool_name+'</div>'
					+'<div class="links"><a data-deliverid="1686182" data-name="jason" data-positionid="149594" data-email="888888888@qq.com" class="resume_notice" href="javascript:void(0)">通知面试</a> '
					+'<a data-deliverid="1686182" class="resume_refuse" href="javascript:void(0)">不合适</a> '
					+'<a data-resumename="jason的简历" data-positionname="随便写" data-deliverid="1686182" data-positionid="149594" data-resumekey="1ccca806e13637f7b1a4560f80f08057"'
					+'data-forwardcount="1" class="resume_forward" href="javascript:void(0)"> 转发 <span>(1人)</span></a></div></div>'
					+'<div class="contactInfo"><span class="c9">电话：</span><span>'+data[0].us_phone+' &nbsp;&nbsp;&nbsp;</span> <span class="c9">邮箱：</span><a href="javascript:void(0)">'+data[0].us_email+'</a></div></li>');
			$.post("job/findJob",{job_id:data[i].job_id},function(data1){
				$("#"+data1[0].job_id+"").text(" | "+data1[0].job_name);
				$("#"+data1[0].job_id+"").attr("href","toudi.html");
			},"json");
		}
		$("#showInfo").html(str);
	},"json");
}
$("#resume_0").click(function(){
	$("#resumeRefuseAll").text("标记为查看");
	$("#resumeRefuseAll").attr("class","examineRes");
	showResume("-0");
	companyResumeClass(0);
});
$("#resume_1").click(function(){
	$("#resumeRefuseAll").text("标记为不合适");
	$("#resumeRefuseAll").attr("class","inappropriateRes");
	showResume("-1");
	companyResumeClass(1);
});
$("#resume_2").click(function(){
	$("#resumeRefuseAll").text("标记为通过");
	$("#resumeRefuseAll").attr("class","passRes");
	showResume("-2");
	companyResumeClass(2);
});
$("#resume_3").click(function(){
	$("#resumeRefuseAll").text("标记为删除");
	$("#resumeRefuseAll").attr("class","deleteRes");
	showResume("-3");
	companyResumeClass(3);
});
$("#resume_4").click(function(){
	alert("自动过滤简历");
	companyResumeClass(4);
});

//查看过的简历
$(".examineRes").click(function(){
	alert("执行简历状态改为查看操作");
});
//不合适的简历
$(".inappropriateRes").click(function(){
	alert("执行简历状态改为不合适操作");
});
//通过的简历
$(".passRes").click(function(){
	alert("执行简历状态改为通过操作");
});
//删除简历
$(".deleteRes").click(function(){
	alert("执行简历状态改为删除操作");
});

function companyResumeClass(number){
	$("#companyResume dd").removeClass("current");
	$("#companyResume dd:eq("+number+")").attr("class","current");
}
