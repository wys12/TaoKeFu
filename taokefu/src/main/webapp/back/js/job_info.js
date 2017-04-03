$('#jobInfo').datagrid({  
	/*url:'job/list',*/
    fitColumns:true,
    fit:true,
    singleSelect:true,
    border:false,
    pagination:true,
    columns:[[    
        {field:'job_id',title:'编号',width:100,align:'center'},    
        {field:'job_name',title:'名称',width:100,align:'center'},    
        {field:'job_department',title:'职位部门',width:100,align:'center'},
        {field:'job_nature',title:'职位性质',width:100,align:'center'}, 
        {field:'ncreatedate',title:'发布',width:100,align:'center'},
        {field:'job_ftime',title:'发布时间',width:100,align:'center'},
        {field:'job_request',title:'职位要求',width:100,align:'center'},
        
    ]] 
});





$("#jobDetail").dialog({
	title:"职位预览",
	left:10,
	closed:true,
});

function showDetail(id){
	$("#jobDetail").dialog("open");
	$.post("news/get?nid="+id,function(data){
		$("#intid").val(data.topic.tname);
		$("#intitle").val(data.ntitle);
		$("#inauthor").val(data.nauthor);
		$("#insummary").val(data.nsummary);
		$("#incontent").html(data.ncontent);
		$("#ipic").attr("src",(data.npicPath == "" || data.npicPath == null) ? "images/not_pic.jpg" : data.npicPath);
		
	},"json");
}


