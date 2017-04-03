//使用文本编辑工具
var contentEditor = UE.getEditor('encontent',{
	elementPathEnabled:false,
	enableAutoSave:false,
	autoSyncData:false,
	
});


$('#newsEdit').datagrid({  
	url:'news/list',
    fitColumns:true,
    fit:true,
    singleSelect:true,
    border:false,
    pagination:true,
    columns:[[    
        {field:'nid',title:'编号',width:100,align:'center'},    
        {field:'ntid',title:'类型',width:100,align:'center',
        	formatter: function(value,row,index){
        		return row.topic.tname;
        	}
        },    
        {field:'ntitle',title:'标题',width:100,align:'center'},
        {field:'nauthor',title:'作者',width:100,align:'center'}, 
        {field:'ncreatedate',title:'发布',width:100,align:'center'},
        {field:'operator',title:'操作',width:100,align:'center',
        	formatter: function(value,row,index){
        		return '<a class="editBtn" href="javascript:void(0)" onclick="showMOdify('+row.nid+')">修改</a> '
        		+'<a class="delBtn" href="javascript:void(0)" onclick="delNews('+row.nid+')">删除</a>'
        		+' <script> $(".editBtn").linkbutton({iconCls: "icon-ok"});'
        		+'$(".delBtn").linkbutton({iconCls: "icon-cancel"});</script>';
        	}
        }
    ]] 
});

$("#newsModify").dialog({
	title:"新闻预览",
	left:10,
	height:400,
	width:600,
	closed:true,
});

function showMOdify(id){
	$("#newsModify").dialog("open");
	$.post("news/get?nid="+id,function(data){
		$("#ntid").val(data.topic.tname);
		
		//加载所有主题
		$.post("topic/all",function(datat){
			$("#ntid").empty();//清除所有
			for(var i=0; i< datat.length;i++){
				if(data.topic.tname == datat[i].tname){
					$("#ntid").append("<option value='"+datat[i].tid+"' selected>"+ datat[i].tname +"</option>");
				}else{
					$("#ntid").append("<option value='"+datat[i].tid+"'>"+ datat[i].tname +"</option>");
				}
			}
		},"json");
		
		$("#enid").val(data.nid);
		$("#entitle").val(data.ntitle);
		$("#enauthor").val(data.nauthor);
		$("#ensummary").val(data.nsummary);
		contentEditor.setContent(data.ncontent);
		$("#epic").attr("src",(data.npicPath == "" || data.npicPath == null) ? "images/not_pic.jpg" : data.npicPath);
	},"json");
}


$("#modifyForm").form({
	url:"news/modify",
	success:function(data){
		if(data){
			$.messager.alert('修改新闻','修改新闻失败!!','error');
		}else{
			$.messager.alert('修改新闻','修改新闻失败!!','error');
		}
	}

});

$("input#modifyBtn").click(function(){
	$("#ncontent").val(contentEditor.getContent());
	$("#modifyForm").submit();
});

function chgPic(obj){
	$("#epic").attr("src",window.URL.createObjectURL(obj.files[0]));
}


