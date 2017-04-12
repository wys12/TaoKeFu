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
			$(".collapsible_menu").show();
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
	//alert(url);
	if(url=="/taokefu/toudi.html" || url=="/taokefu/preview.html" || url=="/taokefu/jianli.html"){
		loadInfo(number);
	}
}



$(".logout").click(function(){
	QC.Login.signOut();
	$.post("users/outlogins",function(data){
		//alert("outlogins");
		$(".collapsible_menu").hide();
		$(".loginTop").show();
	});
});
