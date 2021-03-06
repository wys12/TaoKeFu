package com.yc.taokefu.web.handler;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.Admin;
import com.yc.taokefu.service.AdminService;
import com.yc.taokefu.util.ServletUtil;

@Controller("adminHandler")
@RequestMapping("admin")
public class AdminHandler {
	
	
	@Autowired
	private  AdminService adminService;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
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
	/**
	 * 请求发送验证码
	 * @param admin
	 * @return
	 */
	
	@RequestMapping(value="forget",method=RequestMethod.POST)
	@ResponseBody
	public Boolean   froget(Admin admin){
		LogManager.getLogger().debug("这是根据邮箱找回密码..."+admin);
		return adminService.findAdminPwd(admin);
		
	}
	
	/**
	 * 修改密码
	 * @param admin
	 * @param code
	 * @return 1441605117@qq.com
	 */
	@ResponseBody
	@RequestMapping(value="forgets",method=RequestMethod.POST)
	public String frogets(Admin admin,@RequestParam("code")String code,HttpSession session){
		LogManager.getLogger().debug("这是根据邮箱修改密码..."+":验证码："+code+",用户更改的密码"+admin.getAd_pwd());
		if(Integer.valueOf(code)==ServletUtil.CODE){
			LogManager.getLogger().debug("验证码输入正确...");
			session.removeAttribute(ServletUtil.ERROR_MESSAGE);
			adminService.modifiAdminPwd(admin);
			return "0";//"adminLogin.jsp";
		}  
		LogManager.getLogger().debug("验证码输入错误...");
		session.setAttribute(ServletUtil.ERROR_MESSAGE,"验证码输入错误!!!!");
		return "1";//"redirect:/forgetPassword.jsp";
	}
}
