package com.yc.taokefu.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.taokefu.entity.User;
import com.yc.taokefu.mapper.LoginMapper;
import com.yc.taokefu.mapper.UserMapper;
import com.yc.taokefu.service.LoginService;
import com.yc.taokefu.service.UserService;


//@Component   一般bean
//@Controller  控制分发层bean
//@Repository  数据访问层 bean

@Service("userService")//业务处理成 bean 相当配置中的<bean id="userService" class="com.yc.mybatis.us.service.impl.UserServiceImpl">
public class UserServiceImpl implements UserService {
	
	@Autowired //相当配置中的 <property name="userMapper" ref="userMapper"/>
	private UserMapper userMapper;
	//个人邮箱绑定
	@Override
	public List<User> addUsers(Integer us_id, String us_email) {
		return userMapper.addUser(us_id,us_email);
	}
	

}
