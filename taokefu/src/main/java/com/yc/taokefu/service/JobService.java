package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.Job;

public interface JobService {
	List<CompanyAll> jobFind(String job);
	
	Integer jobAdd(Job job);
}
