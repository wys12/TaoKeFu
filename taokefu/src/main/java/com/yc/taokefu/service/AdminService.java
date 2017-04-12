package com.yc.taokefu.service;

import com.yc.taokefu.entity.Admin;

public interface AdminService {

	Admin login(Admin admin);
	
	Boolean findAdminPwd(Admin admin);

	Integer modifiAdminPwd(Admin admin);

}
