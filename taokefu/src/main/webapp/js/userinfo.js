logins();
function logins(){
	//alert("自动同步登陆信息");
	$.post("users/logins",function(data){
		//alert("logins "+data.l_email+";");
		if(data==null || data==""){
			$(".collapsible_menu").hide();
			loadUrl(data);
		}else{
			$(".loginTop").hide();
			//alert("132 "+data.l_type);
			if(data.l_type=="0" || data.l_type==undefined){
				//alert(JSON.stringify(data));
				//$(".collapsible_menu").html('<dt><span id="usname"></span> <span class="red dn" id="noticeDot-0"></span><i></i></dt><dd><a rel="nofollow" href="jianli.html">我的简历</a></dd><dd><a href="collections.html">我收藏的职位</a></dd><dd><a href="delivery.html">我投递的职位 <span id="noticeNo" class="red dn">(0)</span></a></dd><dd><a href="subscribe.html">我的订阅</a></dd><dd><a href="accountBind.html">帐号设置</a></dd><dd><a rel="nofollow" onclick="outlogins()">退出</a></dd>');
				$(".collapsible_menu").html('<dt><span id="usname"></span> <span class="red dn" id="noticeDot-0"></span><i></i></dt><dd><a rel="nofollow" href="jianli.html">我的简历</a></dd><dd><a href="delivery.html">我投递的职位 <span id="noticeNo" class="red dn">(0)</span></a></dd><dd><a href="updatePwd.html">帐号设置</a></dd><dd><a rel="nofollow" onclick="outlogins()">退出</a></dd>');
				$(".collapsible_menu").show();
			}else if(data.l_type=="1"){
				//alert(data.l_type);<input hidden="" name="">
				/*$(".collapsible_menu").html('<dt><span id="usname"></span> <span class="red dn" id="noticeDot-1"></span><i></i></dt><dd><a href="positions.html">我发布的职位</a></dd><dd><a href="positions.html">我收到的简历</a></dd><dd class="btm"><a href="myhome.html">我的公司主页</a></dd><dd><a href="jianli.html">我要找工作</a></dd><dd><a href="accountBind.html">帐号设置</a></dd><dd><a rel="nofollow" href="login.html onclick="outlogins()"">退出</a></dd>');*/
				$(".collapsible_menu").html('<dt><span id="usname"></span> <span class="red dn" id="noticeDot-1"></span><i></i></dt><dd><a href="myhome.html">我的公司主页</a></dd><dd><a href="positions.html">我发布的职位</a></dd><dd><a href="canInterviewResumes.html">我收到的简历</a></dd><dd><a href="updatePwd.html">帐号设置</a></dd><dd><a rel="nofollow" onclick="outlogins()">退出</a></dd>');
				$(".collapsible_menu").show();
			}/*'+data.l_email!=null?data.l_email:data.nickname+'*/
			if(data.l_email==null){
				$("#usname").text(data.nickname);
			}else{
				$("#usname").text(data.l_email);
			}
			loadUrl(data);
		}
	});
}

function loadUrl(number){
	var url = (window.location.pathname);
	if(url=="/taokefu/toudi.html" || url=="/taokefu/preview.html" || url=="/taokefu/jianli.html"
		||url=="/taokefu/delivery.html" || url=="/taokefu/updatePwd.html"){
		loadInfo(number);
	}
	if(url=="/taokefu/myhome.html"){
		loadInfo(number);
	}

}

function outlogins(){
	location.href="login.html";
	$.post("users/outlogins",function(data){
		$(".collapsible_menu").hide();
		$(".loginTop").show();
	});
	QC.Login.signOut();
}

/*$(".logout").click(function(){
	alert("退出1");
	$.post("users/outlogins",function(data){
		//alert("outlogins");
		$(".collapsible_menu").hide();
		$(".loginTop").show();
	});
	QC.Login.signOut();
});*/
