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
	@Test
	public void testFindUsResume() {
		UserAll user = new UserAll();
		user.setUsr_id(1001);;
		System.out.println(user);
		List<UserAll> list = UserService.findUsResume(user);
		System.out.println(list);
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
	public void testFindSucceed() {
		UserAll user = new UserAll();
		user.setSuc_id(1001);
		System.out.println(user);
		List<UserAll> list = UserService.findSucceed(user);
		System.out.println(list);
	}

	@Test
	public void testFindExperience() {
		UserAll user = new UserAll();
		user.setExp_id(1001);;
		System.out.println(user);
		List<UserAll> list = UserService.findExperience(user);
		System.out.println(list);
	}

	@Test
	public void testFindEducationa() {
		UserAll user = new UserAll();
		user.setEdu_id(1001);;;
		System.out.println(user);
		List<UserAll> list = UserService.findEducationa(user);
		System.out.println(list);
	}

	@Test
	public void testFindCollect() {
		UserAll user = new UserAll();
		user.setCol_id(1001);;;
		System.out.println(user);
		List<UserAll> list = UserService.findCollect(user);
		System.out.println(list);
	}

	@Test
	public void testFindTake() {
		UserAll user = new UserAll();
		user.setTak_id(1001);;;
		System.out.println(user);
		List<UserAll> list = UserService.findTake(user);
		System.out.println(list);
	}


	
	@Test
	public void testInsertSucceed() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertExperience() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertEducationa() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertCollect() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertTake() {
		fail("Not yet implemented");
	}

	

	@Test
	public void testModifiUsResume() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifiSucceed() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifiExperience() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifiEducationa() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifiCollect() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifiTake() {
		fail("Not yet implemented");
	}

}
