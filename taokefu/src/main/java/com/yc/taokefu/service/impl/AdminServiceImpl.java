package com.yc.taokefu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.taokefu.entity.Admin;
import com.yc.taokefu.mapper.AdminMapper;
import com.yc.taokefu.service.AdminService;

@Service("adminService")
public class AdminServiceImpl  implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public Admin login(Admin admin) {
		
		return adminMapper.findAdmin(admin);
	}

}
