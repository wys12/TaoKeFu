function loadInfo(number){
	if(number!=null && number!=""){
		shouInfo(number);
	}else{
		alert("请先登录");
		location.href = "login.html";
	}
}
function shouInfo(number){
	alert(JSON.stringify(number.l_id));
	var params={us_id:number.l_id};
	$.post("tkfuser/findUser",params,function(data){
		alert(JSON.stringify(data));
	},"json");
}