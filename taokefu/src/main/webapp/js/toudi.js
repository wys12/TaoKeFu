loadInfo();
var str="";
function loadInfo(){
	GetRequest();
}
function GetRequest() { 
    var url = location.search; //获取url中"?"符后的字串   
    var theRequest = new Object();  
    if (url.indexOf("?") != -1) {  
        var str = url.substr(1);  
        strs = str.split("&");  
        for (var i = 0; i < strs.length; i++) {  
            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);  
        }  
    }  
    return theRequest;  
}  
$(document).ready(function () {  
    var Request = new Object();  
    Request = GetRequest();  
    var val= Request["job_id"];    
    alert(JSON.stringify(val));  
}); 