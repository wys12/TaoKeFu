logins();
function logins(){
	//alert("自动同步登陆信息");
	$.post("users/logins",function(data){
		//alert("logins "+data.l_email+";");
		if(data==null || data==""){
			$(".collapsible_menu").hide();
		}else{
			$(".loginTop").hide();
			$(".collapsible_menu").show();
			$("#usname").text(data.l_email);
		}
	});
}
$(".logout").click(function(){
	$.post("users/outlogins");
	});
