package com.yc.taokefu.web.handler;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.User;
import com.yc.taokefu.entity.UserAll;
import com.yc.taokefu.service.UserService;

@Controller("userHandler")
@RequestMapping("tkfuser")
public class UserHandler {
	
	@Autowired
	private  UserService userService;
	/**
	 * fv
	 * @param rows
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody //响应Json数据
	public PaginationBean<User> list(String rows,String page){
		LogManager.getLogger().debug("用户-->  rows==>"+rows +",page==>"+page);
		return userService.listPartUsers(page,rows);
	}
	/**
	 * wys
	 * 查看简历信息
	 * @param userAll
	 * @return
	 */
	@RequestMapping("findAllUser")
	@ResponseBody //响应Json数据
	public List<UserAll> findAllUser(UserAll userAll){
		LogManager.getLogger().debug("用户userAll  "+userAll );
		return userService.findAllUser(userAll);
	}
	
	/**
	 * wys
	 * 查看简历信息
	 * @param userAll
	 * @return
	 */
	@RequestMapping("findUser")
	@ResponseBody //响应Json数据
	public List<UserAll> findUser(UserAll user){
		LogManager.getLogger().debug("用户user  "+user );
		return userService.findUser(user);
	}
}