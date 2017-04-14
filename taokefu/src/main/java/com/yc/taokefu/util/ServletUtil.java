package com.yc.taokefu.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.Login;

public class ServletUtil {
	public static String ERROR_MESSAGE="errorMsg";
	public static String DEPLOY_NAME="deployname";//项目发布名
	public static String LOGIN_USER="loginUser";//登录用户
	public static String UPLOAD_DIR_PATH;
	public static final String VARTUAL_UPLOAD_DIR = "/upload/";
	public static final String LOGIN_ADMIN = "adminLogin";  //管理员登陆
	public static String UPLOAD_DIR;//文件上传目录 
	public static Map<String, String> userMap;
	public static int CODE;
	public static List<CompanyAll> JOB_LIST = new ArrayList<CompanyAll>();//返回界面信息
	public static Integer type =0;
	public static Integer job_id;
	public static String picPath ;
	public static File getUploadFile(String fileName){
		File file=new File(UPLOAD_DIR,fileName); //上传文件
		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs(); //如果不存在就创建
		}
		return file;
	}
	public static void uploadFile(MultipartFile us_picdata){
		if(us_picdata != null && !us_picdata.isEmpty()){//判断是否有文件上传
			System.out.println("图片不为空");
			try {
				us_picdata.transferTo(ServletUtil.getUploadFile(us_picdata.getOriginalFilename()));
				picPath = ServletUtil.VARTUAL_UPLOAD_DIR + us_picdata.getOriginalFilename();
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
