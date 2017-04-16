package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.Company;
import com.yc.taokefu.entity.PaginationBean;

public interface CompanyService {
	//公司邮箱绑定
	List<Company> addCompany(Integer l_id, String l_email);

	PaginationBean<Company> listPartCompanys(String page, String rows);

	boolean BackCompanyAdd(Company company);

	boolean BackCompanyEdit(Company company);

	boolean BackCompanyDelete(String id);

	List<Company> BackCompanysearch(Company company);

	//sCompany findCompany(Company company);


}
