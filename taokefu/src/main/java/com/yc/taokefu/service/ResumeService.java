package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.Resume;

/**
 * 简历信息wys
 * @author Administrator
 *
 */
public interface ResumeService {
	List<Resume> findResume(Resume resume);
	
	int insertResume(Resume resume);
	
	int modifiResume(Resume resume);
}
