package com.yc.taokefu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.User;
import com.yc.taokefu.entity.UserAll;

public interface UserMapper {

	//用户邮箱绑定
	List<User> addUser(@Param("us_id") Integer us_id,@Param("us_email") String us_email);

	
	//后台用户信息
	PaginationBean<User> findPartUsers(PaginationBean<User> pb);

	
}
