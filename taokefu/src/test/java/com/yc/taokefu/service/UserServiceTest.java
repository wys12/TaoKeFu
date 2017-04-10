package com.yc.taokefu.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.taokefu.entity.User;
import com.yc.taokefu.entity.UserAll;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserServiceTest {
	@Autowired
	private UserService UserService;

	/*-------------------用户信息-----------------------------*/
	@Test
	public void testFindUser() {
		UserAll user = new UserAll();
		user.setUs_id(1004);
		System.out.println(user);
		List<UserAll> list = UserService.findUser(user);
		System.out.println(list);
	}
	@Test
	public void testInsertUser() {
		UserAll user = new UserAll();
		user.setUs_name("李四");
		user.setUs_email("112233@qq.com");
		System.out.println(user);
		Integer list = UserService.insertUser(user);
		System.out.println(list);
	}
	
	@Test
	public void testModifiUser() {
		UserAll user = new UserAll();
		user.setUs_name("小米");
		user.setUs_email("123@qq.com");
		System.out.println(user);
		Integer list = UserService.modifiUser(user);
		System.out.println(list);
	}
	
	/*-----------------简历信息-------------------------------*/
	@Test
	public void testFindUsResume() {
		UserAll user = new UserAll();
		user.setUsr_id(1001);;
		System.out.println(user);
		List<UserAll> list = UserService.findUsResume(user);
		System.out.println(list.get(0).getUsr_id()+list.get(0).getUsr_name()+list.get(0).getUsr_state());
	}
	
	@Test
	public void testInsertUsResume() {
		UserAll user = new UserAll();
		user.setUsr_name("简历");
		System.out.println(user);
		Integer list = UserService.insertUsResume(user);
		System.out.println(list);
	}
	@Test
	public void testModifiUsResume() {
		UserAll user = new UserAll();
		user.setUsr_id(1001);
		user.setUsr_name("简历修改");
		System.out.println(user);
		Integer list = UserService.modifiUsResume(user);
		System.out.println(list);
	}
	
	
	/*---------------------作品展示---------------------------*/
	
	@Test
	public void testFindSucceed() {
		UserAll user = new UserAll();
		user.setTkf_id(1001);
		System.out.println(user);
		List<UserAll> list = UserService.findSucceed(user);
		System.out.println(list);
	}
	@Test
	public void testInsertSucceed() {
		UserAll user = new UserAll();
		user.setTkf_id(1001);
		user.setSuc_name("百度搜索");
		user.setSuc_link("www.baidu.com");
		System.out.println(user);
		Integer list = UserService.insertSucceed(user);
		System.out.println(list);
	}
	@Test
	public void testModifiSucceed() {
		UserAll user = new UserAll();
		user.setTkf_id(1001);
		user.setSuc_name("百度搜索修改");
		user.setSuc_link("http://www.baidu.com");;
		System.out.println(user);
		Integer list = UserService.modifiSucceed(user);
		System.out.println(list);
	}
	/*------------------工作经历------------------------------*/
	@Test
	public void testFindExperience() {
		UserAll user = new UserAll();
		user.setTkf_id(1001);;
		System.out.println(user);
		List<UserAll> list = UserService.findExperience(user);
		System.out.println(list);
	}
	
	@Test
	public void testInsertExperience() {
		UserAll user = new UserAll();
		user.setTkf_id(1001);
		user.setExp_company_name("百度公司");
		user.setExp_job_name("CEO");
		user.setExp_start_year("2017-1-1");
		user.setExp_end_year("2017-3-1");
		System.out.println(user);
		Integer list = UserService.insertExperience(user);
		System.out.println(list);
	}
	
	@Test
	public void testModifiExperience() {
		UserAll user = new UserAll();
		user.setTkf_id(1001);
		user.setExp_company_name("百度公司修改");
		user.setExp_job_name("CEO修改");
		user.setExp_start_year("2017-1-1");
		user.setExp_end_year("2017-3-3");
		System.out.println(user);
		Integer list = UserService.modifiExperience(user);
		System.out.println(list);
	}

	/*--------------------学历教育----------------------------*/
	@Test
	public void testFindEducationa() {
		UserAll user = new UserAll();
		user.setTkf_id(1001);
		System.out.println(user);
		List<UserAll> list = UserService.findEducationa(user);
		System.out.println(list.get(0).getEdu_shool_name());
	}
	
	@Test
	public void testInsertEducationa() {
		UserAll user = new UserAll();
		user.setTkf_id(1001);
		user.setEdu_shool_name("湖南师范学院");
		System.out.println(user);
		Integer list = UserService.insertEducationa(user);
		System.out.println(list);
	}
	@Test
	public void testModifiEducationa() {
		UserAll user = new UserAll();
		user.setTkf_id(1001);
		user.setEdu_shool_name("湖南师范学院修改");
		System.out.println(user);
		Integer list = UserService.modifiEducationa(user);
		System.out.println(list);
	}

	/*--------------------收藏信息----------------------------*/
	@Test
	public void testFindCollect() {
		UserAll user = new UserAll();
		user.setTkf_id(1001);
		System.out.println(user);
		List<UserAll> list = UserService.findCollect(user);
		System.out.println(list);
	}
	@Test
	public void testInsertCollect() {
		UserAll user = new UserAll();
		user.setTkf_id(1001);
		user.setCol_job_id(1001);
		System.out.println(user);
		Integer list = UserService.insertCollect(user);
		System.out.println(list);
	}
	@Test
	public void testModifiCollect() {
		fail("Not yet implemented");
	}

	/*---------------------订阅信息---------------------------*/
	@Test
	public void testFindTake() {
		UserAll user = new UserAll();
		user.setTak_id(1001);;;
		System.out.println(user);
		List<UserAll> list = UserService.findTake(user);
		System.out.println(list);
	}
	@Test
	public void testInsertTake() {
		fail("Not yet implemented");
	}
	@Test
	public void testModifiTake() {
		fail("Not yet implemented");
	}
}
