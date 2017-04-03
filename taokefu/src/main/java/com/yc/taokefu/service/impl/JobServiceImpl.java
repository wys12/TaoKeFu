package com.yc.taokefu.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.taokefu.entity.Job;
import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.mapper.JobMapper;
import com.yc.taokefu.service.JobService;

@Service("jobService")
public class JobServiceImpl implements JobService{
	@Autowired
	private JobMapper jobMapper;
	
	@Override
	public Integer jobAdd(Job job) {
		return jobMapper.jobAdd(job);
	}
	@Override
	public List<Job> jobFind(String jobName) {
		Job job = new Job();
		job.setJob_name(jobName);
		LogManager.getLogger().debug("job === >"+job);
		return jobMapper.jobFind(job);
	}
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
}
