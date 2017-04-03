package com.yc.taokefu.web.handler;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.Company;
import com.yc.taokefu.service.CompanyService;

@Controller("companyHandler")
@RequestMapping("company")
public class CompanyHandler {
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value="findCompany",method=RequestMethod.POST)
	@ResponseBody
	public Company findCompany(Company company) {
		LogManager.getLogger().debug("查找公司   === " +company);
		return company;
	}
}
