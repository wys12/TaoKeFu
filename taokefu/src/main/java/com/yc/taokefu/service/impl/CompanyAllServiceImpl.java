package com.yc.taokefu.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
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
	
	/**
	 * wys
	 * @param string
	 * @return
	 */
	@Override
	public List<CompanyAll> findCompenyName(String string, Integer currPage, Integer pageSize) {
		CompanyAll companyAll = new CompanyAll();
		companyAll.setJob_name(string);
		return companyAllMapper.findCompanyAllMapper(companyAll, currPage, pageSize);
	}
	/**
	 * wys
	 * @param string
	 * @return
	 */
	@Override
	public List<CompanyAll> findJobName(CompanyAll companyAll) {
		LogManager.getLogger().debug("companyAll   ==> " + companyAll);
		//return pageNumber(companyAllMapper.findJobAllMapper(companyAll),currPage,pageSize);
		return companyAllMapper.findJobAllMapper(companyAll);
	}
	
	public List<CompanyAll> pageNumber(List<CompanyAll> list,Integer currPage, Integer pageSize){
		int size = list.size();
		LogManager.getLogger().debug("list  ==> " + list+size);
		for(int i=0;i<size;i++){
			LogManager.getLogger().debug("list.get(i)  ==> " + list.get(i));
		}
		return list;
	}
	
}
