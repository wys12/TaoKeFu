loadInfo();
function loadInfo(){
	
}
$("#step2Submit").click(function(){
	var length=$("#labels li").length;
	var tag_name="";
	for(var i=0;i<length;i++){
		alert("i"+i+"length"+length);
		tag_name+=$('#labels li:eq('+i+')').text()+(i!=(length-1)?",":"");
	}
	alert(tag_name);
	$.post("company/modifiCompany",{tag_name:tag_name},function(data){
		if(data=="1"){
			location.href="companyInfo03.html";
		}
		
	},"json");
});
