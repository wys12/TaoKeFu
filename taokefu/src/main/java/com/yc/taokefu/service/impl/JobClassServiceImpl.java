package com.yc.taokefu.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.taokefu.entity.Job;
import com.yc.taokefu.entity.JobClass;
import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.mapper.JobClassMapper;
import com.yc.taokefu.service.JobClassService;

@Service("jobClassService")
public class JobClassServiceImpl implements JobClassService{
	@Autowired
	private JobClassMapper jobClssMapper;
	@Override
	public List<JobClass> jobClassTypeFind(JobClass jobClass) {
		//LogManager.getLogger().debug("jobClass   ==> " + jobClass);
		return jobClssMapper.jobClassTypeFind(jobClass);
	}
	@Override
	public Integer jobClassAdd(JobClass jobClass) {
		return jobClssMapper.jobClassAdd(jobClass);
	}
	@Override
	public List<JobClass> jobClassNameFind(JobClass jobClass) {
		return jobClssMapper.jobClassNameFind(jobClass);

	}
	@Override
	public PaginationBean<JobClass> jcListPartUsers(String page, String rows) {
		PaginationBean<JobClass> pb=new PaginationBean<>();
		if(page != null){
			pb.setCurrPage(Integer.parseInt(page));
		}
		if(rows != null){
			pb.setPageSize(Integer.parseInt(rows));
		}
		return jobClssMapper.jcListJob(pb);
	}
	@Override
	public boolean BackjcAdd(JobClass jobClass) {
		return jobClssMapper.BackjcAdd(jobClass)>0;
	}
	@Override
	public boolean BackJcEdit(JobClass jobClass) {
		return jobClssMapper.BackJcEdit(jobClass)>0;
	}
	@Override
	public boolean BackJcDelete(String id) {
		return jobClssMapper.BackJcDelete(id)>0;
	}
	@Override
	public List<JobClass> BackJcSearch(JobClass jobClass) {
		return jobClssMapper.BackJcSearch(jobClass);
	}

}
