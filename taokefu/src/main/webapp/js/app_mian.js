$(function() {
	 


//查看密码
$(".eyes_box").click(function(){
	if($(this).attr("data-show")==1){//明文
		$(this).attr("data-show","2");
		$(this).children("i").html("&#xe627;");
		$(this).parent("li").children(".mima_dd").hide();
		$(this).parent("li").children(".mima_wz").show();
		$(this).parent("li").children(".mima_wz").val($(this).parent("li").children(".mima_dd").val()); 
		return;
		}
	if($(this).attr("data-show")==2){//密文
		$(this).attr("data-show","1");
		$(this).children("i").html("&#xe624;");
		$(this).parent("li").children(".mima_dd").show();
		$(this).parent("li").children(".mima_wz").hide();
		$(this).parent("li").children(".mima_dd").val($(this).parent("li").children(".mima_wz").val()); 
		return;
		} 
	});
	
 

 
});	