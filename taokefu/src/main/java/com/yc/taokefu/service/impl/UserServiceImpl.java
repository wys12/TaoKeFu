package com.yc.taokefu.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
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
	public List<UserAll> findAllUser(UserAll userAll) {
		return userAllMapper.findAllUser(userAll);
	}
	
	/**
	 * wys
	 * 查询
	 */
	// 基础信息
	@Override
	public List<UserAll> findUser(UserAll user) {
		LogManager.getLogger().debug("基础信息 ==》 "+user);
		return userMapper.findUser(user);
	}
	//简历信息
	@Override
	public List<UserAll> findUsResume(UserAll user) {
		LogManager.getLogger().debug("简历操作 ==》 "+user);
		return userMapper.findUsResume(user);
	}
	//作品展示
	@Override
	public List<UserAll> findSucceed(UserAll user) {
		return userMapper.findSucceed(user);
	}
	//工作经历信息
	@Override
	public List<UserAll> findExperience(UserAll user) {
		return userMapper.findExperience(user);
	}
	//查询用户 学历信息
	@Override
	public List<UserAll> findEducationa(UserAll user) {
		return userMapper.findEducationa(user);
	}
	//查询用户 收藏信息
	@Override
	public List<UserAll> findCollect(UserAll user) {
		return userMapper.findCollect(user);
	}
	//查询用户订阅信息
	@Override
	public List<UserAll> findTake(UserAll user) {
		return userMapper.findTake(user);
	}
	
	/**
	 * wys
	 * 修改
	 */
	@Override
	public Integer modifiUser(UserAll user) {
		return userMapper.modifiUser(user);
	}
	@Override
	public Integer modifiUsResume(UserAll user) {
		return userMapper.modifiUsResume(user);
	}
	@Override
	public Integer modifiSucceed(UserAll user) {
		return userMapper.modifiSucceed(user);
	}
	@Override
	public Integer modifiExperience(UserAll user) {
		return userMapper.modifiExperience(user);
	}
	@Override
	public Integer modifiEducationa(UserAll user) {
		return userMapper.modifiEducationa(user);
	}
	@Override
	public Integer modifiCollect(UserAll user) {
		return userMapper.modifiCollect(user);
	}
	@Override
	public Integer modifiTake(UserAll user) {
		return userMapper.modifiTake(user);
	}
	
	/**
	 * wys
	 * 插入
	 */
	@Override
	public Integer insertUser(UserAll user) {
		return userMapper.insertUser(user);
	}
	@Override
	public Integer insertUsResume(UserAll user) {
		return userMapper.insertUsResume(user);
	}
	@Override
	public Integer insertSucceed(UserAll user) {
		return userMapper.insertSucceed(user);
	}
	@Override
	public Integer insertExperience(UserAll user) {
		return userMapper.insertExperience(user);
	}
	@Override
	public Integer insertEducationa(UserAll user) {
		return userMapper.insertEducationa(user);
	}
	@Override
	public Integer insertCollect(UserAll user) {
		return userMapper.insertCollect(user);
	}
	@Override
	public Integer insertTake(UserAll user) {
		return userMapper.insertTake(user);
	}
}
