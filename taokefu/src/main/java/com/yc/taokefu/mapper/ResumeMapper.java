package com.yc.taokefu.mapper;

import java.util.List;

import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.Resume;
import com.yc.taokefu.entity.UserAll;

/**
 * 简历信息wys
 * @author Administrator
 *
 */
public interface ResumeMapper {
	List<Resume> findResume(Resume resume);
	
	int insertResume(UserAll resume);
	
	int modifiResume(UserAll resume);

	int modifiResumes(UserAll resume);

	List<Resume> findResumes(UserAll user);

	List<Resume> findResumeInfo(Resume resume);

	int modifiResumeState(Resume resume);

	int deleteResumeState(Resume resume);

	List<Resume> findUserResume(Resume resume);
	PaginationBean<Resume> listJob(PaginationBean<Resume> pb);
}
