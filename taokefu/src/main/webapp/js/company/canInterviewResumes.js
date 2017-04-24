loadInfo();
function loadInfo(){	
	$("#resumeRefuseAll").text("标记为查看");
	$("#resumeRefuseAll").attr("class","examineRes");
	showResume("-0");
}
var str='';
function showResume(usr_state){
	$.post("resume/findResume",{usr_state:usr_state},function(data){
		str='';
		$("#showInfo").html(str);
		//console.info(JSON.stringify(data));
		for(var i=0;i<data.length;i++){
			str+=('<li " class="onlineResume"><label > <input name="BoxCheck" value="'+data[i].job_id+'" type="checkbox"> <i></i></label><div class="resumeShow">'
					+'<a title="预览在线简历" target="_blank" class="resumeImg" href="resumeView.html?deliverId=1686182"> <img src="style/images/default_headpic.png"></a>'
					+'<div class="resumeIntro"><h3 class="unread"><a target="_blank" title="预览jason的简历" href="preview.html?tkf_id='+data[i].usr_id+'"> '+data[i].usr_name+'</a> <em></em><a target="_blank" href="javascript:void(0)" id="'+data[i].job_id+'"></a></h3><span class="fr">投递时间：2017-04-16 16:08</span>'
					+'<div>'+data[i].us_name+' / '+data[i].us_sex+' / '+data[i].us_educationa+' / '+data[i].us_work_year+' / '+data[i].hj_city+' <br> '+data[i].exp_job_name+' · '+data[i].exp_company_name+' | '+data[i].edu_educationa+'· '+data[i].edu_shool_name+'</div>'
					+'<div class="links"><a data-deliverid="1686182" data-name="jason" data-positionid="149594" data-email="888888888@qq.com" class="resume_notice" onclick="companyResumeState(-2,'+data[i].job_id+')" href="javascript:void(0)">通知面试</a> '
					+'<a data-deliverid="1686182" class="resume_refuse" onclick="companyResumeState(-4,'+data[i].job_id+')" href="javascript:void(0)">不合适</a> '
					+'</div></div><div class="contactInfo"><span class="c9">电话：</span><span>'+data[0].us_phone+' &nbsp;&nbsp;&nbsp;</span> <span class="c9">邮箱：</span><a href="javascript:void(0)">'+data[0].us_email+'</a></div></li>');
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
	//$('#resumeRefuseAll').unbind("click");
	$("#resumeRefuseAll").removeClass("inappropriateRes","passRes","deleteRes");
	$("#resumeRefuseAll").attr("class","examineRes");
	showResume("-0");
	companyResumeClass(0);
});
/**
 * 待定（查看的简历）
 */
$("#resume_1").click(function(){
	$("#resumeRefuseAll").text("标记为不合适");
	$("#resumeRefuseAll").removeClass("examineRes","passRes","deleteRes");
	$("#resumeRefuseAll").attr("class","inappropriateRes");
	showResume("-1");
	companyResumeClass(1);
});
/**
 * 通知面试
 */
$("#resume_2").click(function(){
	$("#resumeRefuseAll").removeClass();
	$("#resumeRefuseAll").text("标记为通过");
	$("#resumeRefuseAll").removeClass("examineRes","inappropriateRes","deleteRes");
	$("#resumeRefuseAll").attr("class","passRes");
	showResume("-2");
	companyResumeClass(2);
});
/**
 * 不合适简历
 */
$("#resume_3").click(function(){
	$("#resumeRefuseAll").text("标记为删除");
	$("#resumeRefuseAll").removeClass("examineRes","passRes","inappropriateRes");
	$("#resumeRefuseAll").attr("class","deleteRes");
	showResume("-4");
	companyResumeClass(3);
});
$("#resume_4").click(function(){
	$("#resumeRefuseAll").text("标记为删除");
	$("#resumeRefuseAll").removeClass("examineRes","passRes","inappropriateRes");
	$("#resumeRefuseAll").attr("class","deleteRes");
	showResume("-3");
	companyResumeClass(4);
});

function stateRes(){
	var job_id = $("input:checkbox[name='BoxCheck']:checked").map(function(index,elem) {
		return $(elem).val();
	}).get().join(',');
	switch($("#resumeRefuseAll").attr("class")){
	case "examineRes":companyResumeState("-1",job_id);break;//标记为查看
	case "inappropriateRes":companyResumeState("-4",job_id);break;//标记为不合适
	case "passRes":companyResumeState("-3",job_id);break;//标记为通过
	case "deleteRes":companyResumeDelete();break;//标记为删除
	default: alert("sss");break;
	}
};

function companyResumeClass(number){
	$("#companyResume dd").removeClass("current");
	$("#companyResume dd:eq("+number+")").attr("class","current");
}
/**
 * 修改简历状态
 * @param usr_state
 * @param job_id
 */
function companyResumeState(usr_state,job_id){
	var getClass=$("#resumeRefuseAll").attr("class");
	$.post("resume/modifiResumeState",{usr_state:usr_state,job_id:job_id},function(data){
		switch(getClass){
		case "examineRes":showResume("-0");break;
		case "inappropriateRes":showResume("-1");break;
		case "passRes":showResume("-2");break;
		case "deleteRes":showResume("-4");break;
		default: alert("面试通过！！！");break;}
		//alert("修改成功！！！"+getClass);
	},"json");
}
/**
 * 删除简历
 */
function companyResumeDelete(){
	text = $("input:checkbox[name='BoxCheck']:checked").map(function(index,elem) {
		return $(elem).val();
	}).get().join(',');
	$.post("resume/deleteResumeState",{job_id:text},function(data){
		showResume("-3");
		//alert("删除成功！！！");
	},"json");
}
//$(":checked").val();
/*if($("#checkAll").attr("checked")==true){
	alert("已经全选");
}else if($("#checkAll").attr("checked")==false){
	alert("未全选");
}$(":checkbox").attr("checked",true);
    if ($(this).attr("checked")) {  
      $("input[name=BoxCheck]").each(function() {  
          $(this).attr("checked", true);  
      });  
  } else {  
      $("input[name=BoxCheck]").each(function() {  
          $(this).attr("checked", false);  
      });  
  } */
/*//查看过的简历
$(".examineRes").click(function(){
	alert("执行简历状态改为查看操作");
	companyResumeState("-1");
});
//不合适的简历
$(".inappropriateRes").click(function(){
	alert("执行简历状态改为不合适操作");
	companyResumeState("-2");
});
//通过的简历
$(".passRes").click(function(){
	alert("执行简历状态改为通过操作");
	companyResumeState("-3");
});
//删除简历
$(".deleteRes").click(function(){
	alert("执行简历状态改为删除操作");
});
 */
