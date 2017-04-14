loadInfo();
function loadInfo(){
	
}
function chgPic(obj){
	$("#pic").attr("src", window.URL.createObjectURL(obj.files[0]));
}
function addCompany(){
	$.post("company/modifiCompany",function(data){
		if(data=="1"){
			location.href="companyInfo02.html";
		}
	},"json");
}