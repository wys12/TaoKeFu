package com.yc.taokefu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.taokefu.entity.Resume;
import com.yc.taokefu.mapper.ResumeMapper;
import com.yc.taokefu.service.ResumeService;

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
	public int insertResume(Resume resume) {
		return resumeMapper.insertResume(resume);
	}

	@Override
	public int modifiResume(Resume resume) {
		return resumeMapper.modifiResume(resume);
	}

}
