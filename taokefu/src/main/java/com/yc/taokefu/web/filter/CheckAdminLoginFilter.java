package com.yc.taokefu.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import com.yc.taokefu.util.ServletUtil;


/**
 * AaminLogin验证
 */

@WebFilter("/manage.html")
public class CheckAdminLoginFilter extends AbstractFilter  {
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		LogManager.getLogger().debug("初始AaminLogin验证CheckAdminLoginFilter.....");
	}
  	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		String reqUriStr=req.getRequestURI();
		LogManager.getLogger().debug("拦截的uri ===>  "+reqUriStr);
  		if(reqUriStr.endsWith("manage.html")){
  			Object admin=req.getSession().getAttribute("adminLogin");
  			if(admin==null){
  				req.getSession().setAttribute("errorMsg","想走捷径，没门儿！！！");
  	  			resp.sendRedirect(ServletUtil.DEPLOY_NAME+"adminLogin.jsp");
  	  			return;
  			}
  		}
  		chain.doFilter(request, response);	
	}
}
