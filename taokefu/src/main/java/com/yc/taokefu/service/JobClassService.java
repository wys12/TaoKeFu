package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.JobClass;

public interface JobClassService {

	Integer jobClassAdd(JobClass jobClass);

	List<JobClass> jobClassFind(JobClass jobClass);

	

}
