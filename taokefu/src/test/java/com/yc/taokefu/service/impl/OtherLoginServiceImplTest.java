package com.yc.taokefu.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.taokefu.entity.Qqlogin;
import com.yc.taokefu.service.EducationaService;
import com.yc.taokefu.service.OtherLoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class OtherLoginServiceImplTest {

	@Autowired
	private OtherLoginService otherLoginService;
	
	@Test
	public void testFindOpenId() {
		Qqlogin qqlogins = new Qqlogin();
		qqlogins.setOpenId("B74616B0E1E0AB1DA413995D5EE8C101");
		System.out.println(otherLoginService.findOpenId(qqlogins));
	}

}
