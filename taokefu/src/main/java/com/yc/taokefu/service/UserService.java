package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.User;
import com.yc.taokefu.entity.UserAll;

public interface UserService {
	//用户邮箱绑定
	List<User> addUsers(Integer us_id, String us_email);
	


	//后台用户信息
	PaginationBean<User> listPartUsers(String page, String rows);

	List<UserAll> findAll(UserAll userAll);



	boolean BackUserAdd(User user);



	boolean BackUserEdit(User user);



	boolean BackUserDelete(String id);
	
	
}
