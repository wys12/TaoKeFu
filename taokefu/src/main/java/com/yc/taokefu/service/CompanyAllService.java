package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.PaginationBean;

public interface CompanyAllService {

	List<CompanyAll> findCompenyName(String string, Integer currPage, Integer pageSize);

	List<CompanyAll> findJobName(CompanyAll companyAll,Integer currPage, Integer pageSize);
	
	
}
