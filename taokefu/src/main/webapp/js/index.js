loadInfo();
var str="";
var jc_type ="";
var type_length = ""
	function loadInfo(){
	list();
}
var map={};
function list(){
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
				str1+='<a href="javascript:void(0)" onclick="typeSearchs(\''+data[s].jc_name+'\')">'+data[s].jc_name+'</a>';
			}
			$("#type"+x).html(str1);
		}
	});

}
function typeSearchs(params){
		
}
$("#search_button").click(function(){
	var searchType = $('#searchType li').val(); //查询类型 0 1
	$("#searchTypes").val(searchType);
	$("#searchForm").attr("action","job/index");
	$("#searchForm").submit();
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

