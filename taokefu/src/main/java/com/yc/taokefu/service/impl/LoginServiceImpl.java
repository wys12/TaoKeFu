package com.yc.taokefu.service.impl;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.taokefu.entity.Login;
import com.yc.taokefu.mapper.LoginMapper;
import com.yc.taokefu.service.LoginService;


//@Component   一般bean
//@Controller  控制分发层bean
//@Repository  数据访问层 bean

@Service("loginService")//业务处理成 bean 相当配置中的<bean id="userService" class="com.yc.mybatis.us.service.impl.UserServiceImpl">
public class LoginServiceImpl implements LoginService {
	
	@Autowired //相当配置中的 <property name="userMapper" ref="userMapper"/>
	private LoginMapper loginMapper;
	//用户登录操作
	public Login login(Login logins) {
		LogManager.getLogger().debug("用户进行登录操作===>"+logins);
		return loginMapper.findUser(logins);
	}

	//用户注册操作
	@Override
	@Transactional
	public boolean addUser(Login logins) {
		LogManager.getLogger().debug("用户进行注册===>"+logins);
		int i =loginMapper.addUser(logins);
		return  i>0;
	}

	//检测邮箱是否注册
	@Override
	public Login findEmail(Login logins) {
		return loginMapper.findEmail(logins);
	}

	
	//修改密码
	@Override
	public boolean updatePwd(Login logins) {
		
		return loginMapper.updatePwd(logins)>0;
	}

	

}
