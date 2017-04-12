package com.yc.taokefu.web.handler;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.taokefu.entity.Job;
import com.yc.taokefu.entity.PaginationBean;
import com.yc.taokefu.entity.User;
import com.yc.taokefu.entity.UserAll;
import com.yc.taokefu.service.UserService;
import com.yc.taokefu.util.ServletUtil;

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
	
	
	@RequestMapping("")
	public List<UserAll> findUser(UserAll userAll){
		return userService.findAll(userAll);
	}
	//后台添加用户
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public boolean doAdd(@RequestParam("us_picdata")MultipartFile us_picdata,User user){
		String picPath = null;
		LogManager.getLogger().debug("图片......us_picpath:"+us_picdata);
		if(us_picdata != null && !us_picdata.isEmpty()){//判断是否有文件上传
			System.out.println("图片不为空");
			try {
				us_picdata.transferTo(ServletUtil.getUploadFile(us_picdata.getOriginalFilename()));
				picPath = ServletUtil.VARTUAL_UPLOAD_DIR + us_picdata.getOriginalFilename();
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		user.setUs_picpath(picPath);
		LogManager.getLogger().debug("添加"+user);
		return userService.BackUserAdd(user);
	}
	//后台修改用户
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public boolean doEdit(@RequestParam("us_picdata")MultipartFile us_picdata,User user){
		String picPath = null;
		LogManager.getLogger().debug("图片......us_picpath:"+us_picdata);
		if(us_picdata != null && !us_picdata.isEmpty()){//判断是否有文件上传
			System.out.println("图片不为空");
			try {
				us_picdata.transferTo(ServletUtil.getUploadFile(us_picdata.getOriginalFilename()));
				picPath = ServletUtil.VARTUAL_UPLOAD_DIR + us_picdata.getOriginalFilename();
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		user.setUs_picpath(picPath);
		LogManager.getLogger().debug("修改"+user);
		return userService.BackUserEdit(user);
	}
	//后台删除用户
	@RequestMapping("deleteById")
	public Boolean doDelete(HttpServletRequest request){
		String ids = request.getParameter("ids");
		String[] id = ids.split(",");
			for (int i = 0; i < id.length;i++) {
				LogManager.getLogger().debug("删除用户"+id[i]);
				userService.BackUserDelete(id[i]);
				
				
			}
			return null;
			
	}
	
}