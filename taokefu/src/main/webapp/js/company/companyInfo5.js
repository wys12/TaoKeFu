loadInfo();
function loadInfo(){
	
}
function sunbimts(){
	var companyProfile = $("#companyProfile").val();
	alert(companyProfile);
	$.post("company/modifiCompany",{comp_introduces:companyProfile},function(data){
		if(data=="1"){
			location.href="myhome.html";
		}
	},"json");
}

