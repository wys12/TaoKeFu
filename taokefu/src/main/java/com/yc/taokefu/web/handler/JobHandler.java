package com.yc.taokefu.web.handler;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.yc.taokefu.entity.JobClass;
import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.service.CompanyAllService;
import com.yc.taokefu.service.JobClassService;
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
	@Autowired 
	private JobClassService jobClassService;

	/**
	 * index查询职位信息
	 * @param companyAll
	 * @return
	 */
	@RequestMapping(value="index",method=RequestMethod.POST)
	public String findJob(String searchTypes,String search_input,CompanyAll companyAll,PaginationBean<CompanyAll> paginationBean) {
		ServletUtil.type=Integer.valueOf(searchTypes);
		companyAll.setJob_name(search_input);
		LogManager.getLogger().debug("=="+companyAll);
		if(searchTypes.intern() == "0"){
			ServletUtil.JOB_LIST = companyAllServics.findJobName(companyAll);
		}else if(searchTypes.intern() == "1"){
			ServletUtil.JOB_LIST = companyAllServics.findCompenyName(companyAll);
		}else{
			ServletUtil.JOB_LIST = null;
		}
		String red="redirect:/list.html?search_input="+search_input;
		System.out.println("red==="+red);
		return red;
	}

	@RequestMapping(value="findRange",method=RequestMethod.POST)
	@ResponseBody
	public List<CompanyAll> findRange(CompanyAll companyAll) {
		if(companyAll.getJob_min_salary()!=null && companyAll.getJob_min_salary()!=""){
			String []salary =companyAll.getJob_min_salary().split("-");
			companyAll.setJob_max_salary(salary[1].substring(0, salary[1].indexOf("k")));
			companyAll.setJob_min_salary(salary[0].substring(0, salary[0].indexOf("k")));
		}
		LogManager.getLogger().debug(companyAll);
		//ServletUtil.JOB_LIST = companyAllServics.findRange(companyAll);
		return companyAllServics.findRange(companyAll);
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
			LogManager.getLogger().debug("lists ===>  "+ServletUtil.JOB_LIST);
			return ServletUtil.JOB_LIST;
		}else if(ServletUtil.type.equals(1)){
			ServletUtil.JOB_LIST = companyAllServics.findCompenyName(companyAll);
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
		LogManager.getLogger().debug("公司id === " +job_id+"c_id"+c_id);
	}
	@RequestMapping(value="findCompany")
	@ResponseBody
	public List<CompanyAll> findCompany(CompanyAll job) {
		job.setJob_id(ServletUtil.job_id);
		LogManager.getLogger().debug("job==>   "+job);
		return jobService.findCompany(job);
	}
	/**
	 * 查询职位信息
	 * @param job
	 * @return
	 */
	@RequestMapping(value="findJob")
	@ResponseBody
	public List<CompanyAll> findJob(CompanyAll job) {
		return jobService.findCompany(job);
	}
	/**
	 * wys
	 * 查询公司发布的所有职位
	 * @param job
	 * @return
	 */
	@RequestMapping(value="findCompanyJob")
	@ResponseBody
	public List<CompanyAll> findCompanyJob(CompanyAll comJob) {
		comJob.setC_id(ServletUtil.c_ids);
		return jobService.findCompanyJob(comJob);
	}
	/**
	 * wys
	 * 公司发布职位
	 * @param rows
	 * @param page
	 * @return
	 */
	@RequestMapping(value="insertCompanyJob",method=RequestMethod.POST)
	@ResponseBody
	public int insertCompanyJob(CompanyAll comJob) {
		comJob.setC_id(ServletUtil.c_ids);
		comJob.setJob_ftime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		LogManager.getLogger().debug(comJob);
		return jobService.insertCompanyJob(comJob);
	}

	/**
	 * wys
	 * 公司职位状态修改
	 * @param rows
	 * @param page
	 * @return
	 */
	@RequestMapping(value="modifiJobState",method=RequestMethod.POST)
	@ResponseBody
	public int modifiJobState(Job job) {
		LogManager.getLogger().debug(job);
		return jobService.modifiJobState(job);
	}

	/**
	 * wys
	 * 对以添加的职位进行查询
	 * @param comJob
	 * @return
	 */
	@RequestMapping(value="findJobEidt",method=RequestMethod.POST)
	@ResponseBody
	public List<CompanyAll> findJobEidt(CompanyAll comJob) {
		ServletUtil.job_id=comJob.getJob_id();
		return jobService.findJobEidt(comJob);
	}
	/**
	 * wys
	 * 简历查询职位信息
	 * @param comJob
	 * @return
	 */
	@RequestMapping(value="findResumeJob",method=RequestMethod.POST)
	@ResponseBody
	public List<CompanyAll> findResumeJob(CompanyAll job) {
		return jobService.findResumeJob(job);
	}


	/**
	 * wys
	 * 对以添加的职位进行修改
	 * @param comJob
	 * @return
	 */
	@RequestMapping(value="modifiJobEidt",method=RequestMethod.POST)
	@ResponseBody
	public int modifiJobEidts(CompanyAll comJob) {
		comJob.setJob_id(ServletUtil.job_id);
		return jobService.modifiJobEidts(comJob);
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
		if(job.getJob_nature().equals(1)){
			job.setJob_nature("全职");
		}else{
			job.setJob_nature("兼职");
		}
		String min_salary=job.getJob_min_salary()+"k";
		job.setJob_min_salary(min_salary);
		String max_salary=job.getJob_max_salary()+"k";
		job.setJob_max_salary(max_salary);

		LogManager.getLogger().debug("添加"+job);
		return jobService.jobAdd(job);
	}

	//查询职位类型
	@RequestMapping("jcList")
	@ResponseBody //响应Json数据
	public PaginationBean<JobClass> jcList(String rows,String page){
		LogManager.getLogger().debug("职位类型  --> rows==>"+rows +",page==>"+page);
		return jobClassService.jcListPartUsers(page,rows);
	}
	//添加职位类型
	@RequestMapping(value="jcAdd",method=RequestMethod.POST)
	@ResponseBody
	public boolean doJcAdd(JobClass jobClass){
		LogManager.getLogger().debug("添加"+jobClass);
		return jobClassService.BackjcAdd(jobClass);
	}
	//修改职位类型
	@RequestMapping(value="jcEdit",method=RequestMethod.POST)
	@ResponseBody
	public boolean doJcEdit(JobClass jobClass){
		LogManager.getLogger().debug("添加"+jobClass);
		return jobClassService.BackJcEdit(jobClass);
	}

	//后台删除职业类型
	@RequestMapping("deleteJcById")
	@ResponseBody
	public String doJcDelete(HttpServletRequest request){
		String ids = request.getParameter("ids");
		String[] id = ids.split(",");
		for (int i = 0; i < id.length;i++) {
			LogManager.getLogger().debug("删除用户"+id[i]);
			jobClassService.BackJcDelete(id[i]);
		}
		return "true";
	}

	/**
	 * 后台职业类型查询
	 */
	@RequestMapping("jcSearch")
	@ResponseBody
	public List<JobClass> doJcSearch(JobClass jobClass){
		try {
			jobClass.setJc_type(new String(jobClass.getJc_type().getBytes("ISO-8859-1"),"UTF-8"));
			LogManager.getLogger().debug("后台职业类型查询:"+"检索类型"+jobClass.getJc_type());
			LogManager.getLogger().debug(jobClass);	
			List<JobClass> list = new ArrayList<JobClass>();
			list= jobClassService.BackJcSearch(jobClass);
			LogManager.getLogger().debug("list ========  >"+list);
			return list;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * 首页左边客服类型加载
	 * 
	 */

	@RequestMapping(value="findJc_type",method=RequestMethod.POST)
	@ResponseBody
	public List<JobClass> findClassType(JobClass jobClass) {
		LogManager.getLogger().debug("index ===>  "+ServletUtil.JOBCLASSTYPE_LIST);
		if(ServletUtil.JOBCLASSTYPE_LIST.size() != 0 && ServletUtil.JOBCLASSTYPE_LIST == null){
			LogManager.getLogger().debug("返回界面职位类型信息   ==> "+ServletUtil.JOBCLASSTYPE_LIST);
			return ServletUtil.JOBCLASSTYPE_LIST;
		}else{
			ServletUtil.JOBCLASSTYPE_LIST = jobClassService.jobClassTypeFind(jobClass);
			return ServletUtil.JOBCLASSTYPE_LIST;
		}
	}
	/*
	 * 首页左边客服类型名称加载
	 * 
	 */

	@RequestMapping(value="findJc_name",method=RequestMethod.POST)
	@ResponseBody
	public List<JobClass> findClassName(JobClass jobClass) {
		ServletUtil.JOBCLASSNAME_LIST = jobClassService.jobClassNameFind(jobClass);
		LogManager.getLogger().debug("index ===>  "+ServletUtil.JOBCLASSNAME_LIST);
		return ServletUtil.JOBCLASSNAME_LIST;
	}
	
	//首页职位list
		@RequestMapping("jObList")
		@ResponseBody //响应Json数据
		public PaginationBean<Job> jObList(String rows,String page){
			LogManager.getLogger().debug("职位List  --> rows==>"+rows +",page==>"+page);
			return jobService.listPartUsers(page,rows);
		}
}


