package com.yc.taokefu.mapper;

import java.util.List;

import com.yc.taokefu.entity.Qqlogin;

public interface OtherLoginMapper {
	
	int addQqlogin(Qqlogin qqlogins);
	
	List<Qqlogin> findOpenId(Qqlogin qqlogins);
}
