package com.yc.taokefu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.taokefu.entity.CompanyAll;

public interface CompanyAllMapper {
	
	List<CompanyAll> findCompanyAllMapper(CompanyAll companyAll,@Param("currPage") Integer currPage,@Param("pageSize") Integer pageSize);

	List<CompanyAll> findJobAllMapper(CompanyAll companyAll);
}
