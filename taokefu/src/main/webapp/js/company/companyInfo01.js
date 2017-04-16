loadInfo();
function loadInfo(){
	
}
function chgPic(obj){
	$("#pic").attr("src", window.URL.createObjectURL(obj.files[0]));
}
function addCompany(){
	$.ajax({
		cache: true,
		type: "POST",
		url:'company/modifiCompany',
		data:$('#companyForm01').serialize(),// 你的formid
		async: false,
	    error: function(request) {
	        alert("NO");
	    },
	    success: function(data) {
		 //  alert("YES");
		   location.href="companyInfo02.html";
	    }
	});

	/*$('#companyForm01').submit();
	alert("111");
	$.post("company/modifiCompany",d,function(data){
		if(data=="1"){
			location.href="companyInfo02.html";
		}
	},"json");*/
}
