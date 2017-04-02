package com.yc.taokefu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.taokefu.entity.Company;
import com.yc.taokefu.mapper.CompanyMapper;
import com.yc.taokefu.service.CompanyService;
@Service("companyService")
public class CompanyServiceImpl implements CompanyService{
	@Autowired //相当配置中的 <property name="userMapper" ref="userMapper"/>
	private CompanyMapper companyMapper;
	//公司邮箱绑定
	@Override
	public List<Company> addCompany(Integer l_id, String l_email) {
		return companyMapper.addcompany(l_id,l_email);
	}

}
