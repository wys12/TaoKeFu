package com.yc.lagou.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.taokefu.entity.Login;
import com.yc.taokefu.entity.User;
import com.yc.taokefu.service.CompanyService;
import com.yc.taokefu.service.LoginService;
import com.yc.taokefu.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserServiceTest {
	
	@Autowired
	private   LoginService  loginServices;
	@Autowired
	private UserService userService;
	@Autowired
	private CompanyService companyService;
	@Test
	public void testLogin() {
		Login user=new Login();
		user.setL_email("123@qq.com");
		user.setL_pwd("a");
		user=loginServices.login(user);
		System.out.println(user);
		assertNotNull(user);
	}

	@Test
	public void testAddUser() {
		Login user=new Login();
		///user.setLr_id(2);
		user.setL_email("123321@qq.com");
		user.setL_pwd("a");
		assertNotNull(loginServices.addUser(user));
	}
	
	@Test
	public void testRegister0() {
		assertNotNull(userService.addUsers(1112, "6661@qq.com"));
	}
	@Test
	public void testRegister1() {
		assertNotNull(companyService.addCompany(1112, "6661@qq.com"));
	}
	
}
