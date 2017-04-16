package com.yc.taokefu.service;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.taokefu.entity.UserAll;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ResumeServiceTest {
	@Autowired
	ResumeService resumeService;
	@Test
	public void test() {
		UserAll suAll = new UserAll();
		HttpSession session = null;
		suAll.setC_id(1001);
		suAll.setTkf_id(1001);
		LogManager.getLogger().debug("suAll == "+suAll);
		int result = resumeService.insertResume(suAll,suAll,suAll,suAll,suAll);
		LogManager.getLogger().debug("result == "+result);
	}
	@Test
	public void test01() {
		UserAll suAll = new UserAll();
		suAll.setC_id(1001);
		suAll.setUs_name("ssss");
		LogManager.getLogger().debug("suAll == "+suAll);
		int result = resumeService.modifiResumes(suAll);
		LogManager.getLogger().debug("result == "+result);
	}

}
