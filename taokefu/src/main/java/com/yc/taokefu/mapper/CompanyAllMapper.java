package com.yc.taokefu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.taokefu.entity.CompanyAll;

public interface CompanyAllMapper {
	

	List<CompanyAll> findCompanyAllMapper(CompanyAll companyAll);
	//List<CompanyAll> findCompanyAllMapper(CompanyAll companyAll,@Param("currPage") Integer currPage,@Param("pageSize") Integer pageSize);
	List<CompanyAll> findJobCompany(CompanyAll companyAll);
	List<CompanyAll> findJobAllMapper(CompanyAll companyAll);

	
	//查询
	List<CompanyAll> findCompany(CompanyAll company);
	List<CompanyAll> findCoResume(CompanyAll company);
	List<CompanyAll> findCompany_team(CompanyAll company);
	List<CompanyAll> findTag(CompanyAll company);
	List<CompanyAll> findInvest(CompanyAll company);
	List<CompanyAll> findJob(CompanyAll company);
	List<CompanyAll> findJob_class(CompanyAll company);
	
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

	List<CompanyAll> findRange(CompanyAll companyAll);
	void modifiAttestation(CompanyAll companyAll);

}
