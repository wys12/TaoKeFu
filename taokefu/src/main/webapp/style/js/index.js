logins();
function logins(){
	//alert("自动同步登陆信息");
	$.post("user/logins",function(data){
		//alert("logins "+data+";");
		if(data==null || data==""){
			$(".collapsible_menu").hide();
		}else{
			$(".loginTop").hide();
			$(".collapsible_menu").show();
			$("#usname").text(data.us_name);
		}
	});
}
$(".logout").click(function(){
	$.post("user/outlogins");
	});
