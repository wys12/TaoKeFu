loadInfo();
function loadInfo(){
	
}
$("#step2Submit").click(function(){
	var length=$("#labels li").length;
	var tag_name="";
	alert(length);
	for(var i=0;i<length;i++){
		tag_name+=$('#labels li:eq('+i+')').text()+",";
	}
	alert(tag_name);
	$.post("company/insertTag",{tag_name:tag_name},function(data){
		if(data=="1"){
			location.href="companyInfo03.html";
		}
		
	},"json");
});
