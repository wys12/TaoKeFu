package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.Job;
import com.yc.taokefu.entity.JobClass;
import com.yc.taokefu.entity.PaginationBean;

public interface JobClassService {

	Integer jobClassAdd(JobClass jobClass);

	List<JobClass> jobClassTypeFind(JobClass jobClass);

	List<JobClass> jobClassNameFind(JobClass jobClass);

	PaginationBean<JobClass> jcListPartUsers(String page, String rows);

	boolean BackjcAdd(JobClass jobClass);

	boolean BackJcEdit(JobClass jobClass);

	boolean BackJcDelete(String id);

	List<JobClass> BackJcSearch(JobClass jobClass);

}
