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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.Company;
import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.CompanyTeam;
import com.yc.taokefu.entity.Job;
import com.yc.taokefu.entity.Product;
import com.yc.taokefu.service.CompanyAllService;
import com.yc.taokefu.service.CompanyService;
import com.yc.taokefu.service.CompanyTeamService;
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

	private Map<String,String> search_Info = new HashMap<String,String>();
	private List<CompanyAll> jobList = null;
	private String type = null;
	private String input = null;


	//查询职位信息
	@RequestMapping(value="sendInfo",method=RequestMethod.POST)
	public void find(HttpServletRequest request) {
		type=request.getParameter("searchType");
		input=request.getParameter("search_input");
		search_Info.put("type", request.getParameter("searchType"));
		search_Info.put("input", request.getParameter("search_input"));
		LogManager.getLogger().debug("职位信息查询条件   ==>input "+search_Info.get("input")+" type "+type);
		//return "redirect:/list.html";action="list.html"
	}
	//分条件查询查询职位信息
	@RequestMapping(value="findJobs",method=RequestMethod.POST)
	@ResponseBody
	public List<CompanyAll> findCompany() {
		if(search_Info.get("type")=="0"){
			jobList = companyAllServics.findJobName(search_Info.get("input"));
			LogManager.getLogger().debug("返回界面信息   ==> "+jobList);
			return jobList;
		}else if(search_Info.get("type")=="1"){
			jobList = companyAllServics.findCompenyName(search_Info.get("input"));
			LogManager.getLogger().debug("返回界面信息   ==> "+jobList);
			return jobList;
		}else{
			return null;
		}
	}


	//查询职位信息
	@RequestMapping(value="list",method=RequestMethod.POST)
	@ResponseBody
	public List<CompanyAll> findJob(CompanyAll companyAll) {
		jobList = companyAllServics.findCompenyName(companyAll.getJob_name());
		LogManager.getLogger().debug("companyAll   ==> " + companyAll.getJob_name()+"   jobList  " +jobList);
		return jobList;
	}

}
