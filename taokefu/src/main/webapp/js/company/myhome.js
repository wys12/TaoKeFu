loadInfo();
function loadInfo(){
	editDetailForm();
}
/**
 * 公司名称
 */
function editDetailForm(){
	$.post("company/findCompany",function(data){
		console.info(JSON.stringify(data));
		$("#comp_names").html(data[0].comp_name);
		$("#comp_fullnames").html(data[0].comp_fullname);
		$("#comp_name").val(data[0].comp_name);
		$("#comp_introduce").val(data[0].comp_introduce);
	},"json");
}
/**
 * 公司名称
 */
function editDetailForm(){
	$.post("company/findCompany",function(data){
		console.info(JSON.stringify(data));
		$("#comp_names").html(data[0].comp_name);
		$("#comp_fullnames").html(data[0].comp_fullname);
		$("#comp_name").val(data[0].comp_name);
		$("#comp_introduce").val(data[0].comp_introduce);
	},"json");
}
$("#saveDetail").click(function(){
	$.ajax({
		cache: true,
		type:"POST",
		url:'company/modifiCompany',
		data:$('#editDetailForm').serialize(),
		async: false,
		success:function(data){
			$('#editDetailForm').css('display','none');
			$("#editCompanyDetail").css('display','block');
			editDetailForm();
		}
	});
});


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
}

function modifiy(){
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
