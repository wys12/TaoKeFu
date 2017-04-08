package com.yc.taokefu.web.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.Qqlogin;
import com.yc.taokefu.service.OtherLoginService;
import com.yc.taokefu.service.UserService;
import com.yc.taokefu.util.ServletUtil;

@Controller("otherLoginHandler")
@RequestMapping("otherusers")
public class OtherLoginHandler {
	@Autowired
	private OtherLoginService otherLoginService;

	/*
	 * @Autowired private UserService userService;
	 */

	@RequestMapping("qqlogin")
	@ResponseBody
	public Map<String,String> qqlogin(@RequestBody Qqlogin qqlogins, HttpSession session) {
		Map<String,String > map=new HashMap<String,String>();
		LogManager.getLogger().debug("QQ登录成功" + qqlogins);
		String openId = qqlogins.getOpenId();
		String nickname = qqlogins.getNickname();
		List<Qqlogin> listQqlogins = otherLoginService.findOpenId(qqlogins);
		LogManager.getLogger().debug("list<Qqlogin>:" + listQqlogins);
		if (listQqlogins == null || listQqlogins.size() == 0) {
			LogManager.getLogger().debug("该QQ未绑定过");
			Integer boo = otherLoginService.addQqlogin(qqlogins);
			if (boo > 0) {
				// qqlogins = otherLoginService.findOpenId(qqlogins);
				LogManager.getLogger().debug("QQ绑定成功,openID == " + openId);
				map.put("page", "index.html");
				return map;
			} else {// 注册失败
				LogManager.getLogger().debug("QQ绑定失败");
				session.setAttribute(ServletUtil.ERROR_MESSAGE, "QQ绑定失败!!!!");
				map.put("page", "/login.html");
				return map;
			}
		}
		for (Qqlogin qqlogin : listQqlogins) {
			// 第三方已经绑定过
			LogManager.getLogger().debug("第三方已经绑定过");
			session.setAttribute(ServletUtil.LOGIN_USER, qqlogins);
		}
		map.put("page", "index.html");
		return map;
	}
}
