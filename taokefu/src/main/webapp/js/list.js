loadInfo();
var str="";
var t = getUrlParam('search_input');
function loadInfo(){
	$.post("job/findJobs",function(data){
		if(t!=null && t!=""){
			$("#search_input").val(t);
			t="";
		}else{
			$("#search_input").val($('#search_input').val());
		}
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
$(".job_education").click(function(){
	var params= {job_education:$(this).text(),job_name:$('#search_input').val()};
	$.post("job/findRange",params,function(data){
		shouInfo(data);
	},"json");
});
$(".job_nature").click(function(){
	var params= {job_nature:$(this).text(),job_name:$('#search_input').val()};
	$.post("job/findRange",params,function(data){
		//alert(JSON.stringify(data));
		shouInfo(data);
	},"json");
});
$(".job_experience").click(function(){
	var params= {job_experience:$(this).text(),job_name:$('#search_input').val()};
	$.post("job/findRange",params,function(data){
		shouInfo(data);
	},"json");
});
$(".job_min_salary").click(function(){
	var params= {job_min_salary:$(this).text(),job_name:$('#search_input').val()};
	$.post("job/findRange",params,function(data){
		shouInfo(data);
	},"json");
});
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
function shouInfo(data){
	str="";
	for(var i=0;i<data.length;i++){
		/*str+='<li class="clearfix"><div class="hot_pos_l"><div class="mb10"><a href="h/jobs/114177.html" title="'+data[i].job_name+'" target="_blank">'+data[i].job_name+'</a>&nbsp; <span class="c9">[北京]</span></div>'
		+'<span><em class="c7">月薪：</em>'+data[i].job_min_salary+'k-'+data[i].job_max_salary+'k</span> <span><em class="c7">经验：</em> 3-5年</span> <span><em class="c7">最低学历：'
		+data[i].job_education+'</em></span> <br /> <span><em class="c7">职位诱惑：</em>'+data[i].job_tempt+'</span><br /> <span>'+data[i].job_ftime+'发布</span>'
		+'</div><div class="hot_pos_r"><div class="apply"><a href="toudi.html" onclick="toudi('+data[i].job_id+')">投个简历</a></div><div class="mb10"><input hidden="" class="c_id" value="'+data[i].c_id+'"><a href="'+data[i].pro_link+'" title="'+data[i].comp_name+'" target="_blank">'+data[i].comp_name+'</a></div>'
		+'<span><em class="c7">领域： </em>'+data[i].tag_name+'</span> <span><em class="c7">创始人：</em> '+data[i].ct_name+'</span> <br /> <span><em class="c7">阶段： </em>成长型(A轮)</span> <span><em class="c7">规模：'*/
		+'</em>15-50人</span><ul class="companyTags reset"><li>股票期权</li><li>五险一金</li><li>带薪年假</li></ul></div></li>';
		if(i%2==0){
			str+='<li class="clearfix"><div class="hot_pos_l"><div class="mb10"><a href="toudi.html" onclick="toudi('+data[i].job_id+')" title="'+data[i].job_name+'" target="_blank">'+data[i].job_name+'</a>&nbsp; <span class="c9">['+data[i].comp_city+']</span></div>'
			+'<span><em class="c7">月薪：</em>'+data[i].job_min_salary+'k-'+data[i].job_max_salary+'k</span> <span><em class="c7">经验：</em> 3-5年</span> <span><em class="c7">最低学历：'
			+data[i].job_education+'</em></span> <br /> <span><em class="c7">职位诱惑：</em>'+data[i].job_tempt+'</span><br /> <span>'+data[i].job_ftime+'发布</span>'
			+'</div><div class="hot_pos_r"><div class="apply"><a href="toudi.html" onclick="toudi('+data[i].job_id+')">投个简历</a></div><div class="mb10"><input hidden="" class="c_id" value="'+data[i].c_id+'"><a href="'+data[i].pro_link+'" title="'+data[i].comp_name+'" target="_blank">'+data[i].comp_name+'</a></div>'
			+'<span><em class="c7">领域： </em>'+data[i].comp_territory+'</span> <br /> <span><em class="c7">阶段： </em>'+data[i].comp_state+'</span> <span><em class="c7">规模：'
			+'</em>'+data[i].comp_scale+'</span><ul class="companyTags reset"><li>股票期权</li><li>五险一金</li><li>带薪年假</li></ul></div></li>';
		}else{
			str+='<li class="odd clearfix"><div class="hot_pos_l"><div class="mb10"><a href="toudi.html" onclick="toudi('+data[i].job_id+')" title="'+data[i].job_name+'" target="_blank">'+data[i].job_name+'</a>&nbsp; <span class="c9">['+data[i].comp_city+']</span></div>'
			+'<span><em class="c7">月薪：</em>'+data[i].job_min_salary+'k-'+data[i].job_max_salary+'k</span> <span><em class="c7">经验：</em> 3-5年</span> <span><em class="c7">最低学历：'
			+data[i].job_education+'</em></span> <br /> <span><em class="c7">职位诱惑：</em>'+data[i].job_tempt+'</span><br /> <span>'+data[i].job_ftime+'发布</span>'
			+'</div><div class="hot_pos_r"><div class="apply"><a href="toudi.html" onclick="toudi('+data[i].job_id+')">投个简历</a></div><div class="mb10"><input hidden="" class="c_id" value="'+data[i].c_id+'"><a href="'+data[i].pro_link+'" title="'+data[i].comp_name+'" target="_blank">'+data[i].comp_name+'</a></div>'
			+'<span><em class="c7">领域： </em>'+data[i].comp_territory+'</span> <br /> <span><em class="c7">阶段： </em>'+data[i].comp_state+'</span> <span><em class="c7">规模：'
			+'</em>'+data[i].comp_scale+'</span><ul class="companyTags reset"><li>股票期权</li><li>五险一金</li><li>带薪年假</li></ul></div></li>';
		} //<span><em class="c7">创始人：</em> '+data[i].ct_name+'</span><span><em class="c7">创始人：</em> '+data[i].ct_name+'</span> 
	}
	$("#jobInfo").html(str);
}
function toudi(data){
	var c_id = $(".c_id").val();
	//alert("job_id"+data+"c_id"+c_id);
	$.post("job/sendCompany",{job_id:data,c_id:c_id},"json");
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
