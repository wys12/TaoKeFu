package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.User;

public interface UserService {
	//用户邮箱绑定
	List<User> addUsers(Integer us_id, String us_email);
}
