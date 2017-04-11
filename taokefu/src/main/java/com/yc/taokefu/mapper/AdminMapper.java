package com.yc.taokefu.mapper;

import com.yc.taokefu.entity.Admin;

public interface AdminMapper {

	Admin findAdmin(Admin admin);

	Admin searchAdmin(Admin admin);
	Integer modifiAdminPwd(Admin admin);

}
