package com.yc.taokefu.service;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.taokefu.entity.Educationa;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class EducationaServiceTest {
	@Autowired
	private EducationaService educationaService;
	@Test
	public void educationaAdd() {
		Educationa educationa = new Educationa(1061, "清华大学", "计算机编程", "本科", "2017年");
		int result = educationaService.educationaAdd(educationa);
		assertEquals(result, 1);
	}
	@Test
	public void educationaFind() {
		Educationa educationa = new Educationa();
		educationa.setTkf_id(1061);
		LogManager.getLogger().debug(educationaService.educationaFind(educationa));
	}
	

}
