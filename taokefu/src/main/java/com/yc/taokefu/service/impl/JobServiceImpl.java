package com.yc.taokefu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.Job;
import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.mapper.JobMapper;
import com.yc.taokefu.service.JobService;

@Service("jobService")
public class JobServiceImpl implements JobService{
	@Autowired
	private JobMapper jobMapper;

	/**
	 * wys
	 */
	@Override
	public Integer jobAdd(Job job) {
		return jobMapper.jobAdd(job);
	}
	/**
	 * wys
	 */
	@Override
	public List<CompanyAll> jobFind(String jobName) {
		CompanyAll companyAll = new CompanyAll();
		companyAll.setJob_name(jobName);
		LogManager.getLogger().debug("companyAll === >"+companyAll);
		return jobMapper.jobFind(companyAll);
	}

	/**
	 * 职位数据分页
	 */
	@Override
	public PaginationBean<Job> listPartUsers(String page, String rows) {
		PaginationBean<Job> pb=new PaginationBean<>();
		if(page != null){
			pb.setCurrPage(Integer.parseInt(page));
		}
		if(rows != null){
			pb.setPageSize(Integer.parseInt(rows));
		}
		return jobMapper.listJob(pb);
	}

	/**
	 * 根据id删除job
	 */
	@Override
	public Boolean deleteJob(Integer id) {

		return jobMapper.deleteJob(id)>0;
	}
	/**
	 * 根据job_id修改
	 * @param job
	 * @return
	 */
	@Override
	public Boolean editJob(Job job) {

		return jobMapper.editJob(job)>0;
	}
	@Override
	public List<CompanyAll> findCompany(CompanyAll companyAll) {
		LogManager.getLogger().debug("companyAll === >"+companyAll);
		return jobMapper.findCompany(companyAll);
	}
	/**
	 * 多条件查询
	 */
	@Override
	public  List<Job> search(Job job) {
		return jobMapper.search(job);
	}
	@Override
	public List<CompanyAll> findCompanyJob(CompanyAll comJob) {
		return jobMapper.findCompanyJob(comJob);
	}
}
