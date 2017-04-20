loadInfo();
var str="";
var jc_type ="";
var type_length = ""
function loadInfo(){
	$.post("job/findJc_type",function(data){
		type_length = data.length;
		for(var i=0;i < type_length;i++){
			//alert(i)
			jc_type = data[i].jc_type;
				str+='<div id="menu_box" class="menu_box">'
					+'<div class="menu_main">'
					+'<h2>'+jc_type+'</h2>'
					+'<div id = type'+i+'></div>'
					+'</div>'
					+'</div>';
			findJc_name(jc_type,i);
		}
		$("#mainNavs").html(str);
		//alert(str);
	},"json");
}
function findJc_name(datas,z){
	var str1="";
	$.post("job/findJc_name",{jc_type:datas},function(data){
		//for(var j=0;j<type_length;j++){
			for(var i=0;i<data.length;i++){
				str1+='<a href="list.html" onclick="typeSearch('+data[i].jc_name+')">'+data[i].jc_name+'</a>';
			}
			$("#type"+z).html(str1);
	},"json");
}
function typeSearch(data){
	alert(data);
	$.post("job/index",{search_input:data},"json");
}
$("#search_button").click(function(){
	var searchType = $('#searchType li').val(); //查询类型 0 1
	$("#searchTypes").val(searchType);
	$("#searchForm").attr("action","job/index");
	$("#searchForm").submit();
	//$.post("job/sendInfo",{searchType:searchType,job_name:search_input,currPage:i},"json");
	//setTimeout("submit()", 800);
});

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


