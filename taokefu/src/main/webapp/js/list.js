loadInfo();
var str="";
function loadInfo(){
	$.post("job/findJobs",function(data){
		shouInfo(data);
	},"json");
}
$("#search_button").click(function(){
	sendInfo($('#search_input').val());
});

function sendInfo(data){
	$.post("job/lists",{job_name:data},function(){
		loadInfo();
	},"json");
}
function shouInfo(data){
	//alert(JSON.stringify(data));
	str="";
	for(var i=0;i<data.length;i++){
		str+='<li class="clearfix"><div class="hot_pos_l"><div class="mb10"><a href="h/jobs/114177.html" title="'+data[i].job_name+'" target="_blank">'+data[i].job_name+'</a>&nbsp; <span class="c9">[北京]</span></div>'
		+'<span><em class="c7">月薪：</em>'+data[i].job_min_salary+'-'+data[i].job_max_salary+'</span> <span><em class="c7">经验：</em> 3-5年</span> <span><em class="c7">最低学历：'
		+data[i].job_request+'</em></span> <br /> <span><em class="c7">职位诱惑：</em>第一家互联网私人银行招募各路牛人</span><br /> <span>'+data[i].job_ftime+'发布</span>'
		+'</div><div class="hot_pos_r"><div class="apply"><a href="toudi.html" target="_blank">投个简历</a></div><div class="mb10"><a href="'+data[i].pro_link+'" title="'+data[i].comp_name+'" target="_blank">'+data[i].comp_name+'</a></div>'
		+'<span><em class="c7">领域： </em>'+data[i].tag_name+'</span> <span><em class="c7">创始人：</em> '+data[i].ct_name+'</span> <br /> <span><em class="c7">阶段： </em>成长型(A轮)</span> <span><em class="c7">规模：'
		+'</em>15-50人</span><ul class="companyTags reset"><li>股票期权</li><li>五险一金</li><li>带薪年假</li></ul></div></li>';
	}
	$("#jobInfo").html(str);
}
/*function number(number){
	alert("list "+ number);
	if(number==0 && i>0){
		alert("首页");
		i=1;
	}else if(number==1 && i>0){
		alert("上一页");
		i=i+1;
	}else if(number==2 && i>0){
		alert("下一页");
		i=i-1;
	}else if(number==3 && i>0){
		alert("未页");
		i=-1;
	}else{
		i=1;
	}
	sendInfo();
	outLoadInfo();
}*/
/*$.post("company/findCompany",{comp_name:search_input},function(data){alert(data);},"json");*/
