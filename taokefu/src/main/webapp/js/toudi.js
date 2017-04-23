/*loadInfo(number);*/
var str="";
var str1="";
var str2="";
function loadInfo(number){
	$.post("job/findCompany",function(data0){
		if(number!=null && number!=""){
			shouInfo(data0)
		}else{
			location.href = "login.html";
		}
	},"json");
}

function shouInfo(data){
	str="";
	str1="";
	str2="";
	console.info(JSON.stringify(data));
	for(var i=0;i<data.length;i++){
		str='<dl class="job_detail"><dt><h1 title="'+data[i].job_name+'"><em></em><div>'+data[i].comp_name+'招聘 </div>'+data[i].job_name+'</h1><div class="jd_collection" id="jobCollection"><div class="jd_collection_success"> <span>已成功收藏该职位，</span> <a class="jd_collection_page" href="collections.html">查看全部</a> <a class="jd_collection_x" href="javascript:;"></a></div></div></dt>'
		+'<dd class="job_request"><span class="red">'+data[i].job_min_salary+'-'+data[i].job_max_salary+'</span> <span>'+data[i].comp_city+'市</span> <span>经验1-3年</span> <span>'+data[i].job_education+'</span> <span>'+data[i].job_nature+'</span><br> 职位诱惑 :上市公司，快速发展空间，产品的话语权<div>发布时间：'+data[i].job_ftime+'</div></dd>'
		+'<dd class="job_bt"><h3 class="description">职位描述</h3><p><strong>工作职责：</strong>&nbsp;<br>1、'+data[i].job_responsibility+'&nbsp;<br>&nbsp;<br> <strong>任职要求：</strong> <br>1、'+data[i].job_need+'&nbsp;</p><p>&nbsp;</p><p><strong>其他：&nbsp;</strong></p><p>1、五险一金、商业综合医疗保险，节日慰问金、生日礼金、结婚礼金、年度体检、旅游；</p></dd>'
		+'<dd class="resume resume_web"><div><span> 你已有可投递的在线简历：<a title="jason的简历" target="_blank" href="jianli.html"><strong>jason的简历</strong></a></span><br> <span></span></div><span class="setBtns"> <a target="_blank" title="预览" href="preview.html">预览</a> | <a title="修改" target="_blank" href="jianli.html">修改</a></span></dd>'
		+'<div class="saoma saoma_btm"><div class="dropdown_menu"><div class="drop_l"><img width="131" height="131" src="style/images/b533f6e729e74b418fcd6862bbde95dc_318969.jpg"><span>[仅限本人使用]</span></div><div class="drop_r"><div class="drop_title"></div><p>想知道HR在看简历嘛？<br> 想在微信中收到面试通知？<br> <span>&lt;&lt;扫一扫，给你解决</span></p></div></div></div>'
		+'<dd><a id="toudi" onclick="toudi()" title="投个简历" class="btn"  href="javascript:void(0);">投个简历</a></dd></dl><div id="weibolist"></div>';
		/*str1=''
			+''
			+'';*/
	}
	$(".content_l").html(str);
	//$(".content_r").html(str1);
}
$(".btn_s").click(function(){
	alert();
	$.post("");
});
function toudi(){
	$.ajax({
		cache:true,
		type:"POST",
		url:'resume/insertResume',
		data:"",
		async:false,
		error:function(){
			alert("简历投递失败！！！");
		},
		success:function(data){
			if(data=="2"){
				alert("该公司已有你的简历，请勿重复投递...");
			}else{
				alert("简历投递成功...");
				location.href="jianli.html";
			}
			
		}
	});
}
/*$("#toudi").click(function(){
	
});*/