package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.Company;

public interface CompanyService {
	//公司邮箱绑定
	List<Company> addCompany(Integer l_id, String l_email);


}
