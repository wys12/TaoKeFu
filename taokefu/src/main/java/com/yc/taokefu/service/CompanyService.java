package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.Company;
import com.yc.taokefu.entity.CompanyTeam;
import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.Product;

public interface CompanyService {
	//公司邮箱绑定
	List<Company> addCompany(Integer l_id, String l_email);

	PaginationBean<Company> listPartCompanys(String page, String rows);

	boolean BackCompanyAdd(Company company);

	boolean BackCompanyEdit(Company company);

	boolean BackCompanyDelete(String id);

	List<Company> BackCompanysearch(Company company);

	List<Product> BackCompanyDatail(Product product);

	boolean BackCompanyEditCor(Product product);

	List<CompanyTeam> BackcompanyTeam(CompanyTeam companyTeam);

	boolean BackCompanyEditCt(CompanyTeam companyTeam);

	boolean BackCompanyEditCtAdd(CompanyTeam companyTeam);

	boolean BackCompanyEditCorAdd(Product product);

	//sCompany findCompany(Company company);


}
