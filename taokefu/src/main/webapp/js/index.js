$("#search_button").click(function(){
	var searchType = $('#searchType li').val(); //查询类型 0 1
	var search_input = $('#search_input').val();//输入查询
	$.post("job/sendInfo",{searchType:searchType,search_input:search_input},function(data){
	},"json");
	alert("searchType:"+searchType+",search_input:"+search_input);
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
		

