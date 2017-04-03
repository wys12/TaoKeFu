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
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;


/**
 *  过滤验证码
 */
@WebFilter("/admin/login")
public class VcodeFilter extends AbstractFilter{
   
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		LogManager.getLogger().debug("初始验证码验证的过滤器VcodeFilter.....");
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		String srcCode = (String)session.getAttribute("rand"); //取到原始验证码
		String inputCode = request.getParameter("vcode");
		if(srcCode.intern() == inputCode.intern()){
			LogManager.getLogger().debug("过滤器VcodeFilter验证验证码通过.....");
			chain.doFilter(request, response);
		}else{
			LogManager.getLogger().debug("过滤器VcodeFilter验证验证码失败.....");
			session.setAttribute("errorMsg", "验证码错误！！！");
			((HttpServletResponse) response).sendRedirect("/taokefu/back/login.jsp");
		}
		
		
	}
}
