package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.User;
import com.yc.taokefu.entity.UserAll;

public interface UserService {
	//用户邮箱绑定
	List<User> addUsers(Integer us_id, String us_email);
	
	//第三方openid和nickname绑定
	List<User> addOtherUsers(String us_id, String us_name);

	//后台用户信息
	PaginationBean<User> listPartUsers(String page, String rows);
	// wys
	List<UserAll> findAll(UserAll userAll);
	
	//查询用户信息（建简历信息）wys
	List<UserAll> findUser(UserAll userAll);
	
	
}
