$('#userInfo').datagrid({    
    url:'tkfuser/list', 
    border:false,
    fitColumns:true,
    fit:true,
    singleSelect:true,
    columns:[[    
        {field:'us_id',title:'用户编号',width:100},    
        {field:'us_name',title:'用户姓名',width:100},  
        {field:'us_pwd',title:'用户密码',width:100}, 
        {field:'us_picpath',title:'图片',width:100}, 
        {field:'us_sex',title:'用户性别',width:100}, 
        {field:'us_phone',title:'用户电话',width:100}, 
        {field:'us_email',title:'用户邮箱',width:100},       
    ]]
});