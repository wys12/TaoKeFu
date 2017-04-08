package com.yc.taokefu.mapper;

import java.util.List;

import com.yc.taokefu.entity.UserAll;

public interface UserAllMapper {

	//查询用户的所有信息	wys
	List<UserAll> findAllUser(UserAll userAll);

	//查询用户信息/简历	wys
	List<UserAll> findUser(UserAll userAll);

}
