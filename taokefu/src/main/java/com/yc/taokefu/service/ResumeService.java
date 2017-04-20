package com.yc.taokefu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.Resume;
import com.yc.taokefu.entity.UserAll;

/**
 * 简历信息wys
 * @author Administrator
 *
 */
public interface ResumeService {
	List<Resume> findResume(Resume resume);
	
	int modifiResumes(UserAll resume);
	
	int modifiResume(UserAll resume);

	List<Resume> findResumes(UserAll user);

	int insertResume(UserAll user, UserAll user1, UserAll usResume, UserAll educationa, UserAll experience);

	List<Resume> findResumeInfo(Resume resume);

	PaginationBean<Resume> listPartUsers(String page, String rows);
}
