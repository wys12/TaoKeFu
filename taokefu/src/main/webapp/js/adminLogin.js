$("#loginDiv").dialog({
	title:"",
	top:80,
	width:400,
	height:230,
	border:false,
	modal:true
})
$.extend($.fn.validatebox.defaults.rules, {    
    minLength: {    
        validator: function(value, param){    
            return value.length >= param[0];    
        },    
        message: 'Please enter at least {0} characters.'   
    }    
});  
$('#uname').textbox({      
    iconCls:'icon-man', 
    iconAlign:'left'       
})
$('#upwd').textbox({      
    iconCls:'icon-lock', 
    iconAlign:'left'       
})
