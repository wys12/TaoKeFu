package com.yc.taokefu.mapper;

import com.yc.taokefu.entity.Login;

public interface LoginMapper {
	//用户登录
	Login findUser(Login logins);
	//用户注册
	int addUser(Login logins);
	//防止重注入
	Login findEmail(Login logins);
	//用户修改
	int updatePwd(Login logins);
}
