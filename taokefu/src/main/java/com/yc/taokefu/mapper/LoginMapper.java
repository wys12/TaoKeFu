package com.yc.taokefu.mapper;

import com.yc.taokefu.entity.Login;
import com.yc.taokefu.entity.User;

public interface LoginMapper {
	//用户登录
	Login findUser(Login logins);
	//用户注册
	int addUser(Login logins);
	//防止重注入
	Login findEmail(Login logins);
}
