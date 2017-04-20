package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.CompanyAll;

public interface CompanyAllService {

	List<CompanyAll> findCompenyName(String string, Integer currPage, Integer pageSize);
	List<CompanyAll> findJobName(CompanyAll companyAll);


	//查询
	List<CompanyAll> findCompany(CompanyAll company);//公司信息
	List<CompanyAll> findCoResume(CompanyAll company);//公司详情
	List<CompanyAll> findCompany_team(CompanyAll company);//公司团队
	List<CompanyAll> findTag(CompanyAll company);//标签
	List<CompanyAll> findInvest(CompanyAll company);//投资机构
	List<CompanyAll> findJob(CompanyAll company);//职位
	List<CompanyAll> findJob_class(CompanyAll company);//职位类别
	//插入
	Integer insertCompany(CompanyAll company);
	Integer insertCoResume(CompanyAll company);
	Integer insertCompany_team(CompanyAll company);
	Integer insertTag(CompanyAll company);
	Integer insertInvest(CompanyAll company);
	Integer insertJob(CompanyAll company);
	Integer insertJob_class(CompanyAll company);
	//修改
	Integer modifiCompany(CompanyAll company);
	Integer modifiCoResume(CompanyAll company);
	Integer modifiCompany_team(CompanyAll company);
	Integer modifiTag(CompanyAll company);
	Integer modifiInvest(CompanyAll company);
	Integer modifiJob(CompanyAll company);
	Integer modifiJob_class(CompanyAll company);
	List<CompanyAll> findResumeCompany(CompanyAll companyAll);


}
