loadInfo();
var str='';
function loadInfo(){
	show();
}
function show(){
	str='';
	$.post("job/findCompanyJob",function(data){
		//alert(data.length);
		for(var i=0;i<data.length;i++){
			str+='<li ><h3><a target="_blank" title="随便写" href="http://www.lagou.com/jobs/149594.html">'+data[i].job_name+'</a> '
				+'<span>[上海]</span></h3> <span class="receivedResumeNo"><a href="unHandleResumes.html?positionId=149594">应聘简历（1）</a></span> '
				+'<div>兼职 / 1k-2k / 1-3年 / 硕士及以上</div><div class="c9">发布时间： 2014-07-01 17:07:01</div> '
				+'<div class="links"><a class="job_refresh" href="javascript:void(0)">刷新<span>每个职位7天内只能刷新一次</span></a> '
				+'<a target="_blank" class="job_edit" href="create.html?positionId='+data[i].job_id+'">编辑</a> '
				+'<a class="job_offline" href="javascript:void(0)">下线</a> <a class="job_del" href="javascript:void(0)">删除</a></div></li>';
		}
		$("#positionNumber").html(data.length);
		$("#showJob").html(str);
	},"json");
}
