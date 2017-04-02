package com.yc.taokefu.web.listener;


import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;

import com.yc.taokefu.util.ServletUtil;






@WebListener
public class DataListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  {  }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	String deployName=sce.getServletContext().getContextPath();
    	ServletUtil.DEPLOY_NAME = sce.getServletContext().getContextPath()+"/";
    	sce.getServletContext().setAttribute("deployName", ServletUtil.DEPLOY_NAME);
    	LogManager.getLogger().debug("项目发布名：" + ServletUtil.DEPLOY_NAME);
    	ServletUtil.UPLOAD_DIR=sce.getServletContext().getRealPath(ServletUtil.VARTUAL_UPLOAD_DIR).replace(deployName.substring(1)+File.separator, "");//文件上传目录
    	
    	
    	
    	ServletUtil.UPLOAD_DIR_PATH = 
    			new File(new File(sce.getServletContext().getRealPath("/")).getParentFile(), ServletUtil.VARTUAL_UPLOAD_DIR).getAbsolutePath();
    	LogManager.getLogger().debug("上传文件所存放的位置是：" + ServletUtil.UPLOAD_DIR_PATH);
    }
	
}
