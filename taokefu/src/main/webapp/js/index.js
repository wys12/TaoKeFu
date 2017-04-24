loadInfo();
var str="";
var jc_type ="";
var type_length = ""
function loadInfo(){
	classList();
	jObList();
}
var map={};
function classList(){
	var str1="";
	var i=0;
	var params ="";
	$.ajax({
		type:'POST',
		url:"job/findJc_type",
		dataTpye:"json",
		//async:false,
		success:function(data){
			for(i=0;i < data.length;i++){
				jc_type = data[i].jc_type;
				str+='<div id="menu_box" class="menu_box">'
					+'<div class="menu_main">'
					+'<h2>'+jc_type+'</h2>'
					+'<div id = type'+i+'></div>'
					+'</div>'
					+'</div>';
				map[i] =jc_type;
			}
			$("#mainNavs").html(str);
			for(var prop in map){
				if(map.hasOwnProperty(prop)){
					findJc_name(map[prop],prop);
				}
			}
		}
	});
}
function findJc_name(jc_type,x){
	var params = {jc_type:jc_type};
	str1="";
	$.ajax({
		type:'POST',
		url:"job/findJc_name",
		data:params,
		dataTpye:"json",
		async:false,
		success:function(data){
			for(var s=0;s<data.length;s++){
				str1+='<a href="list.html" onclick="typeSearch(\''+data[s].jc_name+'\')">'+data[s].jc_name+'</a>';
			}
			$("#type"+x).html(str1);
		}
	});

}
function typeSearch(data){
	var params = {search_input:data,searchTypes:'0'};
	$.ajax({
		type:'POST',
		url:"job/index",
		data:params,
		dataTpye:"json",
		async:false,
		success:function(data){
		
		}
	});
}
$("#search_button").click(function(){
	var searchType = $('#searchType li').val(); //查询类型 0 1
	$("#searchTypes").val(searchType);
	$("#searchForm").attr("action","job/index");
	$("#searchForm").submit();
});
function jObList(){
	var urlStr = "job/lists";
	$.ajax({
		type:'POST',
		url: urlStr,
		dataTpye:"json",
		//async:false,
		success:function(data){
			var strJobList="";
			for(var i =0;i<data.length;i++){
				if(i%2==0){
					strJobList+='<li class="clearfix"><div class="hot_pos_l"><div class="mb10"><a href="toudi.html" onclick="toudi('+data[i].job_id+')" title="'+data[i].job_name+'" target="_blank">'+data[i].job_name+'</a>&nbsp; <span class="c9">['+data[i].comp_city+']</span></div>'
					+'<span><em class="c7">月薪：</em>'+data[i].job_min_salary+'-'+data[i].job_max_salary+'</span> <span><em class="c7">经验：</em> 3-5年</span> <span><em class="c7">最低学历：'
					+data[i].job_education+'</em></span> <br /> <span><em class="c7">职位诱惑：</em>'+data[i].job_tempt+'</span><br /> <span>'+data[i].job_ftime+'发布</span>'
					+'</div><div class="hot_pos_r"><div class="mb10"><input hidden="" class="c_id" value="'+data[i].c_id+'"><a href="'+data[i].pro_link+'" title="'+data[i].comp_name+'" target="_blank">'+data[i].comp_name+'</a></div>'
					+'<span><em class="c7">领域： </em>'+data[i].comp_territory+'</span> <span><em class="c7">创始人：</em> '+data[i].ct_name+'</span> <br /> <span><em class="c7">阶段： </em>'+data[i].comp_state+'</span> <span><em class="c7">规模：'
					+'</em>15-50人</span><ul class="companyTags reset"><li>股票期权</li><li>五险一金</li><li>带薪年假</li></ul></div></li>';
				}else{
					strJobList+='<li class="odd clearfix"><div class="hot_pos_l"><div class="mb10"><a href="toudi.html" onclick="toudi('+data[i].job_id+')" title="'+data[i].job_name+'" target="_blank">'+data[i].job_name+'</a>&nbsp; <span class="c9">['+data[i].comp_city+']</span></div>'
					+'<span><em class="c7">月薪：</em>'+data[i].job_min_salary+'-'+data[i].job_max_salary+'</span> <span><em class="c7">经验：</em> 3-5年</span> <span><em class="c7">最低学历：'
					+data[i].job_education+'</em></span> <br /> <span><em class="c7">职位诱惑：</em>'+data[i].job_tempt+'</span><br /> <span>'+data[i].job_ftime+'发布</span>'
					+'</div><div class="hot_pos_r"><div class="mb10"><input hidden="" class="c_id" value="'+data[i].c_id+'"><a href="'+data[i].pro_link+'" title="'+data[i].comp_name+'" target="_blank">'+data[i].comp_name+'</a></div>'
					+'<span><em class="c7">领域： </em>'+data[i].comp_territory+'</span> <span><em class="c7">创始人：</em> '+data[i].ct_name+'</span> <br /> <span><em class="c7">阶段： </em>'+data[i].comp_state+'</span> <span><em class="c7">规模：'
					+'</em>'+data[i].comp_scale+'</span><ul class="companyTags reset"><li>股票期权</li><li>五险一金</li><li>带薪年假</li></ul></div></li>';
				}
			}
			$("#hot_pos_reset").html(strJobList);
			$("#hot_pos_reset2").html(strJobList);
		}
	});
}

function toudi(data){
	var c_id = $(".c_id").val();
	//alert("job_id"+data+"c_id"+c_id);
	$.post("job/sendCompany",{job_id:data,c_id:c_id},"json");
}

$("#searchType li").click(function(){
 	$(this).siblings("li").hide(),
 	$(this).hasClass("type_selected")||($("#searchType li").removeClass("type_selected")),
 	$(this).addClass("type_selected").prependTo("#searchType");
 	var b=$(this).attr("data-searchtype");
 	1==b?($("#search_input").attr("placeholder","请输入职位名称，如：产品经理"),$(".placeholder").val("请输入职位名称，如：产品经理")):($("#search_input").attr("placeholder","请输入公司名称，如：拉勾"),$(".placeholder").val("请输入公司名称，如：拉勾")),$("#spcInput").val(b),$(this).children("li").not(".type_selected").hide(),$(this).siblings(".searchtype_arrow").removeClass("transform")});

$("#searchType").hover(
 		function(){
 			$(this).children("li").show(),
 			$(this).siblings(".searchtype_arrow").addClass("transform")
 		},
 		function(){
 			$(this).children("li").not(".type_selected").hide(),
 			$(this).siblings(".searchtype_arrow").removeClass("transform")
 		})

