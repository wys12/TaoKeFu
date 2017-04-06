package com.yc.taokefu.mapper;

import java.util.List;

import com.yc.taokefu.entity.Company;
import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.Job;
import com.yc.taokefu.entity.PaginationBean;
/**
 * 职位信息
 * @author wys
 *
 */
public interface JobMapper {

	List<CompanyAll> jobFind(CompanyAll job);

	Integer jobAdd(Job job);
	
	PaginationBean<Job> listJob(PaginationBean<Job> pb);
	
	List<CompanyAll> findCompany(CompanyAll companyAll);//点击投递简历显示详情

}
