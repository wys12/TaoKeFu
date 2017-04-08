package com.yc.taokefu.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.taokefu.entity.Admin;
import com.yc.taokefu.entity.Login;
import com.yc.taokefu.entity.Qqlogin;
import com.yc.taokefu.mapper.AdminMapper;
import com.yc.taokefu.mapper.OtherLoginMapper;
import com.yc.taokefu.service.AdminService;
import com.yc.taokefu.service.OtherLoginService;

@Service("otherLoginService")
public class OtherLoginServiceImpl  implements OtherLoginService {

	@Autowired
	private OtherLoginMapper otherLoginMapper;

	@Override
	public int addQqlogin(Qqlogin qqlogins) {
		return otherLoginMapper.addQqlogin(qqlogins);
	}

	/*//用户注册操作
	@Override
	@Transactional
	public boolean addUser(Login logins) {
		LogManager.getLogger().debug("用户进行注册===>"+logins);
		int i =loginMapper.addUser(logins);
		return  i>0;
	}*/

	//检测用户是否绑定过第三方
	@Override
	public List<Qqlogin> findOpenId(Qqlogin qqlogins){
		List<Qqlogin> qqlogin = otherLoginMapper.findOpenId(qqlogins);
		return qqlogin;
	}
}
