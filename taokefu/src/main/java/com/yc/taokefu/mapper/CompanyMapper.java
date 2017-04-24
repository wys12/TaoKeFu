package com.yc.taokefu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.taokefu.entity.Company;
import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.CompanyTeam;
import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.Product;

public interface CompanyMapper {
	
	//Company addcompany(Integer l_id, String l_email);
	List<Company> addcompany(@Param("comp_id") Integer comp_id,@Param("comp_email") String comp_email);

	PaginationBean<Company> findPartCompanys(PaginationBean<Company> pb);

	int BackCompanyAdd(Company company);

	int BackCompanyEdit(Company company);

	int BackCompanyDelete(String id);

	List<Company> BackCompanysearch(Company company);

	List<Product> BackCompanyDatail(Product product);

	int BackCompanyEditCor(Product product);

	List<CompanyTeam> BackcompanyTeam(CompanyTeam companyTeam);

	int BackCompanyEditCt(CompanyTeam companyTeam);

	int BackCompanyEditCtAdd(CompanyTeam companyTeam);

	int BackCompanyEditCorAdd(Product product);

	List<CompanyAll> findAllCompany(CompanyAll company);
}
