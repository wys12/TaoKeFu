loadInfo();
function loadInfo(){
	show();
}
var str='';
function show(){
	$.post("resume/findResume",function(data){
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
				//alert(JSON.stringify(data1[0].job_name));
				$("#"+data1[0].job_id+"").text(" | "+data1[0].job_name);
				$("#"+data1[0].job_id+"").attr("href","toudi.html");
				/*$("#1001").text(data1[0].job_name);*/
			},"json");
		}
		//alert(data.length+"str====>>>>"+str);
		$("#showInfo").html(str);
	},"json");
	/*$(".contactInfo span:eq(1)").text("123");
	$(".contactInfo a").text("321");
	$(".contactInfo a").attr("href","http://www.baidu.com");
	$(".unread a").text("张三");
	$(".unread a").attr("href","preview.html?tkf_id=1002");*/
	//alert("简历信息2");
}
