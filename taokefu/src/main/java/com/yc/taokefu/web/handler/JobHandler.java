package com.yc.taokefu.web.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.Job;
import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.service.CompanyAllService;
import com.yc.taokefu.service.JobService;
import com.yc.taokefu.util.ServletUtil;
/**
 * @author wys
 */
@Controller("jobHandler")
@RequestMapping("job")
public class JobHandler {
	@Autowired
	private CompanyAllService companyAllServics;
	@Autowired 
	private JobService jobService;
	
	/**
	 * index查询职位信息
	 * @param companyAll
	 * @return
	 */
	@RequestMapping(value="index",method=RequestMethod.POST)
	public String findJob(String searchTypes,String search_input,CompanyAll companyAll,PaginationBean<CompanyAll> paginationBean) {
		ServletUtil.type=Integer.valueOf(searchTypes);
		companyAll.setJob_name(search_input);
		if(searchTypes.intern() == "0"){
			ServletUtil.JOB_LIST = companyAllServics.findJobName(companyAll);
			//LogManager.getLogger().debug("index ===>  "+ServletUtil.JOB_LIST);
		}else if(searchTypes.intern() == "1"){
			ServletUtil.JOB_LIST = companyAllServics.findCompenyName(search_input,0,0);
		}else{
			ServletUtil.JOB_LIST = null;
		}
		return "redirect:/list.html";
	}
	
	
	/**
	 * list查询信息   wys
	 * @param <T>
	 * @param companyAll
	 * @param request
	 */
	@RequestMapping(value="lists",method=RequestMethod.POST)
	@ResponseBody
	public List<CompanyAll> find(CompanyAll companyAll) {
		if(ServletUtil.type.equals(0)){
			ServletUtil.JOB_LIST = companyAllServics.findJobName(companyAll);
			//LogManager.getLogger().debug("lists ===>  "+ServletUtil.JOB_LIST);
			return ServletUtil.JOB_LIST;
		}else if(ServletUtil.type.equals(1)){
			ServletUtil.JOB_LIST = companyAllServics.findCompenyName(companyAll.getJob_name(),0,0);
			return ServletUtil.JOB_LIST;
		}else{
			return null;
		}
	}
	
	/**  wys
	 * 返回信息
	 * @return
	 */
	@RequestMapping(value="findJobs",method=RequestMethod.POST)
	@ResponseBody
	public List<CompanyAll> findCompany() {
		if(ServletUtil.JOB_LIST!=null){
			LogManager.getLogger().debug("返回界面信息   ==> "+ServletUtil.JOB_LIST);
			return ServletUtil.JOB_LIST;
		}else{
			return null;
		}
	}
	/**
	 * 点击投递简历显示公司详情   wys
	 * @param job_id
	 */
	@RequestMapping(value="sendCompany",method=RequestMethod.POST)
	public void getCompany(String job_id,String c_id ) {
		ServletUtil.job_id=Integer.valueOf(job_id);
		ServletUtil.c_id = Integer.valueOf(c_id);
		LogManager.getLogger().debug("公司id === " +job_id);
	}
	
	@RequestMapping(value="findCompany")
	@ResponseBody
	public List<CompanyAll> findCompany(CompanyAll job) {
		job.setJob_id(ServletUtil.job_id);
		LogManager.getLogger().debug("job==>   "+job);
		return jobService.findCompany(job);
	}
	
	//查询所有职位
	@RequestMapping("list")
	@ResponseBody //响应Json数据
	public PaginationBean<Job> list(String rows,String page){
		LogManager.getLogger().debug("职位  --> rows==>"+rows +",page==>"+page);
		return jobService.listPartUsers(page,rows);
	}
	/**
	 * 根据ids[job_id]删除  fv
	 */
	@RequestMapping("deleteById")
	public Boolean doDelete(HttpServletRequest request){
		String ids = request.getParameter("ids");
		String[] id = ids.split(",");
			for (int i = 0; i < id.length;i++) {
				LogManager.getLogger().debug("进行删除"+id[i]);
				jobService.deleteJob(Integer.parseInt(id[i]));
			}
			return null;
			
	} 
	/**
	 * 根据job_id修改 fv
	 */
	@RequestMapping("edit")
	public Boolean doEdit( Job job){
		LogManager.getLogger().debug("进行修改"+job.getJob_id()+job.getJob_need());
		return jobService.editJob(job);
	}
	/**
	 * 多条件查询职位 fv
	 * fv
	 */
	@RequestMapping("search")
	@ResponseBody
	public List<Job> doSearch(Job job){
		LogManager.getLogger().debug("多条件查询"+job.getJob_nature()+job.getJob_start_time()+job.getJob_end_time());
		if(job.getJob_nature().equals("1")){
			job.setJob_nature("全职");
			return jobService.search(job);
			//System.out.println(job.getJob_nature());
		}else{
			job.setJob_nature("兼职");
			List<Job> list = new ArrayList<Job>();
			list= jobService.search(job);
			LogManager.getLogger().debug("list ========  >"+list);
			return list;//jobService.search(job);
		}
	}
	
	
	/**
	 * 添加职位 fv
	 * fv
	 */
	@RequestMapping("add")
	public int doAdd(Job job){
		LogManager.getLogger().debug("添加"+job);
		return jobService.jobAdd(job);
	}
}


