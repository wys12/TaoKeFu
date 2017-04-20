package com.yc.taokefu.mapper;

import java.util.List;

import com.yc.taokefu.entity.Job;
import com.yc.taokefu.entity.JobClass;
import com.yc.taokefu.entity.PaginationBean;
/**
 * 职位类别
 * @author wys
 *
 */
public interface JobClassMapper {

	Integer jobClassAdd(JobClass jobClass);

	List<JobClass> jobClassTypeFind(JobClass jobClass);

	List<JobClass> jobClassNameFind(JobClass jobClass);

	PaginationBean<JobClass> jcListJob(PaginationBean<JobClass> pb);

	int BackjcAdd(JobClass jobClass);

	int BackJcEdit(JobClass jobClass);

	int BackJcDelete(String id);

	List<JobClass> BackJcSearch(JobClass jobClass);

}
