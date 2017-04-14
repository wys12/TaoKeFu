loadInfo();
function loadInfo(){
	
}

function find(){
	$.post("company/findCompany",function(data){
		alert("findCompany=="+data);
	},"json");
	$.post("company/findCoResume",function(data){
		alert("findCompany=="+data);
	},"json");
	$.post("company/findCompany_team",function(data){
		alert("findCompany=="+data);
	},"json");
	
	
	$.post("company/modifiCompany",function(data){
		alert("findCompany=="+data);
	},"json");
	$.post("company/modifiCoResume",function(data){
		alert("findCompany=="+data);
	},"json");
	$.post("company/modifiCompany_team",function(data){
		alert("findCompany=="+data);
	},"json");
}
function modifi(){
	
}
