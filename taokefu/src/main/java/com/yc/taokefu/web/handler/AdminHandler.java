package com.yc.taokefu.web.handler;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.Admin;
import com.yc.taokefu.service.AdminService;
import com.yc.taokefu.util.ServletUtil;

@Controller("adminHandler")
@RequestMapping("admin")
public class AdminHandler {
	
	
	@Autowired
	private  AdminService adminService;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(Admin admin ,HttpSession session){
		admin=adminService.login(admin);
		LogManager.getLogger().debug("管理员登录===》admin"+admin);
		if(admin == null){
			session.setAttribute(ServletUtil.ERROR_MESSAGE,"用户名或密码错误!!!!");
			return "adminLogin.jsp"; //转发处理
		}else{
			session.setAttribute(ServletUtil.LOGIN_ADMIN, admin);
			return "redirect:/manage.html"; //重定向
		}
	}
	@RequestMapping(value="sendEmail",method=RequestMethod.POST)
	@ResponseBody
	public void  froget(){
		LogManager.getLogger().debug("这是根据邮箱找回密码...");
	}
}
