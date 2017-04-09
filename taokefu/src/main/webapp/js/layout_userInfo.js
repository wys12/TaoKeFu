/**
 * Name 添加记录
 */
function add(){
	$('#wu-form-1').form('submit', {
		url:'tkfuser/add',
		success:function(data){
			alert(data);
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
function chgPic(obj){
	$("#pic").attr("src", window.URL.createObjectURL(obj.files[0]));
}

/**
 * Name 修改记录
 */
function edit(){
	$('#wu-form-2').form('submit', {
		url:'tkfuser/edit',
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
	$("#uid").val(item.us_id);
	$("#uname").val(item.us_name);
	$("#upicpath").val("");
	if(row.picPath){
		$("#pic").attr("src", row.picPath);
	}else{
		$("#pic").attr("src", "style/images/default_headpic.png");
	}
	$("#uex").val(item.us_sex);
	$("#ueducationa").val(item.us_educationa);
	$("#uwork_year").val(item.us_work_year);
	$("#uphone").val(item.us_phone);
	$("#uemail").val(item.us_email);
	$("#uintro").val(item.us_intro);
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
 * Name 分页过滤器
 */


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
	//loadFilter:pagerFilter,		
	rownumbers:true,
	singleSelect:false,
	//pageSize:20,           
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
