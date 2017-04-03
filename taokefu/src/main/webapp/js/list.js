loadInfo();
function loadInfo(){
	var searchType = $('#searchType li').val(); //查询类型 0 1
	var search_input = $('#search_input').val();//输入查询

	var searchForm = $('#searchForm').val();
	var plInput = $('#plInput').val();
	var gjInput = $('#gjInput').val();
	var xlInput = $('#xlInput').val();
	var yxInput = $('#yxInput').val();
	var gxInput = $('#gxInput').val();
	var stInput = $('#stInput').val();
	if(searchType == 0){//根据职位类型查询
		alert("职位类型查询  "+searchType);
		$.post("job/findJob",{job_name:search_input},function(data){
			//alert("根据职位类型查询  "+JSON.stringify(data));
		},"json");
	}else if(searchType == 1){//根据公司查询
		$.post("company/findCompany",{comp_name:search_input},function(data){
			//alert(data);
		},"json");
	}
}