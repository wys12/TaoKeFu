package com.yc.taokefu.web.handler;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.Admin;
import com.yc.taokefu.entity.Qqlogin;
import com.yc.taokefu.service.AdminService;
import com.yc.taokefu.service.OtherLoginService;
import com.yc.taokefu.service.UserService;
import com.yc.taokefu.util.ServletUtil;

@Controller("otherLoginHandler")
@RequestMapping("otherusers")
public class OtherLoginHandler {
	@Autowired
	private OtherLoginService otherLoginService;
	
	@ResponseBody
	@RequestMapping("qqlogin")
	public String qqlogin(@RequestBody Qqlogin qqlogins, HttpSession session){
		qqlogins=otherLoginService.qqlogin(qqlogins);
		System.out.println("login:qqlogins==>"+qqlogins);
		if(qqlogins == null){
			session.setAttribute(ServletUtil.ERROR_MESSAGE,"用户名或密码错误!!!!");
			return "/login.html";
		}else{
			LogManager.getLogger().debug("登录成功"+qqlogins);
			session.setAttribute(ServletUtil.LOGIN_USER, qqlogins);
			return "redirect:/index.html";
		}
	}
}
