package com.yc.taokefu.web.handler;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.Resume;
import com.yc.taokefu.entity.UserAll;
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

	@RequestMapping(value="insertResume",method=RequestMethod.POST)
	@ResponseBody
	public int insertResume(UserAll user,HttpSession session){
		user.setTkf_id(ServletUtil.login_session(session).getL_id());
		user.setC_id(ServletUtil.job_id);
		user.setTak_id(ServletUtil.c_id);
		List<Resume> list = resumeService.findResumes(user);
		System.out.println("list==="+list);
		if(list.size()==0){
			UserAll user1=userService.findUser(user).get(0);
			UserAll usResume=userService.findUsResume(user).get(0);
			UserAll educationa=userService.findEducationa(user).get(0);
			UserAll experience=userService.findExperience(user).get(0);
			LogManager.getLogger().debug("user == >  "+user);
			user1.setTkf_id(ServletUtil.login_session(session).getL_id());
			user1.setC_id(ServletUtil.job_id);
			usResume.setTkf_id(ServletUtil.login_session(session).getL_id());
			usResume.setC_id(ServletUtil.job_id);
			educationa.setTkf_id(ServletUtil.login_session(session).getL_id());
			educationa.setC_id(ServletUtil.job_id);
			experience.setTkf_id(ServletUtil.login_session(session).getL_id());
			experience.setC_id(ServletUtil.job_id);
			return resumeService.insertResume(user,user1,usResume,educationa,experience);
		}else{
			LogManager.getLogger().debug("已有你的简历");
			return 2;
		}
	}
	
	@RequestMapping(value="modifiResume",method=RequestMethod.POST)
	@ResponseBody
	public int modifiResume(UserAll user){
		LogManager.getLogger().debug(user);
		return 0;
	}
	@RequestMapping(value="findResume",method=RequestMethod.POST)
	@ResponseBody
	public List<Resume> findResume(Resume resume,HttpSession session){
		resume.setC_id(ServletUtil.c_ids);
		System.out.println(ServletUtil.c_id);
		LogManager.getLogger().debug(resume);
		return resumeService.findResume(resume);
	}
	@RequestMapping(value="findResumeInfo",method=RequestMethod.POST)
	@ResponseBody
	public List<Resume> findResumeInfo(Resume resume){
		LogManager.getLogger().debug(resume);
		return resumeService.findResumeInfo(resume);
	}

}