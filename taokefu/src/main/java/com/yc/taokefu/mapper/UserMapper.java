package com.yc.taokefu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.User;
import com.yc.taokefu.entity.UserAll;

public interface UserMapper {

	/**
	 * linghong
	 * @param us_id
	 * @param us_name
	 * @return
	 */
	//第三方绑定
	List<User> addOtherUser(@Param("openId")String us_id,@Param("nickname")String us_name);
	/**
	 * fengwei
	 * @param pb
	 * @return
	 */
	//后台用户信息
	PaginationBean<User> findPartUsers(PaginationBean<User> pb);

	//后台添加用户
	int BackUserAdd(User user);

<<<<<<< HEAD
	//后台修改用户
	int BackUserEdit(User user);
	
	//后台删除用户
	int BackUserDelete(String id);
=======
	/**
	 * wys
	 * @param user
	 * @return
	 */
	//用户邮箱绑定
	List<User> addUser(@Param("us_id") Integer us_id,@Param("us_email") String us_email);
	//查询用户信息
	List<UserAll> findUser(UserAll user);
	//简历
	List<UserAll> findUsResume(UserAll user);
	//作品
	List<UserAll> findSucceed(UserAll user);
	//经历
	List<UserAll> findExperience(UserAll user);
	//学历
	List<UserAll> findEducationa(UserAll user);
	//收藏
	List<UserAll> findCollect(UserAll user);
	//订阅
	List<UserAll> findTake(UserAll user);
	//添加用户信息
	int insertUser(UserAll user);
	//简历
	int insertUsResume(UserAll user);
	//作品
	int insertSucceed(UserAll user);
	//经历
	int insertExperience(UserAll user);
	//学历
	int insertEducationa(UserAll user);
	//收藏
	int insertCollect(UserAll user);
	//订阅
	int insertTake(UserAll user);
	//修改用户信息
	int modifiUser(UserAll user);
	//简历
	int modifiUsResume(UserAll user);
	//作品
	int modifiSucceed(UserAll user);
	//经历
	int modifiExperience(UserAll user);
	//学历
	Integer modifiEducationa(UserAll user);
	//收藏
	int modifiCollect(UserAll user);
	//订阅
	int modifiTake(UserAll user);
>>>>>>> branch 'master' of ssh://git@github.01.com/wys12/TaoKeFu

}
