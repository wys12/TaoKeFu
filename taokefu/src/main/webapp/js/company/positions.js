loadInfo();
var str='';
function loadInfo(){
	show("-0");
}
/**
 *有效的职位
 */
$("#valid").click(function(){
	$("#companyJob dd:eq(1)").attr("class","");
	$("#companyJob dd:eq(0)").attr("class","current");
	show("-0");
});
/**
 * 无效的职位
 */
$("#Invalid").click(function(){
	$("#companyJob dd:eq(0)").attr("class","");
	$("#companyJob dd:eq(1)").attr("class","current");
	showInvalid("-1");
});
function show(job_state){
	str='';
	$.post("job/findCompanyJob",{job_state:job_state},function(data){
		//alert(data.length);
		$(".company_center_content dt h1").html('<em></em> 有效职位 <span>（共<i style="color: #fff; font-style: normal" id="positionNumber"></i>个）</span>');
		//console.info(JSON.stringify(data));
		for(var i=0;i<data.length;i++){
			str+='<li ><h3><a target="_blank" title="随便写" href="create.html?positionId='+data[i].job_id+'">'+data[i].job_name+'</a> '
				+'<span>待定</span></h3> <span class="receivedResumeNo"><a href="unHandleResumes.html?positionId=149594"></a></span> '
				+'<div>'+data[i].job_nature+' / '+data[i].job_min_salary+'k-'+data[i].job_max_salary+'k / 1-3年 / '+data[i].job_education+'</div><div class="c9">发布时间：'+data[i].job_ftime+'</div> '
				+'<div class="links"><a class="job_refresh" href="javascript:void(0)">刷新<span>每个职位7天内只能刷新一次</span></a> '
				+'<a target="_blank" class="job_edit" href="create.html?positionId='+data[i].job_id+'">编辑</a> '
				+'<a class="job_offline" onclick="jobOffLine('+data[i].job_id+')" href="javascript:void(0)">下线</a> <a class="job_del" href="javascript:void(0)" onclick="jobDel('+data[i].job_id+')">删除</a></div></li>';
		}//应聘简历（'+data.length+'）
		$("#positionNumber").html(data.length);
		$("#showJob").html(str);
	},"json");
}
function showInvalid(job_state){
	str='';
	$(".company_center_content dt h1").html('<em></em> 下线职位 <span>（共<i style="color: #fff; font-style: normal" id="positionNumber"></i>个）</span>');
	$.post("job/findCompanyJob",{job_state:job_state},function(data){
		//alert(data.length);
		//console.info(JSON.stringify(data));
		for(var i=0;i<data.length;i++){
			str+='<li ><h3><a target="_blank" title="随便写" href="create.html?positionId='+data[i].job_id+'">'+data[i].job_name+'</a> '
				+'<span>待定</span></h3> <span class="receivedResumeNo"><a href="unHandleResumes.html?positionId=149594">应聘简历（'+data.length+'）</a></span> '
				+'<div>'+data[i].job_nature+' / '+data[i].job_min_salary+'k-'+data[i].job_max_salary+'k / 1-3年 / '+data[i].job_education+'</div><div class="c9">发布时间：'+data[0].job_ftime+'</div> '
				+'<div class="links"> '
				+'<a target="_blank" class="job_edit" href="create.html?positionId='+data[i].job_id+'">编辑</a> '
				+'<a class="job_offline" onclick="jobLine('+data[i].job_id+')" href="javascript:void(0)">上线</a> <a class="job_del" href="javascript:void(0)" onclick="jobDel('+data[i].job_id+')">删除</a></div></li>';
		}
		$("#positionNumber").html(data.length);
		$("#showJob").html(str);
	},"json");
}

/**
 * 删除职位
 * @param job_id
 */
function jobDel(job_id){
	alert("删除职位id=="+job_id);
}
/**
 * 有效职位中下线职位
 * @param job_id
 */
function jobOffLine(job_id){
	//alert("下线职位id=="+job_id);
	jobState("-1",job_id);
}
/**
 * 下线职位中上线职位
 * @param job_id
 */
function jobLine(job_id){
	//alert("上线职位id=="+job_id);
	jobState("-0",job_id);
}
function jobState(job_state,job_id){
	$.post("job/modifiJobState",{job_id:job_id,job_state:job_state},function(data){
		job_state=="-0"?showInvalid("-1"):show("-0");
	},"json");
}
