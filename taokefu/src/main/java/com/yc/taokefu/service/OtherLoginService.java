package com.yc.taokefu.service;

import java.util.List;

import com.yc.taokefu.entity.Qqlogin;

public interface OtherLoginService {
	
	int addQqlogin(Qqlogin qqlogins);
	
	List<Qqlogin> findOpenId(Qqlogin qqlogins);
	
	
}
