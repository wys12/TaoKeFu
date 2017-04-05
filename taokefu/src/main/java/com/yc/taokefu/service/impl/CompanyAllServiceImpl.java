package com.yc.taokefu.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.mapper.CompanyAllMapper;
import com.yc.taokefu.service.CompanyAllService;
@Service("companyAllService")
public class CompanyAllServiceImpl implements CompanyAllService{
	
	@Autowired //相当配置中的 <property name="userMapper" ref="userMapper"/>
	private CompanyAllMapper companyAllMapper;
	//公司邮箱绑定

	@Override
	public List<CompanyAll> findCompenyName(String string) {
		CompanyAll companyAll = new CompanyAll();
		companyAll.setJob_name(string);
		return companyAllMapper.findCompanyAllMapper(companyAll);
		
	}

	@Override
	public List<CompanyAll> findJobName(String string) {
		CompanyAll companyAll = new CompanyAll();
		companyAll.setJob_name(string);
		return companyAllMapper.findJobAllMapper(companyAll);
	}
	

}
