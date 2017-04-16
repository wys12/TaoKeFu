loadInfo();
var str='';
function loadInfo(){
	comp_namesForm();
	comp_namesTag();
	comp_citysForm();
	product();//产品信息
	companyTeam();//团队
}
/**
 * 公司名称加载
 */
function comp_namesForm(){
	$.post("company/findCompany",function(data){
		//console.info(JSON.stringify(data));
		$("#comp_names").html(data[0].comp_name);
		$("#comp_fullnames").html(data[0].comp_fullname);
		$("#comp_name").val(data[0].comp_name);
		$("#comp_introduce").val(data[0].comp_introduce);
		$("#introduce").text(data[0].comp_introduce);
		//公司点击编辑后显示
		$("#comp_fullnames").html(data[0].comp_fullname);
		$("#comp_name").val(data[0].comp_name);
		$("#comp_introduce").val(data[0].comp_introduce);
		//上市状态
		$(".c5").html(data[0].comp_state);
		$("#select_fin").val(data[0].comp_state);
		//公司介绍
		$(".c_intro").html(data[0].comp_introduces);
		$("#companyProfile").html(data[0].comp_introduces);
	},"json");
}
/**
 * 公司地址加载
 */
function comp_citysForm(){
	$.post("company/findCompany",function(data){
		$("#c_tags_show table tbody tr:eq(0) td:eq(1)").text(data[0].comp_city);
		$("#c_tags_show table tbody tr:eq(1) td:eq(1)").text(data[0].comp_territory);
		$("#c_tags_show table tbody tr:eq(2) td:eq(1)").text(data[0].comp_scale);
		$("#c_tags_show table tbody tr:eq(3) td:eq(1)").html('<a rel="nofollow"  target="_blank" href="https://'+data[0].comp_link+'">'+data[0].comp_link+'</a>');
	},"json");
}
/**
 * 公司标签加载
 */
function comp_namesTag(){
	$.post("company/findCompany",function(data){
		str='';
		var tag=data[0].tag_name.split(",");
		if(tag!=null){
			for(var i=0;i<tag.length;i++){
				str+='<li><span>'+tag[i]+'</span></li>';
			}
		}
		$("#hasLabels").html(str+'<li class="link" onclick="edit()">编辑</li>');
	},"json");
}
/*function edit(){
	$("#addLabels").css('display','block');
	$("#tags").css('display','block');
	$(".link").css('display','none');
}*/
/**
 * 点击保存 修改标签
 */
function tagSave(){
	var length=$("#hasLabels li").length;
	var tag_name="";
	//alert("==="+$("#hasLabels li").text());
	for(var i=0;i<length;i++){
		//alert("i"+i+"length"+length+tag_name);
		tag_name+=$('#hasLabels li:eq('+i+')').text().substring(0, $('#hasLabels li:eq('+i+')').text().indexOf("x"))+(i!=(length-1)?",":"");
	}
	$.post("company/modifiCompany",{tag_name:tag_name},function(data){
		if(data=="1"){
			$("#addLabels").css('display','none');
			$("#tags").css('display','none');
			comp_namesTag();
		}
	},"json");
}
/**
 * 标签取消
 */
function tagCancel(){
	comp_namesTag();
}

/**
 * 点击编辑 地址加载
 */
function modifiTagForms(){
	$("#tagForms table tbody tr:eq(0) td:eq(1) input").val($("#c_tags_show table tbody tr:eq(0) td:eq(1)").text());
	$("#tagForms table tbody tr:eq(1) td:eq(1) input").val($("#c_tags_show table tbody tr:eq(1) td:eq(1)").text());
	$("#tagForms table tbody tr:eq(2) td:eq(1) input").val($("#c_tags_show table tbody tr:eq(2) td:eq(1)").text());
	$("#tagForms table tbody tr:eq(3) td:eq(1) input").val($("#c_tags_show table tbody tr:eq(3) td:eq(1)").text());
}
/**
 * 点击保存 地址修改
 */
$("#submitFeatures").click(function(){
	//alert($("#select_sca").val());
	$.ajax({
		cache:true,
		type:"POST",url:'company/modifiCompany',
		data:$('#tagForms').serialize(),
		async:false,
		success:function(data){
			$("#c_tags_show").css("display","block");
			$("#c_tags_edit").css("display","none");
			comp_citysForm();
		}
	});

});
/**
 * 公司名称点击保存
 */
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

/**
 * 公司产品加载
 */
function product(){
	$.post("company/findCoResume",function(data){
		console.info("findCompany=="+data);
		$("#product h3").html('<a target="_blank" href="http://'+data[0].pro_link+'">'+data[0].pro_name+'</a>');
		$("#pro_pdesc").text(data[0].pro_pdesc);
		$("#products input:eq(0)").val(data[0].pro_name);
		$("#products input:eq(1)").val(data[0].pro_link);
		$("#products textarea").text(data[0].pro_pdesc);
	},"json");
}
$("#deleteProduct").click(function(){
	alert("暂未开放");
	return;
});
/**
 * 产品保存
 */
$("#saveProduct").click(function(){
	$.ajax({
		cache:true,
		type:"POST",
		url:'company/modifiCoResume',
		data:$(".productForm").serialize(),
		async:false,
		error:function(){
			alert("NO");
		},
		success:function(data){
			//$("#products").css("display","none");
			//$("#product").css('display','block');
			location.href="myhome.html";
			//loadInfo();
			//product();
		}
	});
});
/**
 * 上市状态/A轮
 */
$("#saveComp_state").click(function(){
	$.ajax({
		cache:true,
		type:"POST",url:'company/modifiCompany',
		data:{comp_state:$("#select_fin").val()},
		async:false,
		error:function(){
			alert("NO");
		},
		success:function(data){
			alert("YES");
		}
	});
});
/**
 * 公司创始团队 保存
 */
$("#saveTeam").click(function(){
	$.ajax({
		cache:true,
		type:"POST",url:'company/modifiCompany_team',
		data:$('.memberForm').serialize(),
		async:false,
		error:function(){
			alert("NO");
		},
		success:function(data){
			alert("YES");
		}
	});
});
/**
 * 公司详情介绍 的保存
 */
$("#submitProfile").click(function(){
	$.ajax({
		cache:true,
		type:"POST",url:'company/modifiCompany',
		data:$('#companyDesForm').serialize(),
		async:false,
		error:function(){
			alert("修改失败！！！");
		},
		success:function(data){
			$("#comp_introducess").css("display","none");
			$("#comp_introduces").css("display","block");
			comp_namesForm();
		}
	});
});
/**
 * 公司团队的加载
 */
function companyTeam(){
	$.post("company/findCompany_team",function(data){
		console.info("findCompany_team==>"+JSON.stringify(data));
		$(".m_name").html(data[0].ct_name);
		$(".m_position").html(data[0].ct_job);
		$(".m_intro").html(data[0].ct_tdesc);
		$(".ct_names").val(data[0].ct_name);
		$(".ct_jobs").val(data[0].ct_job);
	},"json");
}

