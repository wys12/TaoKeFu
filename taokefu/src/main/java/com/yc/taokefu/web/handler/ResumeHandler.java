package com.yc.taokefu.web.handler;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.JobClass;
import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.Resume;
import com.yc.taokefu.entity.UserAll;
import com.yc.taokefu.service.AdminService;
import com.yc.taokefu.service.CompanyAllService;
import com.yc.taokefu.service.ResumeService;
import com.yc.taokefu.service.UserService;
import com.yc.taokefu.util.ServletUtil;

@Controller("resumeHandler")
@RequestMapping("resume")
public class ResumeHandler {

	@Autowired
	private  ResumeService resumeService;
	@Autowired
	private  UserService userService;
	@Autowired
	private  AdminService adminService;
	@Autowired
	private  CompanyAllService companyAllService;

	/**
	 * wys
	 * 简历的投递
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value="insertResume",method=RequestMethod.POST)
	@ResponseBody
	public int insertResume(UserAll user,HttpSession session){
		user.setTkf_id(ServletUtil.login_session(session).getL_id());///用户和id
		user.setC_id(ServletUtil.c_id);//公司id
		user.setTak_id(ServletUtil.job_id);//职位id
		LogManager.getLogger().debug("user  ===  "+user);
		List<Resume> list = resumeService.findResumes(user);
		LogManager.getLogger().debug("list  ===  "+list);
		user.setUs_email(userService.findUser(user).get(0).getUs_email());
		user.setExp_city(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		if(list.size()==0){
			UserAll user1=userService.findUser(user).get(0);
			UserAll usResume=userService.findUsResume(user).get(0);
			UserAll educationa=userService.findEducationa(user).get(0);
			UserAll experience=userService.findExperience(user).get(0);
			user1.setTkf_id(ServletUtil.login_session(session).getL_id());
			user1.setC_id(ServletUtil.c_id);
			usResume.setTkf_id(ServletUtil.login_session(session).getL_id());
			usResume.setC_id(ServletUtil.c_id);
			educationa.setTkf_id(ServletUtil.login_session(session).getL_id());
			educationa.setC_id(ServletUtil.c_id);
			experience.setTkf_id(ServletUtil.login_session(session).getL_id());
			experience.setC_id(ServletUtil.c_id);
			return resumeService.insertResume(user,user1,usResume,educationa,experience);
		}else{
			LogManager.getLogger().debug("已有你的简历");
			return 2;
		}
	}
	
	/**
	 * wys
	 *  个人查看简历
	 * @param user
	 * @return
	 */
	@RequestMapping(value="findUserResume",method=RequestMethod.POST)
	@ResponseBody
	public List<Resume> findUserResume(Resume resume){
		LogManager.getLogger().debug(resume);
		return resumeService.findUserResume(resume);
	}
	
	/**
	 * 简历投递状态的修改
	 * @param resume
	 * @return
	 */
	@RequestMapping(value="modifiResumeState",method=RequestMethod.POST)
	@ResponseBody
	public int modifiResumeState(Resume resume,CompanyAll companyAll){
		LogManager.getLogger().debug("resume"+resume);
		if(resume.getUsr_state().equals("-2")){
			companyAll.setJob_id(resume.getJob_id());;
			LogManager.getLogger().debug("company==="+companyAll);
			LogManager.getLogger().debug("company==="+companyAllService.findJobCompany(companyAll));
			adminService.sendEmail(resumeService.findSendResumeEmail(resume).get(0), companyAllService.findJobCompany(companyAll).get(0));
		}
		resume.setRes_modifiTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return resumeService.modifiResumeState(resume);
	}
	/**
	 * 删除简历
	 * @param resume
	 * @return
	 */
	@RequestMapping(value="deleteResumeState",method=RequestMethod.POST)
	@ResponseBody
	public int deleteResumeState(Resume resume){
		LogManager.getLogger().debug(resume);
		return resumeService.deleteResumeState(resume);
	}
	
	/**
	 * wys
	 * 查询投递的简历
	 * @param resume
	 * @param session
	 * @return
	 */
	@RequestMapping(value="findResume",method=RequestMethod.POST)
	@ResponseBody
	public List<Resume> findResume(Resume resume,HttpSession session){
		resume.setC_id(ServletUtil.c_ids);
		LogManager.getLogger().debug(resume);
		return resumeService.findResume(resume);
	}
	/**
	 * wys
	 * @param resume
	 * @return
	 */
	@RequestMapping(value="findResumeInfo",method=RequestMethod.POST)
	@ResponseBody
	public List<Resume> findResumeInfo(Resume resume){
		LogManager.getLogger().debug(resume);
		return resumeService.findResumeInfo(resume);
	}
	
	//后台查询简历查询
		@RequestMapping("list")
		@ResponseBody //响应Json数据
		public PaginationBean<Resume> jcList(String rows,String page){
			LogManager.getLogger().debug("职位类型  --> rows==>"+rows +",page==>"+page);
			return resumeService.listPartUsers(page,rows);
		}

}