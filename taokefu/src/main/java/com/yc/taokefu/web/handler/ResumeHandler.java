package com.yc.taokefu.web.handler;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.Resume;
import com.yc.taokefu.entity.UserAll;
import com.yc.taokefu.service.ResumeService;

@Controller("resumeHandler")
@RequestMapping("resume")
public class ResumeHandler {
	
	@Autowired
	private  ResumeService resumeService;
	
	@RequestMapping(value="insertResume",method=RequestMethod.POST)
	@ResponseBody
	public int insertResume(UserAll user){
		LogManager.getLogger().debug(user);
		return 0;
	}
	@RequestMapping(value="modifiResume",method=RequestMethod.POST)
	@ResponseBody
	public int modifiResume(UserAll user){
		LogManager.getLogger().debug(user);
		return 0;
	}
	@RequestMapping(value="findResume",method=RequestMethod.POST)
	@ResponseBody
	public List<Resume> findResume(UserAll user){
		LogManager.getLogger().debug(user);
		return null;
	}
	
}