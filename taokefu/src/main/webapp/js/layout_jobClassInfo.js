/**
 * Name 添加记录
 */
function add(){
	$('#jobClass-form-1').form('submit', {
		url:'job/jcAdd',
		success:function(data){
			if(data){
				//$.messager.alert('信息提示','提交成功！','info');
				$('#jobClass-dialog-1').dialog('close');
				$('#jobClass-datagrid-2').datagrid('reload');
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
	var value_key = $("#jobClass_nature").combobox("getValue");
	if(value_key ==null || value_key == ""){
		value_key="-0";
	}	
	var urlStr= "job/jcSearch?jc_type="+value_key;
	load(urlStr);
}

/**
 * Name 修改记录
 * 
 */

function edit(){
	$('#jobClass-form-2').form('submit', {
		url:'job/jcEdit',
		success:function(data){
			if(data){
				//$.messager.alert('信息提示','提交成功！','info');
				$('#jobClass-dialog-2').dialog('close');
				$('#jobClass-datagrid-2').datagrid('reload');
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
			var items = $('#jobClass-datagrid-2').datagrid('getSelections');
			var ids = [];
			$(items).each(function(){
				ids.push(this.jc_id);	
			});
			//alert(ids);
			if(ids.length>0){
				$.ajax({
					url:'job/deleteJcById',
					data:{"ids":ids.toString()},
					traditional: true,
					success:function(data){
						if(data){
							//$.messager.alert('信息提示','删除成功！','info');
							$('#jobClass-datagrid-2').datagrid('reload');
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
	$('#jobClass-form-1').form('clear');
	$('#jobClass-dialog-1').dialog({
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
				$('#jobClass-dialog-1').dialog('close');                    
			}
		}]
	});
}

/**
 * Name 打开修改窗口
 */
function openEdit(){
	$('#jobClass-form-2').form('clear');
	var item = $('#jobClass-datagrid-2').datagrid('getSelected');
	$("#jid-edit").val(item.jc_id);
	$("#jname-edit").val(item.jc_name);
	$("div[value="+item.jc_type+"]").trigger('click');
	$('#jobClass-dialog-2').dialog({
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
				$('#jobClass-dialog-2').dialog('close');                    
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
load("job/jcList");
function load(urlStr){
	//alert(urlStr);
	$('#jobClass-datagrid-2').datagrid({
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
		          { field:'jc_id',title:'类型ID',align:'center',width:50},
		          { field:'jc_name',title:'类型名称',align:'center',width:100},
		          { field:'jc_type',title:'职位类型',align:'center',width:100},
		          ]]
	});
}
