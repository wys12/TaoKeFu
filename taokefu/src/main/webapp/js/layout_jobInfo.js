/**
 * Name 添加记录
 */
function add(){
	$('#wu-form-1').form('submit', {
		url:'job/add',
		success:function(data){
			if(data){
				$.messager.alert('信息提示','提交成功！','info');
				$('#wu-dialog-1').dialog('close');
			}
			else
			{
				$.messager.alert('信息提示','提交失败！','info');
			}
		}
	});
}
/**
 * 查询
 */

function find(){
	$('#wu-form-3').form({    
		url:'job/search', 
		onSubmit: function(){    
			var job_start_time = $("#job_start_time").datebox("getValue"); 
			var joob_end_time = $("#job_end_time").datebox("getValue");
			var job_nature=$("#jnature").combobox("getValue");
			alert(job_nature);
			param={job_start_time:job_start_time,joob_end_time:joob_end_time,job_nature:job_nature};
			//alert(JSON.stringify(param));
			return;
		},    
		success:function(data){
			var ships = eval('(' + data + ')');//转换接收json字符串为json对象
			//console.info(JSON.stringify(ships));
			for(var i=0 ; i<ships.length ;i++ ){
				alert(i+"--"+ships[i].job_tags);
			}			
		/*	$('#wu-datagrid-2').datagrid({
				rownumbers:true,
				singleSelect:false,
				pagination:true,
				multiSort:true,
				fitColumns:true,
				fit:true,
				pageList:[5,10,15,20,30],
				columns:[[
				          { checkbox:true},
				          { field:'job_id',title:'职位ID',width:100,sortable:true},
				          { field:'c_id',title:'公司编号',width:100,sortable:true},
				          { field:'job_tags',title:'职位标签',width:100,sortable:true},
				          { field:'job_name',title:'职位名称',width:100,sortable:true},
				          { field:'job_department',title:'所属部门',width:100},
				          { field:'job_nature',title:'职位性质',width:100},
				          { field:'job_min_salary',title:'最小薪资',width:100},
				          { field:'job_max_salary',title:'最大薪资',width:100},
				          { field:'job_ftime',title:'发布时间',width:100},
				          { field:'job_need',title:'职位要求',width:100}
				          ]]
			});*/
			 
		}    
	});    
	$('#wu-form-3').submit();  

}

/**
 * Name 修改记录
 * 
 */

function edit(){
	$('#wu-form-2').form('submit', {
		url:'job/edit',
		success:function(data){
			if(data){
				$.messager.alert('信息提示','提交成功！','info');
				$('#wu-dialog-2').dialog('close');
			}
			else
			{
				$.messager.alert('信息提示','提交失败！','info');
			}
		}
	});
}

/**
 * Name 删除记录
 */
function remove(){
	$.messager.confirm('信息提示','确定要删除该记录？', function(result){
		if(result){
			var items = $('#wu-datagrid-2').datagrid('getSelections');
			var ids = [];
			$(items).each(function(){
				ids.push(this.job_id);	
			});
			//alert(ids);
			if(ids.length>0){
				$.ajax({
					url:'job/deleteById',
					data:{"ids":ids.toString()},
					traditional: true,
					success:function(data){
						if(data){
							$.messager.alert('信息提示','删除成功！','info');		
						}
						else
						{
							$.messager.alert('信息提示','删除失败！','info');		
						}
					}	
				});
			}
		}	
	});
}

/**
 * Name 打开添加窗口
 */
function openAdd(){
	$('#wu-form-1').form('clear');
	$('#wu-dialog-1').dialog({
		closed: false,
		modal:true,
		title: "添加信息",
		buttons: [{
			text: '确定',
			iconCls: 'icon-ok',
			handler: add
		}, {
			text: '取消',
			iconCls: 'icon-cancel',
			handler: function () {
				$('#wu-dialog-1').dialog('close');                    
			}
		}]
	});
}

/**
 * Name 打开修改窗口
 */
function openEdit(){
	$('#wu-form-2').form('clear');
	var item = $('#wu-datagrid-2').datagrid('getSelected');
	$("#jid").val(item.job_id);
	$("#jattract").val(item.job_tags);
	$("#jname").val(item.job_name);
	$("#jdepartment").val(item.job_department);
	$("#jnature1").val(item.job_nature);
	$("#jminsalary").val(item.job_min_salary);
	$("#jmaxsalary").val(item.job_max_salary);
	$("#jftime").val(item.job_ftime);
	$("#jneed").val(item.job_need);
	$('#wu-dialog-2').dialog({
		closed: false,
		modal:true,
		title: "修改信息",
		buttons: [{
			text: '确定',
			iconCls: 'icon-ok',
			handler: edit
		}, {
			text: '取消',
			iconCls: 'icon-cancel',
			handler: function () {
				$('#wu-dialog-2').dialog('close');                    
			}
		}]
	});
}	

/**
 * reload()刷新数据
 * 
 */
function reload(){
	load();
}
/**
 * Name 载入数据
 */
load();
function load(){
	$('#wu-datagrid-2').datagrid({
		url:"job/list",
		rownumbers:true,
		singleSelect:false,
		pagination:true,
		multiSort:true,
		fitColumns:true,
		fit:true,
		pageList:[5,10,15,20,30],
		columns:[[
		          { checkbox:true},
		          { field:'job_id',title:'职位ID',width:100,sortable:true},
		          { field:'c_id',title:'公司编号',width:100,sortable:true},
		          { field:'job_tags',title:'职位标签',width:100,sortable:true},
		          { field:'job_name',title:'职位名称',width:100,sortable:true},
		          { field:'job_department',title:'所属部门',width:100},
		          { field:'job_nature',title:'职位性质',width:100},
		          { field:'job_min_salary',title:'最小薪资',width:100},
		          { field:'job_max_salary',title:'最大薪资',width:100},
		          { field:'job_ftime',title:'发布时间',width:100},
		          { field:'job_need',title:'职位要求',width:100}
		          ]]
	});
}
