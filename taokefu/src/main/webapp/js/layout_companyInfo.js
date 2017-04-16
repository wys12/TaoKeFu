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
	$('#company-form-1').form('submit', {
		url:'company/add',
		success:function(data){
			if(data){
				//$.messager.alert('信息提示','添加成功！','info');
				$('#company-dialog-1').dialog('close');
				$('#company-datagrid-2').datagrid('reload');
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
	$('#company-form-2').form('submit', {
		url:'company/edit',
		success:function(data){
			if(data){
				//$.messager.alert('信息提示','提交成功！','info');
				$('#company-dialog-2').dialog('close');
				$('#company-datagrid-2').datagrid('reload');
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
			var items = $('#company-datagrid-2').datagrid('getSelections');
			var ids = [];
			$(items).each(function(){
				ids.push(this.comp_id);	
			});
			if(ids.length>0){
				$.ajax({
					url:'company/deleteById',
					data:{"ids":ids.toString()},
					traditional: true,
					success:function(data){
						if(data){
							//$.messager.alert('信息提示','删除成功！','info');
							$('#company-datagrid-2').datagrid('reload');
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

function findCompanyBack(){
	var value_type = $("#find_comp").combobox("getValue");
	var value_key = document.getElementById("comp_search").value;
	if(value_key ==null || value_key == ""){
		value_key="-0";
	}	
	var urlStr= "company/search?find_comp="+value_type+"&comp_search="+value_key;
	//alert(urlStr);
	load(urlStr);
}


/**
 * Name 打开添加窗口
 */
function openAdd(){
	$('#company-form-1').form('clear');
	$('#company-dialog-1').dialog({
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
				$('#company-dialog-1').dialog('close');                    
			}
		}]
	});
}

/**
 * Name 打开修改窗口
 */
function openEdit(){
	$('#company-form-2').form('clear');
	var item = $('#company-datagrid-2').datagrid('getSelected');
	//alert(JSON.stringify(item));
	$("#cid-edit").val(item.comp_id);
	$("#cname-edit").val(item.comp_name);
	$("#cfullname-edit").val(item.comp_fullname);
	$("#clogo-edit").val("");
	if(item.comp_logo !=null && item.comp_logo !=""){  
		$("#pic-edit").attr("src", item.comp_logo);
	}else{
		$("#pic-edit").attr("src", item.comp_logo);
	}
	$("#cterritory-edit").val(item.comp_territory);
	$("#cstate-edit").val(item.comp_state);
	$("#cphone-edit").val(item.comp_phone);
	$("#cemail-edit").val(item.comp_email);
	$("#clink-edit").val(item.comp_link);
	$("#ccity-edit").val(item.comp_city);
	$("div[value="+item.comp_scale+"]").trigger('click');
	$("div[value="+item.comp_attestation+"]").trigger('click');
	$("#tname-edit").val(item.tag_name);
	$("#cintroduce-edit").val(item.comp_introduce);
	$("#cintroduces-edit").val(item.comp_introduces);
	$('#company-dialog-2').dialog({
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
				$('#company-dialog-2').dialog('close');                    
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
load("company/list");
function load(urlStr){
	$('#company-datagrid-2').datagrid({
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
	          { field:'comp_id',title:'公司ID',width:40,align : 'center',sortable:true},
	          { field:'comp_name',title:'公司简称',width:40,align : 'center',sortable:true},
	          { field:'comp_logo',title:'公司logo',align : 'center',
	        	  formatter: function(value,row,index){
	      			if(value == null){
	      				return "<img width='50' src='style/images/logo_default.png'/>"
	      			}else{
	      				return "<img width='50' src='" + value + "'/>"
	      			}
	        	  }
	          },
	          { field:'comp_phone',title:'联系方式',align : 'center',width:70},
	          { field:'comp_email',title:'公司邮箱',align : 'center',width:100},
	          { field:'comp_link',title:'公司链接',align : 'center',width:80,
	        	  formatter: function(value,row,index){
		      			if(value == null){
		      				return " "
		      			}else{
		      				return "<a href='"+'http://'+ value + "'>"+value+"</a>"
		      			}
	        	  }  
	          },
	          { field:'comp_city',title:'所在城市',align : 'center',width:40},
	          { field:'comp_introduce',title:'公司简介',align : 'center',width:80},
	          { field:'comp_attestation',title:'认证状态',align : 'center',width:40,
	        	  formatter: function(value,row,index){
		      			if(value == "-1"){
		      				return "已认证"
		      			}if(value == "" || value == null){
			      				return "未审核"
			      		}if(value == "-2"){
			      			return "审核未通过"
			      		}
	        	  }
	          },
	          { field:'opr',title:'操作',align : 'center',width:140,
	        	  formatter: function(value,row,index){
	      			var oprStr = '<a class="detailBtn" href="javascript:void(0)" onclick="openDatail(' + index + ')">公司详情</a>&nbsp;' + 
	      				'<a class="modifyBtn" href="javascript:void(0)" onclick="openUpdate(' + index + ')">管理团队</a>' +
	      				'<script>$(".detailBtn").linkbutton({iconCls: "icon-search"});' +
	      				'$(".modifyBtn").linkbutton({iconCls: "icon-user-group"});</script>'; 
	      			return oprStr;
	      		  }
	       	  }
	  ]]
});
}
