package com.yc.taokefu.mapper;

import java.util.List;

import com.yc.taokefu.entity.JobClass;
/**
 * 职位类别
 * @author wys
 *
 */
public interface JobClassMapper {

	Integer jobClassAdd(JobClass jobClass);

	List<JobClass> jobClassTypeFind(JobClass jobClass);

}
