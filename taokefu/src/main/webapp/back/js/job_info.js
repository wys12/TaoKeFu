$('#jobInfo').datagrid({  
	url:'job/list',
	fitColumns:true,
	fit:true,
	singleSelect:true,
	border:false,
	pagination:true,
	pageList : [ 5, 10, 15, 20, 25, 30 ],
	columns:[[    
	          {field:'job_id',title:'编号',width:100,align:'center'},    
	          {field:'job_name',title:'名称',width:100,align:'center'},  
	          {field:'c_id',title:'所属公司',width:100,align:'center'},
	          {field:'job_department',title:'职位部门',width:100,align:'center'},
	          {field:'job_salary',title:'薪水',width:100,align:'center'},
	          {field:'job_nature',title:'职位性质',width:100,align:'center'}, 
	          {field:'job_ftime',title:'发布时间',width:100,align:'center'},
	          {field:'job_request',title:'职位要求',width:100,align:'center'},
	          {field : 'opr',title : '操作',width : 100,align : 'center',
	        	  formatter: function(value,row,index){
	        		  var oprStr = '<a class="detailBtn" href="javascript:void(0)" onclick="openDatail('+ index +')">详情</a>&nbsp;&nbsp;' + 
	        		  '<a class="modifyBtn" href="javascript:void(0)" onclick="openUpdate(' + index + ')">修改</a>' +
	        		  '<script>$(".detailBtn").linkbutton({iconCls: "icon-search"});' +
	        		  '$(".modifyBtn").linkbutton({iconCls: "icon-edit"});</script>'; 
	        		  return oprStr;
	        	  }
	          }]] 
});

$("#jobDetail").dialog("close");

$("#jobDetail").dialog({
	title:"职位预览",
	closed:true,
});


function  openDatail(index){
	$("#jobDetail").dialog("open");
	var row = $("#jobInfo").datagrid("getRows")[index];
	$("#job_name").val(row.job_name);
	$("#job_department").val(row.job_department);
	$("#job_ftime").val(row.job_ftime);
	$("#job_request").val(row.job_request);
}
$(".closeBtn").linkbutton({
	iconCls: "icon-cancel",
	onClick: function(){
		$("#modifyDiv").dialog("close");
	} 	
});


