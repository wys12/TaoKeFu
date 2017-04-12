package com.yc.taokefu.service.impl;

import java.util.Random;
import java.util.ResourceBundle;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.yc.taokefu.entity.Admin;
import com.yc.taokefu.mapper.AdminMapper;
import com.yc.taokefu.service.AdminService;
import com.yc.taokefu.util.ServletUtil;

@Service("adminService")
public class AdminServiceImpl  implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private  JavaMailSender mailSender;

	@Override
	public Admin login(Admin admin) {
		return adminMapper.findAdmin(admin);
	}

	/**
	 * 更具邮箱找回密码
	 */
	@Override
	public Boolean findAdminPwd(Admin admin) {
		//校验用户名与邮箱
		if(adminMapper.searchAdmin(admin)!=null){
			admin=adminMapper.searchAdmin(admin);
			//发送邮件
			try {
				ServletUtil.CODE= random();
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true);
				helper.setFrom(ResourceBundle.getBundle("data").getString("mail.smtp.from"));
				helper.setTo(admin.getAd_email());
				helper.setSubject("验证码为");
				helper.setText(String.valueOf(ServletUtil.CODE));
				mailSender.send(message);
				return true;
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public static int random() {
		Random rd = new Random();
		int random=0;
		for(int i =0;i<10;i++){
			random = rd.nextInt(999999);
			if(random>100000)return random;
			else i--;
		}
		return 0;
	}

	@Override
	public Integer modifiAdminPwd(Admin admin) {
		return adminMapper.modifiAdminPwd(admin);
	}
}
