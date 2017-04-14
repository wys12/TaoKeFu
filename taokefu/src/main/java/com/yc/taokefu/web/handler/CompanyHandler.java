package com.yc.taokefu.web.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.Login;
import com.yc.taokefu.service.CompanyAllService;
import com.yc.taokefu.service.CompanyService;
import com.yc.taokefu.util.ServletUtil;

@Controller("companyHandler")
@RequestMapping("company")
public class CompanyHandler {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private CompanyAllService companyAllService;
	private String comp_id;

	@RequestMapping(value="sendCompany",method=RequestMethod.POST)
	public void getCompany(String comp_id) {
		this.comp_id=comp_id;
		LogManager.getLogger().debug("公司id === " +comp_id);
	}

	/**
	 * wys
	 * 公司
	 * */
	@RequestMapping("findCompany")
	@ResponseBody //响应Json数据
	public List<CompanyAll> findCompany(CompanyAll company){
		return companyAllService.findCompany(company);
	}
	/**
	 * wys
	 * 公司添加
	 * */
	@RequestMapping(value="insertCompany",method=RequestMethod.POST)
	public String insertCompany(CompanyAll company){
		LogManager.getLogger().debug("companyInfo01 ==> "+company);
		companyAllService.insertCompany(company);
		return "redirect:/companyInfo02.html";
	}
	/**
	 * wys
	 * 公司修改
	 * */
	@RequestMapping(value="modifiCompany",method=RequestMethod.POST)
	@ResponseBody
	public String modifiCompany(CompanyAll company,HttpSession session){
		Login long1 = (Login) session.getAttribute(ServletUtil.LOGIN_USER);
		company.setComp_id(long1.getL_id());;
		LogManager.getLogger().debug("companyInfo01 ==> "+company);
		companyAllService.modifiCompany(company);
		return "1";
	}
	/**
	 * wys
	 * 公司简历加载
	 * */
	@RequestMapping("findCoResume")
	@ResponseBody //响应Json数据
	public List<CompanyAll> findCoResume(CompanyAll company){
		return companyAllService.findCoResume(company);
	}
	/**
	 * wys
	 * 公司简历添加
	 * */
	@RequestMapping("insertCoResume")
	public String insertCoResume(CompanyAll company,HttpSession session){
		Login long1 = (Login) session.getAttribute(ServletUtil.LOGIN_USER);
		company.setC_id(long1.getL_id());
		LogManager.getLogger().debug(company);
		companyAllService.insertCoResume(company);
		return "redirect:/companyInfo05.html";
	}
	/**
	 * wys
	 * 公司简历修改
	 * */
	@RequestMapping("modifiCoResume")
	@ResponseBody //响应Json数据
	public Integer modifiCoResume(CompanyAll company){
		return companyAllService.modifiCoResume(company);
	}
	/**
	 * wys
	 * 公司团队加载
	 * @param company
	 * @return
	 */
	@RequestMapping("findCompany_team")
	@ResponseBody //响应Json数据
	public List<CompanyAll> findCompany_team(CompanyAll company){
		return companyAllService.findCompany_team(company);
	}
	/**
	 * wys
	 * 公司团队加载
	 * @param company
	 * @return
	 */
	@RequestMapping("insertCompany_team")
	public String insertCompany_team(CompanyAll company,HttpSession session){
		Login long1 = (Login) session.getAttribute(ServletUtil.LOGIN_USER);
		company.setC_id(long1.getL_id());
		LogManager.getLogger().debug(company);
		companyAllService.insertCompany_team(company);
		return "redirect:/companyInfo04.html";
	}
	/**
	 * 公司团队修改
	 * wys
	 * @param company
	 * @return
	 */
	@RequestMapping("modifiCompany_team")
	@ResponseBody //响应Json数据
	public Integer modifiCompany_team(CompanyAll company){
		return companyAllService.modifiCompany_team(company);
	}
	
	/**
	 * wys
	 * 职位信息加载
	 * @param company
	 * @return
	 */
	@RequestMapping("findJob")
	@ResponseBody //响应Json数据
	public List<CompanyAll> findJob(CompanyAll company){
		return companyAllService.findJob(company);
	}
	/**
	 * wys
	 * 职位信息添加
	 * @param company
	 * @return
	 */
	@RequestMapping("insertJob")
	@ResponseBody //响应Json数据
	public Integer insertJob(CompanyAll company){
		return companyAllService.insertJob(company);
	}
	/**
	 * wys
	 * 职位信息修改
	 * @param company
	 * @return
	 */
	@RequestMapping("modifiJob")
	@ResponseBody //响应Json数据
	public Integer modifiJob(CompanyAll company){
		return companyAllService.modifiJob(company);
	}
	
	/**
	 * wys
	 * 职位类别
	 * @param company
	 * @return
	 */
	@RequestMapping("findJob_class")
	@ResponseBody //响应Json数据
	public List<CompanyAll> findJob_class(CompanyAll company){
		return companyAllService.findJob_class(company);
	}
	/**
	 * wys
	 * 职位类别
	 * @param company
	 * @return
	 */
	@RequestMapping("insertJob_class")
	@ResponseBody //响应Json数据
	public Integer insertJob_class(CompanyAll company){
		return companyAllService.insertJob_class(company);
	}
	/**
	 * wys
	 * 职位类别
	 * @param company
	 * @return
	 */
	@RequestMapping("modifiJob_class")
	@ResponseBody //响应Json数据
	public Integer modifiJob_class(CompanyAll company){
		return companyAllService.modifiJob_class(company);
	}
}

/**
 * wys
 *标签加载
 * @return
 */
/*@RequestMapping("findTag")
@ResponseBody //响应Json数据
public List<CompanyAll> findTag(CompanyAll company){
	return companyAllService.findTag(company);
}*/
/**
 * wys
 * 标签添加
 * @return
 */
/*@RequestMapping(value="insertTag",method=RequestMethod.POST)
@ResponseBody
public String insertTag(CompanyAll company,HttpSession session){
	Login long1 = (Login) session.getAttribute(ServletUtil.LOGIN_USER);
	company.setC_id(long1.getL_id());
	LogManager.getLogger().debug(company.getTag_name()+"=="+long1.getL_id());
	companyAllService.insertTag(company);
	return "1";
}*/
/**
 * wys
 * 标签修改
 * @return
 */
/*@RequestMapping("modifiTag")
@ResponseBody //响应Json数据
public Integer modifiTag(CompanyAll company){
	return companyAllService.modifiTag(company);
}*/
/**
 * wys
 * 投资机构加载
 * @param company
 * @return
 */
/*@RequestMapping("findInvest")
@ResponseBody //响应Json数据
public List<CompanyAll> findInvest(CompanyAll company){
	return companyAllService.findInvest(company);
}*/
/**
 * wys
 * 投资机构添加
 * @param company
 * @return
 */
/*@RequestMapping("insertInvest")
@ResponseBody //响应Json数据
public Integer insertInvest(CompanyAll company){
	return companyAllService.insertInvest(company);
}*/
/**
 * wys
 * 投资机构修改
 * @param company
 * @return
 */
/*@RequestMapping("modifiInvest")
@ResponseBody //响应Json数据
public Integer modifiInvest(CompanyAll company){
	return companyAllService.modifiInvest(company);
}*/
