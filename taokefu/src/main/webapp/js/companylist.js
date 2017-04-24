loadInfo();
var str="";
function loadInfo(){
	$.post("company/findAllCompany",function(data){
		shouInfo(data);
	},"json");
}

function sendInfo(data){
	$.post("job/lists",{job_name:data},function(){
		loadInfo();
	},"json");
}
function shouInfo(data){
	console.info(JSON.stringify(data));
	str="";
	for(var i=0;i<data.length;i++){
		str+='<li><a href="http://'+data[i].comp_link+'" target="_blank"><h3 title="'+data[i].comp_name+'">'+data[i].comp_name+'</h3><div class="comLogo">'
			+'<img src="'+data[i].comp_logo+'" width="190" height="190" alt="'+data[i].comp_name+'"/>'
			+'<ul><li>'+data[i].comp_territory+'</li> <li>'+data[i].comp_city+'，'+data[i].comp_state+'</li></ul></div></a><div id="companylist'+data[i].comp_id+'"></div></li>';
		
	}
	$("#companylist").html(str);
	for(var i=0;i<data.length;i++){
		str="";
		for(var j=0;j<data[i].jobs.length;j++){
			str+='<a href="toudi.html" onclick="toudi('+data[i].jobs[j].job_id+')" target="_blank">'+data[i].jobs[j].job_name+'</a>';
		}
		str+='<ul class="reset ctags"><li>'+data[i].comp_state+'</li> <li>'+data[i].comp_territory+'</li></li><div id="companylisttag'+data[i].comp_id+'"></div> </ul>';
		$("#companylist"+data[i].comp_id).html(str);
	}
	for(var i=0;i<data.length;i++){
		str="";
		for(var j=0;j<data[i].jobs.length;j++){
			str+='<li>'+data[i].jobs[j].job_tags+'</li>';
		}
		$("#companylisttag"+data[i].comp_id).html(str);
	}
}
function toudi(data){
	var c_id = $(".c_id").val();
	//alert("job_id"+data+"c_id"+c_id);
	$.post("job/sendCompany",{job_id:data,c_id:c_id},"json");
}
/*function number(number){
	alert("list "+ number);
	if(number==0 && i>0){
		alert("首页");
		i=1;
	}else if(number==1 && i>0){
		alert("上一页");
		i=i+1;
	}else if(number==2 && i>0){
		alert("下一页");
		i=i-1;
	}else if(number==3 && i>0){
		alert("未页");
		i=-1;
	}else{
		i=1;
	}
	sendInfo();
	outLoadInfo();
}*/
/*$.post("company/findCompany",{comp_name:search_input},function(data){alert(data);},"json");*/
