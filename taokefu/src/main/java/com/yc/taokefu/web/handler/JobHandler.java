package com.yc.taokefu.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.Company;
import com.yc.taokefu.entity.Job;
import com.yc.taokefu.service.JobService;
/**
 * 工作职位
 * @author wys
 *
 */
@Controller("jobHandler")
@RequestMapping("job")
public class JobHandler {
	@Autowired
	private JobService jobService;
	private List<Job> jobList = null;
	//查询职位信息
	@RequestMapping(value="sendInfo",method=RequestMethod.POST)
	public void find(HttpServletRequest request) {
		String type=request.getParameter("searchType");
		String input=request.getParameter("search_input");
		LogManager.getLogger().debug("职位信息查询条件   ==>input "+input+" type "+type);
		jobList = jobService.jobFind(input);
		/*return "redirect:/list.html";*/
	}
	//查询职位信息
	@RequestMapping(value="findJob",method=RequestMethod.POST)
	@ResponseBody
	public List<Job> findCompany(Job job) {
		return null;
	}

}
