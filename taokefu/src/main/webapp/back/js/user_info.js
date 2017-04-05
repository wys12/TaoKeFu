$('#userInfo').datagrid({    
    url:'tkfuser/list', 
    border:false,
    fitColumns:true,
    fit:true,
    singleSelect:true,
    pagination : true,
    pageList : [ 5, 10, 15, 20, 25, 30 ],
    columns:[[    
        {field:'us_id',title:'用户编号',width:100},    
        {field:'us_name',title:'用户姓名',width:100},  
        {field:'us_sex',title:'用户性别',width:100}, 
        {field:'us_phone',title:'用户电话',width:100}, 
        {field:'us_email',title:'用户邮箱',width:100},   
        {field:'operator',title:'操作',width:100,align:'center',
        	formatter: function(value,row,index){
				//alert(row + "==>" + JSON.stringify(row));
        		return '<a class="detailBtn" "javascript:void(0)" onclick="openDatail('+ index +')">详情</a>' + 
        		'<script>$(".detailBtn").linkbutton({iconCls: "icon-search"});</script>';
			}
        }
    ]]
});


function  showInfo(index){
	$("#modifyDiv").dialog("open");
	var row = $("#userInfo").datagrid("getRows")[index];
	$("#us_id").val(row.us_id);
	$("#us_name").val(row.us_name);
	$("#us_sex").val(row.us_sex);
	$("#us_phone").val(row.us_phone);
	$("#us_email").val(row.us_email);
	$("#us_work_year").val(row.us_work_year);
	$("#us_intro").val(row.us_intro);
	$("#upicPath").val("");if(row.us_picpath){
		$("#pic").attr("src", row.us_picpath);
	}else{
		$("#pic").attr("src", "image/not_pic.jpg");
	}
}

$("#modifyDiv").dialog({
	title:"用户详情",
	closable:false,
});
$("#modifyDiv").dialog("close");
//详情
function openDatail(index){
	$(".updateBtn").hide();
	showInfo(index);

}
$(".closeBtn").linkbutton({
	iconCls: "icon-cancel",
	onClick: function(){
		$("#modifyDiv").dialog("close");
	} 	
});
