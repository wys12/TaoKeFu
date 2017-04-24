package com.yc.taokefu.service;

import com.yc.taokefu.entity.Admin;
import com.yc.taokefu.entity.CompanyAll;
import com.yc.taokefu.entity.Resume;

public interface AdminService {

	Admin login(Admin admin);
	
	Boolean findAdminPwd(Admin admin);

	Integer modifiAdminPwd(Admin admin);

	Integer sendEmail(Resume resume, CompanyAll companyAll);

}
