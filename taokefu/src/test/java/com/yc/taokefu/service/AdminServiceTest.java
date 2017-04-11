package com.yc.taokefu.service;

import java.util.Random;
import java.util.ResourceBundle;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.taokefu.entity.Admin;
import com.yc.taokefu.mapper.AdminMapper;
import com.yc.taokefu.util.ServletUtil;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AdminServiceTest {

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private  JavaMailSender mailSender;


	@Test
	public void testFindAdminPwd() {
		Admin admin=new Admin();
		admin.setAd_email("1441605117@qq.com");
		admin.setAd_name("admin");
		if(adminMapper.searchAdmin(admin)!=null){
			admin=adminMapper.searchAdmin(admin);
			//发送邮件
			try {
				ServletUtil.CODE= random();
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true);
				helper.setFrom(ResourceBundle.getBundle("data").getString("mail.smtp.from"));
				helper.setTo(admin.getAd_email());
				helper.setSubject("忘记密码");
				System.out.println(admin.getAd_email());
				System.out.println(admin.getAd_pwd());
				helper.setText(String.valueOf(ServletUtil.CODE));
				mailSender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}
	/*	public static void main(String[] args) {
		random();
	}*/
	private static int random() {
		Random rd = new Random();
		int random=0;
		for(int i =0;i<10;i++){
			random = rd.nextInt(999999);
			if(random>100000)return random;
			else i--;
		}
		return 0;
	}
}
