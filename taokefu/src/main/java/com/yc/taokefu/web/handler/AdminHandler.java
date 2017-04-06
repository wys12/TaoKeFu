package com.yc.taokefu.web.handler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.taokefu.entity.Admin;
import com.yc.taokefu.service.AdminService;
import com.yc.taokefu.util.ServletUtil;

@Controller("adminHandler")
@RequestMapping("admin")
public class AdminHandler {
	
	
	@Autowired
	private  AdminService adminService;
	
	@RequestMapping("login")
	public String login(Admin  admin ,HttpSession session){
		admin=adminService.login(admin);
		System.out.println("login:admin==>"+admin);
		if(admin == null){
			session.setAttribute(ServletUtil.ERROR_MESSAGE,"用户名或密码错误!!!!");
			return "/back/login.jsp"; //转发处理
		}else{
			return "redirect:/back/manage.jsp"; //重定向
		}
	}
}
