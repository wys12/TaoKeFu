package com.yc.taokefu.mapper;

import java.util.List;

import com.yc.taokefu.entity.UserAll;

public interface UserAllMapper {

	//查询用户的所有信息
	List<UserAll> findAllUser(UserAll userAll);

}
