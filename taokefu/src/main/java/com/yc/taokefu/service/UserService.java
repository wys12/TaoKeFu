package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.User;
import com.yc.taokefu.entity.UserAll;

public interface UserService {

	/**
	 * linghong
	 * @param us_id
	 * @param us_name
	 * @return
	 */
	//第三方openid和nickname绑定
	List<User> addOtherUsers(String us_id, String us_name);

	/**
	 * fengwei
	 * @param page
	 * @param rows
	 * @return
	 */
	//后台用户信息
	PaginationBean<User> listPartUsers(String page, String rows);

	/**
	 * wys
	 * @param user
	 * @return
	 */
	//用户邮箱绑定
	List<User> addUsers(Integer us_id, String us_email);
	//查询
	List<UserAll> findUser(UserAll user);//用户信息
	List<UserAll> findUsResume(UserAll user);//简历
	List<UserAll> findSucceed(UserAll user);//作品展示
	List<UserAll> findExperience(UserAll user);//工作经历
	List<UserAll> findEducationa(UserAll user);//教育学历
	List<UserAll> findCollect(UserAll user);//收藏职位
	List<UserAll> findTake(UserAll user);//订阅职位
	List<UserAll> findAllUser(UserAll userAll);
	//插入
	Integer insertUser(UserAll user);//用户信息
	Integer insertUsResume(UserAll user);//简历
	Integer insertSucceed(UserAll user);//作品展示
	Integer insertExperience(UserAll user);//工作经历
	Integer insertEducationa(UserAll user);//教育学历
	Integer insertCollect(UserAll user);//收藏职位
	Integer insertTake(UserAll user);//订阅职位
	//修改
	Integer modifiUser(UserAll user);//用户信息
	Integer modifiUsResume(UserAll user);//简历
	Integer modifiSucceed(UserAll user);//作品展示
	Integer modifiExperience(UserAll user);//工作经历
	Integer modifiEducationa(UserAll user);//教育学历
	Integer modifiCollect(UserAll user);//收藏职位
	Integer modifiTake(UserAll user);//订阅职位


}
