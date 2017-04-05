package com.yc.taokefu.web.handler;

import java.util.ArrayList;
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

	private List<CompanyAll> jobList = new ArrayList<CompanyAll>();
	private String type = null;
	private Integer types = null;


	//查询职位信息
	@RequestMapping(value="sendInfo",method=RequestMethod.POST)
	//@ResponseBody
	public void find(CompanyAll companyAll,HttpServletRequest request) {
		type=request.getParameter("searchType");
		if(type!=null){
			types=Integer.valueOf(type);
		}
		/* input=request.getParameter("search_input");
		search_Info.put("type", request.getParameter("searchType"));
		search_Info.put("input", request.getParameter("search_input"));*/
		//LogManager.getLogger().debug("job_name "+companyAll.getJob_name());
		//LogManager.getLogger().debug("职位信息查询条件   ==>input "+companyAll.getJob_name()+" types "+types);
		if(types.equals(0)){
			jobList = companyAllServics.findJobName(companyAll.getJob_name());
			LogManager.getLogger().debug("返回界面职位信息   ==> "+jobList);
		}else if(types.equals(1)){
			jobList = companyAllServics.findCompenyName(companyAll.getJob_name());
			LogManager.getLogger().debug("返回界面公司信息   ==> "+jobList);
		}else{
			jobList = null;
		}
		//return "redirect:/list.html";
	}
	//分条件查询查询职位信息
	@RequestMapping(value="findJobs",method=RequestMethod.POST)
	@ResponseBody
	public List<CompanyAll> findCompany() {
		if(jobList!=null){
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
