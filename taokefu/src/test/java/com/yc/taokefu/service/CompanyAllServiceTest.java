package com.yc.taokefu.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.taokefu.entity.Company;
import com.yc.taokefu.entity.CompanyAll;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CompanyAllServiceTest {
	@Autowired
	CompanyAllService companyAllService;
	@Test
	public void testFindCompenyName() {

	}

	@Test
	public void testFindJobName() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindCompany() {
		CompanyAll company = new CompanyAll();
		company.setComp_id(1002);
		List<CompanyAll> list = companyAllService.findCompany(company);
		System.out.println(list);
	}

	@Test
	public void testFindCoResume() {
		CompanyAll company = new CompanyAll();
		company.setC_id(1001);;
		List<CompanyAll> list = companyAllService.findCoResume(company);
		System.out.println(list);
	}

	@Test
	public void testFindCompany_team() {
		CompanyAll company = new CompanyAll();
		company.setC_id(1001);
		List<CompanyAll> list = companyAllService.findCompany_team(company);
		System.out.println(list);
	}

	@Test
	public void testFindTag() {
		CompanyAll company = new CompanyAll();
		company.setC_id(1001);;
		List<CompanyAll> list = companyAllService.findTag(company);
		System.out.println(list);
	}

	@Test
	public void testFindInvest() {
		CompanyAll company = new CompanyAll();
		company.setC_id(1001);;
		List<CompanyAll> list = companyAllService.findInvest(company);
		System.out.println(list);
	}

	@Test
	public void testFindJob() {
		CompanyAll company = new CompanyAll();
		company.setC_id(1001);
		List<CompanyAll> list = companyAllService.findJob(company);
		System.out.println(list);
	}

	@Test
	public void testFindJob_class() {
		CompanyAll company = new CompanyAll();
		company.setJc_name("客服");
		List<CompanyAll> list = companyAllService.findJob_class(company);
		System.out.println(list);
	}

	/*************************公司信息插入*************************/

	@Test
	public void testInsertCompany() {
		CompanyAll company = new CompanyAll();
		company.setComp_name("阿里巴巴");
		company.setComp_email("666888@qq.com");
		company.setComp_link("http://p4psearch.1688.com/");
		company.setComp_attestation("-0");
		int result = companyAllService.insertCompany(company);
		System.out.println(result);
	}

	@Test
	public void testInsertCoResume() {
		CompanyAll company = new CompanyAll();
		company.setC_id(1002);
		company.setPro_name("阿里巴巴公司详情");
		int result = companyAllService.insertCoResume(company);
		System.out.println(result);
	}

	@Test
	public void testInsertCompany_team() {
		CompanyAll company = new CompanyAll();
		company.setC_id(1002);
		company.setCt_name("阿里巴巴团队");
		int result = companyAllService.insertCompany_team(company);
		System.out.println(result);
	}

	@Test
	public void testInsertTag() {
		CompanyAll company = new CompanyAll();
		company.setC_id(1002);
		company.setTag_name("周末双休");
		int result = companyAllService.insertTag(company);
		System.out.println(result);
	}

	@Test
	public void testInsertInvest() {
		CompanyAll company = new CompanyAll();
		company.setC_id(1002);
		company.setInv_name("百度");
		company.setInv_state("上市B轮");
		int result = companyAllService.insertInvest(company);
		System.out.println(result);
	}

	@Test
	public void testInsertJob() {
		CompanyAll company = new CompanyAll();
		company.setC_id(1002);
		company.setJob_name("阿里巴巴客服");
		company.setJob_max_salary("6k");
		company.setJob_max_salary("4k");
		int result = companyAllService.insertJob(company);
		System.out.println(result);
	}

	@Test
	public void testInsertJob_class() {
		CompanyAll company = new CompanyAll();
		company.setJc_name("客服");
		int result = companyAllService.insertJob_class(company);
		System.out.println(result);
	}
	/**********************公司信息修改  未测试**************************************/
	@Test
	public void testModifiCompany() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifiCoResume() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifiCompany_team() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifiTag() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifiInvest() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifiJob() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifiJob_class() {
		fail("Not yet implemented");
	}

}
