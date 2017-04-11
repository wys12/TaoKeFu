package com.yc.taokefu.web.handler;



import java.io.IOException;
import java.util.List;

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
	/**
	 * wys
	 * 查看一个简历所有信息
	 * @param userAll
	 * @return
	 */
	/*@RequestMapping("findUser")
	@ResponseBody //响应Json数据
	public List<UserAll> findAllUser(UserAll userAll){
		LogManager.getLogger().debug("用户userAll  "+userAll );
		return userService.findAllUser(userAll);
	}*/
	
	/**
	 * wys
	 * 用户信息加载
	 * */
	@RequestMapping("findTkfUser")
	@ResponseBody //响应Json数据
	public List<UserAll> findTkfUser(UserAll user){
		return userService.findUser(user);
	}
	/**
	 * wys
	 * 用户信息添加
	 * */
	@RequestMapping("insertTkfUser")
	@ResponseBody //响应Json数据
	public Integer insertTkfUser(UserAll user){
		return userService.insertUser(user);
	}
	/**
	 * wys
	 * 用户信息修改
	 * */
	@RequestMapping("modifiTkfUser")
	@ResponseBody //响应Json数据
	public Integer modifiTkfUser(UserAll user){
		return userService.modifiUser(user);
	}
	/**
	 * wys
	 * 用户简历加载
	 * */
	@RequestMapping("findUsResume")
	@ResponseBody //响应Json数据
	public List<UserAll> findUsResume(UserAll user){
		return userService.findUsResume(user);
	}
	/**
	 * wys
	 * 用户简历添加
	 * */
	@RequestMapping("insertUsResume")
	@ResponseBody //响应Json数据
	public Integer insertUsResume(UserAll user){
		return userService.insertUsResume(user);
	}
	/**
	 * wys
	 * 用户简历修改
	 * */
	@RequestMapping("modifiUsResume")
	@ResponseBody //响应Json数据
	public Integer modifiUsResume(UserAll user){
		return userService.modifiUsResume(user);
	}
	/**
	 * wys
	 * 个人作品加载
	 * @param user
	 * @return
	 */
	@RequestMapping("findSucceed")
	@ResponseBody //响应Json数据
	public List<UserAll> findSucceed(UserAll user){
		return userService.findSucceed(user);
	}
	/**
	 * wys
	 * 个人作品加载
	 * @param user
	 * @return
	 */
	@RequestMapping("insertSucceed")
	@ResponseBody //响应Json数据
	public Integer insertSucceed(UserAll user){
		return userService.insertSucceed(user);
	}
	/**
	 * 个人作品加载
	 * wys
	 * @param user
	 * @return
	 */
	@RequestMapping("modifiSucceed")
	@ResponseBody //响应Json数据
	public Integer modifiSucceed(UserAll user){
		return userService.modifiSucceed(user);
	}
	/**
	 * wys
	 * 个人工作经验加载
	 * @param user
	 * @return
	 */
	@RequestMapping("findExperience")
	@ResponseBody //响应Json数据
	public List<UserAll> findExperience(UserAll user){
		return userService.findExperience(user);
	}
	/**
	 * wys
	 * 个人工作经验添加
	 * @param user
	 * @return
	 */
	@RequestMapping("insertExperience")
	@ResponseBody //响应Json数据
	public Integer insertExperience(UserAll user){
		return userService.insertExperience(user);
	}
	/**
	 * wys
	 * 个人工作修改
	 * @param user
	 * @return
	 */
	@RequestMapping("modifiExperience")
	@ResponseBody //响应Json数据
	public Integer modifiExperience(UserAll user){
		return userService.modifiExperience(user);
	}
	/**
	 * wys
	 * 学历信息加载
	 * @param user
	 * @return
	 */
	@RequestMapping("findEducationa")
	@ResponseBody //响应Json数据
	public List<UserAll> findEducationa(UserAll user){
		return userService.findEducationa(user);
	}
	/**
	 * wys
	 * 学历信息添加
	 * @param user
	 * @return
	 */
	@RequestMapping("insertEducationa")
	@ResponseBody //响应Json数据
	public Integer insertEducationa(UserAll user){
		return userService.insertEducationa(user);
	}
	/**
	 * wys
	 * 学历信息修改
	 * @param user
	 * @return
	 */
	@RequestMapping("modifiEducationa")
	@ResponseBody //响应Json数据
	public Integer modifiEducationa(UserAll user){
		return userService.modifiEducationa(user);
	}
	/**
	 * wys
	 * 个人收藏公司加载
	 * @return
	 */
	@RequestMapping("findCollect")
	@ResponseBody //响应Json数据
	public List<UserAll> findCollect(UserAll user){
		return userService.findCollect(user);
	}
	/**
	 * wys
	 * 个人收藏添加
	 * @return
	 */
	@RequestMapping("insertCollect")
	@ResponseBody //响应Json数据
	public Integer insertCollect(UserAll user){
		return userService.insertCollect(user);
	}
	/**
	 * wys
	 * 个人收藏公司修改
	 * @return
	 */
	@RequestMapping("modifiCollect")
	@ResponseBody //响应Json数据
	public Integer modifiCollect(UserAll user){
		return userService.modifiCollect(user);
	}
	/**
	 * wys
	 * 订阅加载
	 * @param user
	 * @return
	 */
	@RequestMapping("findTake")
	@ResponseBody //响应Json数据
	public List<UserAll> findTake(UserAll user){
		return userService.findTake(user);
	}
	/**
	 * wys
	 * 订阅添加
	 * @param user
	 * @return
	 */
	@RequestMapping("insertTake")
	@ResponseBody //响应Json数据
	public Integer insertTake(UserAll user){
		return userService.insertTake(user);
	}
	/**
	 * wys
	 * 订阅修改
	 * @param user
	 * @return
	 */
	@RequestMapping("modifiTake")
	@ResponseBody //响应Json数据
	public Integer modifiTake(UserAll user){
		return userService.modifiTake(user);
	}
	
	/**
	 * 后台操作
	 * @param us_picdata
	 * @param user
	 * @return
	 */
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
	
}