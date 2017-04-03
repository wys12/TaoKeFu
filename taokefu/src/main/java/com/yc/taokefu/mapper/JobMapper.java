package com.yc.taokefu.mapper;

import java.util.List;

import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.Job;
/**
 * 职位信息
 * @author wys
 *
 */
public interface JobMapper {

	List<CompanyAll> jobFind(CompanyAll job);

	Integer jobAdd(Job job);

}
