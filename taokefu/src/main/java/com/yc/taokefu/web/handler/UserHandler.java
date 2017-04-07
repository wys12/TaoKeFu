package com.yc.taokefu.web.handler;



import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.User;
import com.yc.taokefu.service.UserService;

@Controller("userHandler")
@RequestMapping("/tkfuser")
public class UserHandler {
	
	@Autowired
	private  UserService userService;
	
	@RequestMapping("list")
	@ResponseBody //响应Json数据
	public PaginationBean<User> list(String rows,String page){
		LogManager.getLogger().debug("用户-->  rows==>"+rows +",page==>"+page);
		return userService.listPartUsers(page,rows);
	}
	

}