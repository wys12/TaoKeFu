package com.yc.taokefu.service;

import com.yc.taokefu.entity.Login;

public interface LoginService {

	Login login(Login logins);

	boolean addUser(Login logins);

	Login findEmail(Login logins);


}
