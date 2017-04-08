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

	private List<CompanyAll> jobList = new ArrayList<CompanyAll>();
	private List<CompanyAll> jobLists = new ArrayList<CompanyAll>();
	private Integer type =0;
	private Integer currPage = 1;//当前页
	private Integer pageSize = 8;//每页显示的数据条数
	private Integer job_id;
	
	/**
	 * index查询职位信息
	 * @param companyAll
	 * @return
	 */
	@RequestMapping(value="index",method=RequestMethod.POST)
	public String findJob(String searchTypes,String search_input,CompanyAll companyAll,PaginationBean<CompanyAll> paginationBean) {
		paginationBean.setCurrPage(currPage);
		paginationBean.setPageSize(pageSize);
		type=Integer.valueOf(searchTypes);
		companyAll.setJob_name(search_input);
		if(searchTypes.intern() == "0"){
			jobList = companyAllServics.findJobName(companyAll,currPage,pageSize);
			LogManager.getLogger().debug("index查询返回界面职位信息   ==> "+jobList+"  type  ==> "+type);
		//	page.name(paginationBean,jobList);
		}else if(searchTypes.intern() == "1"){
			jobList = companyAllServics.findCompenyName(search_input,currPage,pageSize);
			LogManager.getLogger().debug("index查询返回界面公司信息   ==> "+jobList);
		}else{
			jobList = null;
		}
		return "redirect:/list.html";
	}
	
	
	/**
	 * list查询信息
	 * @param <T>
	 * @param companyAll
	 * @param request
	 */
	@RequestMapping(value="lists",method=RequestMethod.POST)
	@ResponseBody
	public List<CompanyAll> find(CompanyAll companyAll) {
		LogManager.getLogger().debug("type  ==> "+type);
		if(type.equals(0)){
			jobList = companyAllServics.findJobName(companyAll,currPage,pageSize);
			LogManager.getLogger().debug("index查询返回界面职位信息   ==> "+jobList);
		}else if(type.equals(1)){
			jobList = companyAllServics.findCompenyName(companyAll.getJob_name(),currPage,pageSize);
			LogManager.getLogger().debug("index查询返回界面公司信息   ==> "+jobList);
		}else{
			jobList = null;
		}
		return jobList;
	}
	
	/**
	 * 返回信息
	 * @return
	 */
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
	/**
	 * 点击投递简历显示公司详情
	 * @param job_id
	 */
	@RequestMapping(value="sendCompany",method=RequestMethod.POST)
	public void getCompany(String job_id) {
		this.job_id=Integer.valueOf(job_id);
		LogManager.getLogger().debug("公司id === " +job_id);
	}
	
	@RequestMapping(value="findCompany")
	@ResponseBody
	public List<CompanyAll> findCompany(CompanyAll job) {
		job.setJob_id(this.job_id);
		jobLists = jobService.findCompany(job);
		LogManager.getLogger().debug("查找公司   === " +job);
		return jobLists;
	}
	
	//查询所有职位
	@RequestMapping("list")
	@ResponseBody //响应Json数据
	public PaginationBean<Job> list(String rows,String page){
		LogManager.getLogger().debug("职位  --> rows==>"+rows +",page==>"+page);
		return jobService.listPartUsers(page,rows);
	}
	/**
	 * 根据ids[job_id]删除
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
	 * 根据job_id修改
	 */
	@RequestMapping("edit")
	public Boolean doEdit( Job job){
		LogManager.getLogger().debug("进行修改"+job.getJob_id()+job.getJob_need());
		return jobService.editJob(job);
	}
	/**
	 * 
	 * 多条件查询职位
	 */
	@RequestMapping("search")
	@ResponseBody
	public List<Job> doSearch( Job job){
		LogManager.getLogger().debug("多条件查询"+job.getJob_nature()+job.getJob_start_time()+job.getJob_end_time());
		if(job.getJob_nature()=="1"){
			job.setJob_nature("全职");
			return (List<Job>) jobService.search(job);
			//System.out.println(job.getJob_nature());
		}else{
			job.setJob_nature("兼职");
			return (List<Job>) jobService.search(job);
			//System.out.println(job.getJob_nature());
		}
	}
	/**
	 * 添加职位
	 */
	@RequestMapping("add")
	public int doAdd(Job job){
		LogManager.getLogger().debug("添加"+job);
		return jobService.jobAdd(job);
	}
}


