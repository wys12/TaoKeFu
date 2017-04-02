package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.Job;

public interface JobService {
	List<Job> jobFind(Job job);
	
	Integer jobAdd(Job job);
}
