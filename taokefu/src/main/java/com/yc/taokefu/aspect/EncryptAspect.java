package com.yc.taokefu.aspect;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.yc.taokefu.entity.Login;
import com.yc.taokefu.entity.User;
import com.yc.taokefu.util.Encrypt;


@Component("encryptAspect")
@Aspect
public class EncryptAspect {
	
	@Before("execution(* com.yc.taokefu.service.impl.LoginServiceImpl.login(..))")
	public void beforeLoginMethod(JoinPoint jpoint){
		Login user=(Login) jpoint.getArgs()[0];
		LogManager.getLogger().debug("对登陆密码加密前===>"+user);
		user.setL_pwd(Encrypt.md5AndSha(user.getL_pwd()));
		LogManager.getLogger().debug("对登陆密码加密后===>"+user);
	}
	@Before("execution(* com.yc.taokefu.service.impl.LoginServiceImpl.addUser(..))")
	public void beforeRegisterMethod(JoinPoint jpoint){
		Login user=(Login) jpoint.getArgs()[0];
		LogManager.getLogger().debug("对添加用户密码加密前===>"+user);
		user.setL_pwd(Encrypt.md5AndSha(user.getL_pwd()));
		LogManager.getLogger().debug("对添加用户密密码加密后===>"+user);
	}
	@Before("execution(* com.yc.taokefu.service.impl.LoginServiceImpl.updatePwd(..))")
	public void beforeUpdatePwdMethod(JoinPoint jpoint){
		Login user=(Login) jpoint.getArgs()[0];
		LogManager.getLogger().debug("对修改密码加密前===>"+user);
		user.setL_pwd(Encrypt.md5AndSha(user.getL_pwd()));
		LogManager.getLogger().debug("对修改密码加密后===>"+user);
	}

}
