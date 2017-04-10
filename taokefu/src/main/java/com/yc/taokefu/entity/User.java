package com.yc.taokefu.entity;

	
public class User {
	private Integer us_id;
	private String us_name;
	private String us_pwd;
	private String us_picpath;
	private String us_intro;
	private String us_sex;
	private String us_educationa;
	private String us_work_year;
	private String us_phone;
	private String us_email;
	private String openId;
	public Integer getUs_id() {
		return us_id;
	}
	public void setUs_id(Integer us_id) {
		this.us_id = us_id;
	}
	public String getUs_name() {
		return us_name;
	}
	public void setUs_name(String us_name) {
		this.us_name = us_name;
	}
	public String getUs_pwd() {
		return us_pwd;
	}
	public void setUs_pwd(String us_pwd) {
		this.us_pwd = us_pwd;
	}
	public String getUs_picpath() {
		return us_picpath;
	}
	public void setUs_picpath(String us_picpath) {
		this.us_picpath = us_picpath;
	}
	public String getUs_intro() {
		return us_intro;
	}
	public void setUs_intro(String us_intro) {
		this.us_intro = us_intro;
	}
	public String getUs_sex() {
		return us_sex;
	}
	public void setUs_sex(String us_sex) {
		this.us_sex = us_sex;
	}
	public String getUs_educationa() {
		return us_educationa;
	}
	public void setUs_educationa(String us_educationa) {
		this.us_educationa = us_educationa;
	}
	public String getUs_work_year() {
		return us_work_year;
	}
	public void setUs_work_year(String us_work_year) {
		this.us_work_year = us_work_year;
	}
	public String getUs_phone() {
		return us_phone;
	}
	public void setUs_phone(String us_phone) {
		this.us_phone = us_phone;
	}
	public String getUs_email() {
		return us_email;
	}
	public void setUs_email(String us_email) {
		this.us_email = us_email;
	}
	
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	@Override
	public String toString() {
		return "User [us_id=" + us_id + ", us_name=" + us_name + ", us_pwd=" + us_pwd + ", us_picpath=" + us_picpath
				+ ", us_intro=" + us_intro + ", us_sex=" + us_sex + ", us_educationa=" + us_educationa
				+ ", us_work_year=" + us_work_year + ", us_phone=" + us_phone + ", us_email=" + us_email + ", openId="
				+ openId + "]";
	}

	
	
}
