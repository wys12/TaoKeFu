package com.yc.taokefu.web.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.Admin;
import com.yc.taokefu.entity.Company;
import com.yc.taokefu.entity.Login;
import com.yc.taokefu.entity.Qqlogin;
import com.yc.taokefu.entity.User;
import com.yc.taokefu.service.AdminService;
import com.yc.taokefu.service.OtherLoginService;
import com.yc.taokefu.service.UserService;
import com.yc.taokefu.util.ServletUtil;

@Controller("otherLoginHandler")
@RequestMapping("otherusers")
public class OtherLoginHandler {
	@Autowired
	private OtherLoginService otherLoginService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("qqlogin")
	public Map<String , String> qqlogin(@RequestBody Qqlogin qqlogins,HttpSession session){
		LogManager.getLogger().debug("QQ登录成功"+qqlogins);
		Map<String,String > map=new HashMap<String,String>();
		String openId = qqlogins.getOpenId();
		String nickname = qqlogins.getNickname();
		List<Qqlogin> sq = new ArrayList<Qqlogin>();
		LogManager.getLogger().debug("id == >"+otherLoginService.findOpenId(qqlogins));
		LogManager.getLogger().debug("map  ===> " +map);
		LogManager.getLogger().debug("123321 ===  "+otherLoginService.addQqlogin(qqlogins));
		if(otherLoginService.findOpenId(qqlogins) == null){
			LogManager.getLogger().debug("该QQ未绑定过");
			System.out.println("-==-=-==-=-"+otherLoginService.addQqlogin(qqlogins));
			if(otherLoginService.addQqlogin(qqlogins)!= 0){
				sq = otherLoginService.findOpenId(qqlogins);				
				LogManager.getLogger().debug("QQ绑定成功,openID == " +openId);
				LogManager.getLogger().debug("sq ===  "+sq);
				map.put("page", "index.html");
				return map;
			}else{//注册失败
				LogManager.getLogger().debug("QQ绑定失败");
				session.setAttribute(ServletUtil.ERROR_MESSAGE,"注册失败!!!!");
				map.put("page", "login.html");
				return map;
			}
		}else{//第三方已经绑定过
			LogManager.getLogger().debug("第三方已经绑定过");
			session.setAttribute(ServletUtil.LOGIN_USER,qqlogins);
			map.put("page", "index.html");
			return map;
		}
		
		//return map;
	}
}
