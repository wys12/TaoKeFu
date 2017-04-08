package com.yc.taokefu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.User;
import com.yc.taokefu.entity.UserAll;
import com.yc.taokefu.mapper.UserAllMapper;
import com.yc.taokefu.mapper.UserMapper;
import com.yc.taokefu.service.UserService;


//@Component   一般bean
//@Controller  控制分发层bean
//@Repository  数据访问层 bean

@Service("userService")//业务处理成 bean 相当配置中的<bean id="userService" class="com.yc.mybatis.us.service.impl.UserServiceImpl">
public class UserServiceImpl implements UserService {

	@Autowired //相当配置中的 <property name="userMapper" ref="userMapper"/>
	private UserMapper userMapper;
	@Autowired //相当配置中的 <property name="userMapper" ref="userMapper"/>
	private UserAllMapper userAllMapper;
	
	/**
	 * wys,fv
	 */
	//个人邮箱绑定
	@Override
	public List<User> addUsers(Integer us_id, String us_email) {
		return userMapper.addUser(us_id,us_email);
	}
	/**
	 * lh
	 */
	//第三方绑定绑定
	@Override
	public List<User> addOtherUsers(String us_id, String us_name) {
		return userMapper.addOtherUser(us_id,us_name);
	}
	/**
	 * fv
	 */
	//后台用户信息
	@Override
	public PaginationBean<User> listPartUsers(String page, String rows) {
		PaginationBean<User> pb=new PaginationBean<>();
		if(page != null){
			pb.setCurrPage(Integer.parseInt(page));
		}
		if(rows != null){
			pb.setPageSize(Integer.parseInt(rows));
		}

		return userMapper.findPartUsers(pb);
	}

	/**
	 * wys
	 */
	@Override
	public List<UserAll> findAll(UserAll userAll) {
		return userAllMapper.findAllUser(userAll);
	}
	/**
	 * wys
	 */
	@Override
	public List<UserAll> findUser(UserAll userAll) {
		return userAllMapper.findUser(userAll);
	}
}
