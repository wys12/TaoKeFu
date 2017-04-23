package com.yc.taokefu.mapper;

import java.util.List;

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

	int jobAdd(Job job);
	
	//职位数据分页
	PaginationBean<Job> listJob(PaginationBean<Job> pb);
	//职位删除
	int deleteJob(Integer id);
	//职位修改
	int editJob(Job job);
	//点击投递简历显示详情
	List<CompanyAll> findCompany(CompanyAll companyAll);
	List<CompanyAll> findCompanyJob(CompanyAll companyAll);
	//多条件查询
	List<Job> search(Job job);

	int insertCompanyJob(CompanyAll comJob);

	List<CompanyAll> findJobEidt(CompanyAll comJob);

	int modifiJobEidts(CompanyAll comJob);

	int modifiJobState(Job job);


	List<CompanyAll> findResumeJob(CompanyAll job);

	//PaginationBean<Job> jObList(PaginationBean<Job> pb);




}
