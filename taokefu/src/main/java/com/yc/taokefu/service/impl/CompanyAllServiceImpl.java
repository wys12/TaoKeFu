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
	//查询
	@Override
	public List<CompanyAll> findCompany(CompanyAll company) {
		return companyAllMapper.findCompany(company);
	}
	@Override
	public List<CompanyAll> findCoResume(CompanyAll company) {
		return companyAllMapper.findCoResume(company);
	}
	@Override
	public List<CompanyAll> findCompany_team(CompanyAll company) {
		return companyAllMapper.findCompany_team(company);
	}
	@Override
	public List<CompanyAll> findTag(CompanyAll company) {
		return companyAllMapper.findTag(company);
	}
	@Override
	public List<CompanyAll> findInvest(CompanyAll company) {
		return companyAllMapper.findInvest(company);
	}
	@Override
	public List<CompanyAll> findJob(CompanyAll company) {
		return companyAllMapper.findJob(company);
	}
	@Override
	public List<CompanyAll> findJob_class(CompanyAll company) {
		return companyAllMapper.findJob_class(company);
	}
	
	
	//插入
	@Override
	public Integer insertCompany(CompanyAll company) {
		return companyAllMapper.insertCompany(company);
	}
	@Override
	public Integer insertCoResume(CompanyAll company) {
		return companyAllMapper.insertCoResume(company);
	}
	@Override
	public Integer insertCompany_team(CompanyAll company) {
		return companyAllMapper.insertCompany_team(company);
	}
	@Override
	public Integer insertTag(CompanyAll company) {
		return companyAllMapper.insertTag(company);
	}
	@Override
	public Integer insertInvest(CompanyAll company) {
		return companyAllMapper.insertInvest(company);
	}
	@Override
	public Integer insertJob(CompanyAll company) {
		return companyAllMapper.insertJob(company);
	}
	@Override
	public Integer insertJob_class(CompanyAll company) {
		return companyAllMapper.insertJob_class(company);
	}
	
	//修改
	@Override
	public Integer modifiCompany(CompanyAll company) {
		return companyAllMapper.modifiCompany(company);
	}
	@Override
	public Integer modifiCoResume(CompanyAll company) {
		return companyAllMapper.modifiCoResume(company);
	}
	@Override
	public Integer modifiCompany_team(CompanyAll company) {
		return companyAllMapper.modifiCompany_team(company);
	}
	@Override
	public Integer modifiTag(CompanyAll company) {
		return companyAllMapper.modifiTag(company);
	}
	@Override
	public Integer modifiInvest(CompanyAll company) {
		return companyAllMapper.modifiInvest(company);
	}
	@Override
	public Integer modifiJob(CompanyAll company) {
		return companyAllMapper.modifiJob(company);
	}
	@Override
	public Integer modifiJob_class(CompanyAll company) {
		return companyAllMapper.modifiJob_class(company);
	}
	@Override
	public List<CompanyAll> findResumeCompany(CompanyAll companyAll) {
		return companyAllMapper.findResumeCompany(companyAll);
	}
	
}
