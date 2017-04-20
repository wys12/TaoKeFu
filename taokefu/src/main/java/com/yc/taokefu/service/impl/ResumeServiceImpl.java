package com.yc.taokefu.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.taokefu.entity.JobClass;
import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.Resume;
import com.yc.taokefu.entity.UserAll;
import com.yc.taokefu.mapper.ResumeMapper;
import com.yc.taokefu.service.ResumeService;
import com.yc.taokefu.service.UserService;
import com.yc.taokefu.util.ServletUtil;

/**
 * 简历信息wys
 * @author Administrator
 *
 */
@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
	@Autowired
	private ResumeMapper resumeMapper;
	
	
	@Override
	public List<Resume> findResume(Resume resume) {
		return resumeMapper.findResume(resume);
	}


	@Override
	public int modifiResume(UserAll resume) {
		return resumeMapper.modifiResume(resume);
	}

	@Override
	public int modifiResumes(UserAll userAll) {
		return resumeMapper.modifiResumes(userAll);
	}

	@Override
	public List<Resume> findResumes(UserAll user) {
		return resumeMapper.findResumes(user);
		
	}


	@Override
	public int insertResume(UserAll user, UserAll user1, UserAll usResume, UserAll educationa, UserAll experience) {
		int result = resumeMapper.insertResume(user);
		if(user1!=null && !user1.equals("")){
			result = resumeMapper.modifiResumes(user1);
		}
		if(usResume!=null && !usResume.equals("")){
			result = resumeMapper.modifiResumes(usResume);
		}
		if(educationa!=null && !educationa.equals("")){
			result = resumeMapper.modifiResumes(educationa);
		}
		if(experience!=null && !experience.equals("")){
			result = resumeMapper.modifiResumes(experience);
		}
		return result;
	}


	@Override
	public List<Resume> findResumeInfo(Resume resume) {
		return resumeMapper.findResumeInfo(resume);
	}


	@Override
	public PaginationBean<Resume> listPartUsers(String page, String rows) {
		PaginationBean<Resume> pb=new PaginationBean<>();
		if(page != null){
			pb.setCurrPage(Integer.parseInt(page));
		}
		if(rows != null){
			pb.setPageSize(Integer.parseInt(rows));
		}
		return resumeMapper.listJob(pb);
	}

}
