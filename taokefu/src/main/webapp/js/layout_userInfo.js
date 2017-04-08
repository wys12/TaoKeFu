/**
 * Name 添加记录
 */
function add(){
	$('#wu-form-2').form('submit', {
		url:'',
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
 * Name 修改记录
 */
function edit(){
	$('#wu-form-2').form('submit', {
		url:'',
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
				ids.push(this.productid);	
			});
			//alert(ids);return;
			$.ajax({
				url:'',
				data:'',
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
	});
}

/**
 * Name 打开添加窗口
 */
function openAdd(){
	$('#wu-form-2').form('clear');
	$('#wu-dialog-2').dialog({
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
				$('#wu-dialog-2').dialog('close');                    
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
	//alert(item.productid);return;
	$.ajax({
		url:'',
		data:'',
		success:function(data){
			if(data){
				$('#wu-dialog-2').dialog('close');	
			}
			else{
				//绑定值
				$('#wu-form-2').form('load', data)
			}
		}	
	});
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
function load(){$('#wu-datagrid-2').datagrid({
	url:"tkfuser/list",
	rownumbers:true,
	singleSelect:false,
	pagination:true,
	multiSort:true,
	fitColumns:true,
	fit:true,
	pageList:[5,10,15,20,30],
	columns:[[
	          { checkbox:true},
	          { field:'us_id',title:'用户ID',width:30,sortable:true},
	          { field:'us_name',title:'用户姓名',width:100,sortable:true},
	          { field:'us_picpath',title:'用户图片',width:100},
	          { field:'us_sex',title:'sex',width:50},
	          { field:'us_intro',title:'用户简介',width:100},
	          { field:'us_educationa',title:'用户学历',width:30},
	          { field:'us_work_year',title:'用户工龄',width:30},
	          { field:'us_phone',title:'用户电话',width:100},
	          { field:'us_email',title:'用户邮箱',width:100}
	          ]]
});
}
