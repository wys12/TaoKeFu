function loadInfo(number){
	alert(JSON.stringify(number));
	if(number!=null && number!=""){
		shouInfo();
	}else{
		alert("请先登录");
		location.href = "login.html";
	}
}
function shouInfo(number){
	
}