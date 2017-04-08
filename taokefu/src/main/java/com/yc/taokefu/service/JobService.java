package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.Job;
import com.yc.taokefu.entity.PaginationBean;

public interface JobService {
	List<CompanyAll> jobFind(String job);
	
	Integer jobAdd(Job job);
	/**
	 * 职位数据分页
	 * @param page
	 * @param rows
	 * @return
	 */
	PaginationBean<Job> listPartUsers(String page, String rows);
	/**
	 * 职位id
	 * @param id
	 * @return
	 */
	Boolean deleteJob(Integer id);
	/**
	 * 根据job_id修改
	 * @param job
	 * @return
	 */
	Boolean editJob(Job job);

	List<CompanyAll> findCompany(CompanyAll companyAll);

	/**
	 * 多条件查询
	 * @param job
	 * @return
	 */
	List<Job> search(Job job);
}
