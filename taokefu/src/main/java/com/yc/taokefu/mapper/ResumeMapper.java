package com.yc.taokefu.mapper;

import java.util.List;

import com.yc.taokefu.entity.Resume;

/**
 * 简历信息wys
 * @author Administrator
 *
 */
public interface ResumeMapper {
	List<Resume> findResume(Resume resume);
	
	int insertResume(Resume resume);
	
	int modifiResume(Resume resume);
}
