function chgPic_edit(obj){
	$("#pic-edit").attr("src", window.URL.createObjectURL(obj.files[0]));
}

function chgPic(obj){
	$("#pic").attr("src", window.URL.createObjectURL(obj.files[0]));
}

/**
 * Name 添加记录
 */
function add(){
	$('#user-form-1').form('submit', {
		url:'tkfuser/add',
		success:function(data){
			if(data){
				//$.messager.alert('信息提示','添加成功！','info');
				$('#user-dialog-1').dialog('close');
				$('#user-datagrid-2').datagrid('reload');
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
	$('#user-form-2').form('submit', {
		url:'tkfuser/edit',
		success:function(data){
			if(data){
				//$.messager.alert('信息提示','提交成功！','info');
				$('#user-dialog-2').dialog('close');
				$('#user-datagrid-2').datagrid('reload');
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
			var items = $('#user-datagrid-2').datagrid('getSelections');
			var ids = [];
			$(items).each(function(){
				ids.push(this.us_id);	
			});
			if(ids.length>0){
				$.ajax({
					url:'tkfuser/deleteById',
					data:{"ids":ids.toString()},
					traditional: true,
					success:function(data){
						if(data){
							//$.messager.alert('信息提示','删除成功！','info');
							$('#user-datagrid-2').datagrid('reload');
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
 * 查询
 */

function findUserBack(){
	var value_user = $("#user_nature").combobox("getValue");
	var value_type = $("#find_type").combobox("getValue");
	var value_key = document.getElementById("key_search").value;
	if(value_key ==null || value_key == ""){
		value_key="-0";
	}	
	var urlStr= "tkfuser/search?user_nature="+value_user+"&find_type="+value_type+"&key_search="+value_key;
	//alert(urlStr);
	load(urlStr);
}


/**
 * Name 打开添加窗口
 */
function openAdd(){
	$('#user-form-1').form('clear');
	$('#user-dialog-1').dialog({
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
				$('#user-dialog-1').dialog('close');                    
			}
		}]
	});
}

/**
 * Name 打开修改窗口
 */
function openEdit(){
	$('#user-form-2').form('clear');
	var item = $('#user-datagrid-2').datagrid('getSelected');
	//alert(JSON.stringify(item));
	$("#uid-edit").val(item.us_id);
	$("#uname-edit").val(item.us_name);
	$("#upicpath-edit").val("");
	if(item.us_picpath !=null && item.us_picpath !=""){  
		$("#pic-edit").attr("src", item.us_picpath);
	}else{
		$("#pic-edit").attr("src", item.us_picpath);
	}
	$("div[value="+item.us_sex+"]").trigger('click');
	$("div[value="+item.us_educationa+"]").trigger('click');
	$("div[value="+item.us_work_year+"]").trigger('click');
	$("#uphone-edit").val(item.us_phone);
	$("#uemail-edit").val(item.us_email);
	$("#uintro-edit").val(item.us_intro);
	$('#user-dialog-2').dialog({
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
				$('#user-dialog-2').dialog('close');                    
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
load("tkfuser/list");
function load(urlStr){
	$('#user-datagrid-2').datagrid({
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
	          { field:'us_id',title:'用户ID',width:30,align : 'center',sortable:true},
	          { field:'us_name',title:'用户姓名',width:60,align : 'center',sortable:true},
	          { field:'us_picpath',title:'用户头像',align : 'center',
	        	  formatter: function(value,row,index){
	      			if(value == null){
	      				return "<img width='60' src='style/images/default_headpic.png'/>"
	      			}else{
	      				return "<img width='60' src='" + value + "'/>"
	      			}
	        	  }
	          },
	          { field:'us_sex',title:'性别',align : 'center',width:30},
	          { field:'us_intro',title:'用户简介',align : 'center',width:100},
	          { field:'us_educationa',title:'学历',align : 'center',width:50},
	          { field:'us_work_year',title:'工作年限',align : 'center',width:50},
	          { field:'us_phone',title:'联系方式',align : 'center',width:100},
	          { field:'us_email',title:'电子邮箱',align : 'center',width:120},
	          { field:'openId',title:'第三方id',align : 'center',width:150}
	          ]]
});
}
