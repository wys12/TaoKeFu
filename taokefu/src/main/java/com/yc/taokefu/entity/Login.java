package com.yc.taokefu.entity;

public class Login {
	
	
	private Integer l_id;
	private String l_pwd;
	private String l_email;
	private String l_type;
	public Integer getL_id() {
		return l_id;
	}
	public void setL_id(Integer l_id) {
		this.l_id = l_id;
	}
	public String getL_pwd() {
		return l_pwd;
	}
	public void setL_pwd(String l_pwd) {
		this.l_pwd = l_pwd;
	}
	public String getL_email() {
		return l_email;
	}
	public void setL_email(String l_email) {
		this.l_email = l_email;
	}
	public String getL_type() {
		return l_type;
	}
	public void setL_type(String l_type) {
		this.l_type = l_type;
	}
	@Override
	public String toString() {
		return "Login [l_id=" + l_id + ", l_pwd=" + l_pwd + ", l_email=" + l_email + ", l_type=" + l_type + "]";
	}
	
}
