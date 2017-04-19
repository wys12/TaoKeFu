loadInfo();
function loadInfo(){
	$.post("job/findJc_type",function(data){
		var str="";
		for(var i=0;i<data.length;i++){
				str+='<div id="menu_box" class="menu_box">'
					+'<div class="menu_main">'
					+'<h2>'+data[i].jc_type+'</h2>'
					+'<a href="list.html" onclick="typeSearch('+data[i].jc_name+')">'+data[i].jc_name+'</a>'
					+'</div>'
					+'</div>';
		}
		$("#mainNavs").html(str);
		alert(str);
	},"json");
	
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


