/**
 * Name 添加记录
 */
function add(){
	$('#job-form-1').form('submit', {
		url:'job/add',
		success:function(data){
			if(data){
				//$.messager.alert('信息提示','提交成功！','info');
				$('#job-datagrid-2').datagrid('reload');
				$('#job-dialog-1').dialog('close');
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
	
	var value1 = $("#job_start_time").datebox("getValue"); 
	var value2 = $("#job_end_time").datebox("getValue");
	var value3 = $("#job_nature").combobox("getValue");
	var urlStr= "job/search?job_start_time="+value1+"&job_end_time="+value2+"&job_nature="+value3;
	//alert(urlStr);
	load(urlStr);
}

/**
 * Name 修改记录
 * 
 */

function edit(){
	$('#job-form-2').form('submit', {
		url:'job/edit',
		success:function(data){
			if(data){
				//$.messager.alert('信息提示','提交成功！','info');
				$('#job-datagrid-2').datagrid('reload');
				$('#job-dialog-2').dialog('close');
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
			var items = $('#job-datagrid-2').datagrid('getSelections');
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
							//$.messager.alert('信息提示','删除成功！','info');		
							$('#job-datagrid-2').datagrid('reload');
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
	$('#job-form-1').form('clear');
	$('#job-dialog-1').dialog({
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
				$('#job-dialog-1').dialog('close');                    
			}
		}]
	});
}

/**
 * Name 打开修改窗口
 */
function openEdit(){
	$('#job-form-2').form('clear');
	var item = $('#job-datagrid-2').datagrid('getSelected');
	$("#jid").val(item.job_id);
	$("#jname").val(item.job_name);
	$("#cid").val(item.c_id);
	$("#jtags").val(item.job_tags);
	$("#jdepartment").val(item.job_department);
	$("#jnature").val(item.job_nature);
	$("#jminsalary").val(item.job_min_salary);
	$("#jmaxsalary").val(item.job_max_salary);
	$("#jeducation").val(item.job_education);
	$("#jtempt").val(item.job_tempt);
	$("div[value="+item.job_ftime+"]").trigger('click');
	$("#jrests").val(item.job_rests);
	$("#jnumber").val(item.job_number);
	$("div[value="+item.job_state+"]").trigger('click');
	$("#jneed").val(item.job_need);
	$("#jresponsibility").val(item.job_responsibility);
	$('#job-dialog-2').dialog({
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
				$('#job-dialog-2').dialog('close');                    
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
load("job/list");
function load(urlStr){
	//alert(urlStr);
	$('#job-datagrid-2').datagrid({
		url:urlStr,
		rownumbers:true,
		singleSelect:false,
		pagination:true,
		multiSort:true,
		fitColumns:true,
		fit:true,
		pageList:[5,10,15,20,30],
		columns:[[
		          { checkbox:true},
		          { field:'job_id',title:'职位ID',width:60,align:'center'},
		          { field:'c_id',title:'公司编号',width:60,align:'center'},
		          { field:'job_tags',title:'职位标签',width:100,align:'center'},
		          { field:'job_name',title:'职位名称',width:80,align:'center'},
		          { field:'job_department',title:'所属部门',width:80,align:'center'},
		          { field:'job_nature',title:'职位性质',width:60,align:'center'},
		          { field:'job_min_salary',title:'最小薪资',width:60,align:'center'},
		          { field:'job_max_salary',title:'最大薪资',width:60,align:'center'},
		          { field:'job_education',title:'学历要求',width:60,align:'center'},
		          { field:'job_tempt',title:'职位诱惑',width:100,align:'center'},
		          { field:'job_ftime',title:'发布时间',width:100,align:'center'},
		          { field:'job_rests',title:'其他',width:100,align:'center'},
		          { field:'job_number',title:'点击量',width:50,align:'center'},
		          { field:'job_state',title:'职位状态',width:80,align:'center',
		        	  formatter: function(value,row,index){
			      			if(value == "-0"){
			      				return "在线职位"
			      			}else{
			      				return "离线职位"
			      			}
		        	  }  
		          },
		          { field:'job_need',title:'任职要求',width:100},
		          { field:'job_responsibility',title:'工作职责',width:100},
		          ]]
	});
}
