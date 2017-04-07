loadInfo();
var str="";
function loadInfo(){
	$.post("job/findCompany",function(data){
		alert(JSON.stringify(data));
		shouInfo(data);
	},"json");
}
function shouInfo(data){
	
}
