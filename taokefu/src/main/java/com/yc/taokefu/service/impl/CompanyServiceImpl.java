package com.yc.taokefu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.taokefu.entity.Company;
import com.yc.taokefu.entity.CompanyTeam;
import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.Product;
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
/*	@Override
	public Company findCompany(Company company) {
		return companyMapper.findCompany(company);
	}*/
	@Override
	public PaginationBean<Company> listPartCompanys(String page, String rows) {
		PaginationBean<Company> pb=new PaginationBean<>();
		if(page != null){
			pb.setCurrPage(Integer.parseInt(page));
		}
		if(rows != null){
			pb.setPageSize(Integer.parseInt(rows));
		}

		return companyMapper.findPartCompanys(pb);
	}
	@Override
	public boolean BackCompanyAdd(Company company) {
		return companyMapper.BackCompanyAdd(company)>0;
	}
	@Override
	public boolean BackCompanyEdit(Company company) {
		return companyMapper.BackCompanyEdit(company)>0;
	}
	@Override
	public boolean BackCompanyDelete(String id) {
		return companyMapper.BackCompanyDelete(id)>0;
	}
	@Override
	public List<Company> BackCompanysearch(Company company) {
		return companyMapper.BackCompanysearch(company);
	}
	@Override
	public List<Product> BackCompanyDatail(Product product) {
		return companyMapper.BackCompanyDatail(product);
	}
	@Override
	public boolean BackCompanyEditCor(Product product) {
		return companyMapper.BackCompanyEditCor(product)>0;
	}
	@Override
	public List<CompanyTeam> BackcompanyTeam(CompanyTeam companyTeam) {
		return companyMapper.BackcompanyTeam(companyTeam);
	}
	@Override
	public boolean BackCompanyEditCt(CompanyTeam companyTeam) {
		return companyMapper.BackCompanyEditCt(companyTeam)>0;
	}
	@Override
	public boolean BackCompanyEditCtAdd(CompanyTeam companyTeam) {
		return companyMapper.BackCompanyEditCtAdd(companyTeam)>0;
	}
	@Override
	public boolean BackCompanyEditCorAdd(Product product) {
		return companyMapper.BackCompanyEditCorAdd(product)>0;
	}

}
