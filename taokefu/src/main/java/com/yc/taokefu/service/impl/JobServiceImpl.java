package com.yc.taokefu.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.Job;
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
	public List<CompanyAll> jobFind(String jobName) {
		CompanyAll companyAll = new CompanyAll();
		companyAll.setJob_name(jobName);
		LogManager.getLogger().debug("companyAll === >"+companyAll);
		return jobMapper.jobFind(companyAll);
	}
}
