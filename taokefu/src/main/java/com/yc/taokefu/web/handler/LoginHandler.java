package com.yc.taokefu.web.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.Login;
import com.yc.taokefu.service.CompanyService;
import com.yc.taokefu.service.LoginService;
import com.yc.taokefu.service.UserService;
import com.yc.taokefu.util.Encrypt;
import com.yc.taokefu.util.ServletUtil;

@Controller("loginHandler")
@RequestMapping("users")
public class LoginHandler {

	@Autowired
	private LoginService loginService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private UserService userService;

	/**
	 * fv,wys
	 * @param logins
	 * @param user
	 * @param company
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="login",method=RequestMethod.POST)
	public Map<String , String> login(@RequestBody Login logins,HttpSession session){
		Map<String,String > map=new HashMap<String,String>();
		LogManager.getLogger().debug("进来了"+logins);
		logins=loginService.login(logins);
		if(logins == null){
			session.setAttribute(ServletUtil.ERROR_MESSAGE,"用户名或密码错误!!!!");
			map.put("page", "login.html");
			return map;
		}else{
			if(logins.getL_type().equals("1")){
				ServletUtil.c_ids=logins.getL_id();
			}else if(logins.getL_type().equals("0")){
				ServletUtil.tkf_ids=logins.getL_id();
			}
			LogManager.getLogger().debug("登录成功"+logins);
			session.setAttribute(ServletUtil.LOGIN_USER, logins);
			map.put("page", "index.html");
			return map;
		}
	}

	/**
	 * fv,wys
	 * @param logins
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("register")
	public Map<String,String> register(@RequestBody Login logins,HttpSession session){
		Map<String,String > map=new HashMap<String,String>();
		String type = logins.getL_type();
		String pwd = logins.getL_pwd();
		String l_email = logins.getL_email();
		if(type!=null && type!="" && l_email!=null && l_email!=""){
			if(loginService.findEmail(logins) ==null){
				LogManager.getLogger().debug("该邮箱未注册");
				if(loginService.addUser(logins)== true){
					Login findLogins = loginService.findEmail(logins);
					Integer l_id = findLogins.getL_id();
					if(type.equals("0")){
						userService.addUsers(l_id,l_email);
						LogManager.getLogger().debug("注册邮箱成功0,IDs == " +logins);
						map.put("msg", "0");
					}else if(type.equals("1")){
						companyService.addCompany(l_id,l_email);
						LogManager.getLogger().debug("注册邮箱成功1,IDs == " +logins);
						map.put("msg", "1");
					}
					logins.setL_pwd(pwd);
					pwd=null;
					login(logins, session);
					//session.setAttribute(ServletUtil.LOGIN_USER, logins);
					return map;
				}else{//注册失败
					LogManager.getLogger().debug("注册失败");
					session.setAttribute(ServletUtil.ERROR_MESSAGE,"注册失败!!!!");
					map.put("msg", "register.html");
					return map;
				}
			}else{//邮箱已注册
				LogManager.getLogger().debug("已注册");
				//session.setAttribute(ServletUtil.ERROR_MESSAGE,"该邮箱已被注册!!!!");
				map.put("msg", "该邮箱已被注册");
				return map;
			}	
		}else{
			LogManager.getLogger().debug("请选择注册类型");
			map.put("msg", "请选择类型");
			return map;
		}

	}

	/**
	 * wys
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="logins",method=RequestMethod.POST)
	public Object logins(HttpSession session){
		Object object =session.getAttribute(ServletUtil.LOGIN_USER);
		if(object!=null){
			LogManager.getLogger().debug("LOGIN_USER ==>  "+object);
			return object;
		}
		return null;
	}

	/**
	 * wys
	 * @param session
	 * @return
	 */
	@RequestMapping(value="outlogins",method=RequestMethod.POST)
	@ResponseBody
	public String outlogins(HttpSession session){
		session.removeAttribute(ServletUtil.LOGIN_USER);
		//LogManager.getLogger().debug("退出后==>" +session.getAttribute(ServletUtil.LOGIN_USER));
		return "/index.html";
	}


	//密码修改
	@RequestMapping("updatePwd")
	public String updatePwd(Login login, HttpSession session,HttpServletRequest request){
		Login logins = (Login) session.getAttribute(ServletUtil.LOGIN_USER);
		String oldpassword=request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");
		String comfirmpassword=request.getParameter("comfirmpassword");
		String email=logins.getL_email();
		oldpassword=Encrypt.md5AndSha(oldpassword);
		if(logins.getL_pwd().equals(oldpassword)){
			if(newpassword.equals(comfirmpassword)){
				login.setL_pwd(comfirmpassword);
				login.setL_email(email);
				loginService.updatePwd(login);
				session.removeAttribute(ServletUtil.LOGIN_USER);
				return "redirect:/login.html";
			}
			LogManager.getLogger().debug("两次输入密码不正确");
		}
		return "redirect:/updatePwd.html";

	}


}