package com.yc.taokefu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.taokefu.entity.Company;
import com.yc.taokefu.entity.PaginationBean;

public interface CompanyMapper {
	
	//Company addcompany(Integer l_id, String l_email);
	List<Company> addcompany(@Param("comp_id") Integer comp_id,@Param("comp_email") String comp_email);

	PaginationBean<Company> findPartCompanys(PaginationBean<Company> pb);

	int BackCompanyAdd(Company company);

	int BackCompanyEdit(Company company);

	int BackCompanyDelete(String id);

	List<Company> BackCompanysearch(Company company);

	//Company findCompany(Company company);


}
