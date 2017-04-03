package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.Job;
import com.yc.taokefu.entity.PaginationBean;

public interface JobService {
	List<Job> jobFind(String job);
	
	Integer jobAdd(Job job);

	PaginationBean<Job> listPartUsers(String page, String rows);
}
