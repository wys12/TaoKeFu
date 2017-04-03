package com.yc.taokefu.web.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

<<<<<<< HEAD
=======
import com.yc.taokefu.entity.Company;
import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.CompanyTeam;
>>>>>>> branch 'master' of ssh://git@github.01.com/wys12/taokefu
import com.yc.taokefu.entity.Job;
<<<<<<< HEAD
import com.yc.taokefu.entity.PaginationBean;
=======
import com.yc.taokefu.entity.Product;
import com.yc.taokefu.service.CompanyAllService;
import com.yc.taokefu.service.CompanyService;
import com.yc.taokefu.service.CompanyTeamService;
>>>>>>> branch 'master' of ssh://git@github.01.com/wys12/taokefu
import com.yc.taokefu.service.JobService;
import com.yc.taokefu.service.TagService;
/**
 * 工作职位
 * @author wys
 *
 */
@Controller("jobHandler")
@RequestMapping("job")
public class JobHandler {
	@Autowired
	private CompanyAllService companyAllServics;
	@Autowired
	private JobService jobService;
	/*@Autowired
	private CompanyService companyService;
	@Autowired
	private TagService tagService;
	@Autowired
	private CompanyTeamService companyTeamService;
	@Autowired
	private Product croductTeamService;*/

	private Map<String,String> search_Info = new HashMap<String,String>();
	private List<CompanyAll> jobList = null;
	private String type = null;
	private String input = null;
	//查询职位信息
	@RequestMapping(value="sendInfo",method=RequestMethod.POST)
	@ResponseBody
	public String find(HttpServletRequest request) {
		type=request.getParameter("searchType");
		input=request.getParameter("search_input");
		LogManager.getLogger().debug("职位信息查询条件   ==>input "+input+" type "+type);
		search_Info.put("type", request.getParameter("searchType"));
		search_Info.put("input", request.getParameter("search_input"));
		LogManager.getLogger().debug("职位信息查询条件   ==>input "+search_Info.get("input")+" type "+type);
		//return "redirect:/list.html";action="list.html"
		return null;
	}
	//查询职位信息
	@RequestMapping(value="findJob",method=RequestMethod.POST)
	@ResponseBody
	public List<CompanyAll> findCompany() {
		jobList = companyAllServics.findCompenyName(search_Info.get("input"));
		LogManager.getLogger().debug("返回界面信息   ==> "+jobList);
		return jobList;
	}
		
	//查询所有职位
	@RequestMapping("list")
	@ResponseBody //响应Json数据
	public PaginationBean<Job> list(String rows,String page){
		System.out.println("rows==>"+rows +",page==>"+page);
		return jobService.listPartUsers(page,rows);
	}
	
}

