function loadInfo(number){
	if(number!=null && number!=""){
		shouInfo(number);
	}else{
		alert("请先登录");
		location.href = "login.html";
	}
}
function shouInfo(number){
	alert(JSON.stringify(number));
	$.post("",function(){
		
	},"json");
}