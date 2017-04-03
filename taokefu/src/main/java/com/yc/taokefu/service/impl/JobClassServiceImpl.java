package com.yc.taokefu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.taokefu.entity.JobClass;
import com.yc.taokefu.mapper.JobClassMapper;
import com.yc.taokefu.service.JobClassService;

@Service("jobClassService")
public class JobClassServiceImpl implements JobClassService{
	@Autowired
	private JobClassMapper jobClssMapper;
	@Override
	public List<JobClass> jobClassFind(JobClass jobClass) {
		return jobClssMapper.jobClassFind(jobClass);
	}
	@Override
	public Integer jobClassAdd(JobClass jobClass) {
		return jobClssMapper.jobClassAdd(jobClass);
	}

}
