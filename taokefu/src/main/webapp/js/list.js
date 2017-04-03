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

	//alert("职位类型查询  "+searchType);
	/*[{"job_id":1001,"c_id":1001,"job_name":"qq客服","job_department":"网络客服",
		"job_nature":"初级客服","job_min_salary":"3k","job_max_salary":"3.5k","" +
				"job_ftime":"2017-4-3","job_request":"清华硕士，客服三年经验"}]*/
	$.post("job/findJob",function(data){
		//alert("根据职位类型查询  "+JSON.stringify(data));
		//data=JSON.stringify(data);
		for(var i=0;i<data.length;i++){
			alert(JSON.stringify(data[i]));
			$("#jobInfo").html('<li class="clearfix"><div class="hot_pos_l"><div class="mb10"><a href="h/jobs/114177.html" title="前端开发" target="_blank">前端开发</a>&nbsp; <span class="c9">[北京]</span></div>'
					+'<span><em class="c7">月薪：</em>'+data[i].job_min_salary+'-'+data[i].job_max_salary+'</span> <span><em class="c7">经验：</em> 3-5年</span> <span><em class="c7">最低学历：'
					+data[i].job_request+'</em></span> <br /> <span><em class="c7">职位诱惑：</em>第一家互联网私人银行招募各路牛人</span><br /> <span>09:41发布</span>'
					+'</div><div class="hot_pos_r"><div class="apply"><a href="toudi.html" target="_blank">投个简历</a></div><div class="mb10"><a href="h/c/7626.html" title="网利宝" target="_blank">网利宝</a></div>'
					+'<span><em class="c7">领域： </em>O2O,金融互联网</span> <span><em class="c7">创始人：</em> 赵润龙（Kevin Chiu）</span> <br /> <span><em class="c7">阶段： </em>成长型(A轮)</span> <span><em class="c7">规模：'
					+'</em>15-50人</span><ul class="companyTags reset"><li>股票期权</li><li>五险一金</li><li>带薪年假</li></ul></div></li>');
		}
	},"json");

	/*$.post("job/findJob",{job_name:search_input},function(data){
			alert("根据职位类型查询  "+JSON.stringify(data));

		},"json");
		$.post("company/findCompany",{comp_name:search_input},function(data){
			//alert(data);
		},"json");*/
}
