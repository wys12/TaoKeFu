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
				alert(ids);
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
		$("#jid").val(item.job_id);
		$("#jname").val(item.job_name);
		$("#jdepartment").val(item.job_department);
		$("#jnature").val(item.job_nature);
		$("#jminsalary").val(item.job_min_salary);
		$("#jmaxsalary").val(item.job_max_salary);
		$("#jattract").val(item.job_attract);
		$("#jftime").val(item.job_ftime);
		$("#jrequest").val(item.job_request);
		//alert(item.job_id);return;	
	/*	$.ajax({
			url:'',
			success:function(data){
				if(data){
					$('#wu-dialog-2').dialog('close');	
				}
				else{
					//绑定值
					$('#wu-form-2').form('load', data)
				}
			}	
		});	*/
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
	function pagerFilter(data){            
		if (typeof data.length == 'number' && typeof data.splice == 'function'){// is array                
			data = {                   
				total: data.length,                   
				rows: data               
			}            
		}        
		var dg = $(this);         
		var opts = dg.datagrid('options');          
		var pager = dg.datagrid('getPager');          
		pager.pagination({                
			onSelectPage:function(pageNum, pageSize){                 
				opts.pageNumber = pageNum;                   
				opts.pageSize = pageSize;                
				pager.pagination('refresh',{pageNumber:pageNum,pageSize:pageSize});                  
				dg.datagrid('loadData',data);                
			}          
		});           
		if (!data.originalRows){               
			data.originalRows = (data.rows);       
		}         
		var start = (opts.pageNumber-1)*parseInt(opts.pageSize);          
		var end = start + parseInt(opts.pageSize);        
		data.rows = (data.originalRows.slice(start, end));         
		return data;       
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
			loadFilter:pagerFilter,		
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
				{ field:'job_name',title:'职位名称',width:100,sortable:true},
				{ field:'job_department',title:'所属部门',width:100},
				{ field:'job_nature',title:'职位性质',width:100},
				{ field:'job_min_salary',title:'最小薪资',width:100},
				{ field:'job_max_salary',title:'最大薪资',width:100},
				{ field:'job_attract',title:'职位诱惑',width:100},
				{ field:'job_ftime',title:'发布时间',width:100},
				{ field:'job_request',title:'职位要求',width:100}
			]]
		});
	}
	