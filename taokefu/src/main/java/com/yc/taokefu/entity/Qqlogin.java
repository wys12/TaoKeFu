package com.yc.taokefu.entity;

public class Qqlogin {
	private String nickname;
	private String us_picpath;
	private String us_sex;
	private String us_intro;
	private String openId;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUs_picpath() {
		return us_picpath;
	}
	public void setUs_picpath(String us_picpath) {
		this.us_picpath = us_picpath;
	}
	public String getUs_sex() {
		return us_sex;
	}
	public void setUs_sex(String us_sex) {
		this.us_sex = us_sex;
	}
	public String getUs_intro() {
		return us_intro;
	}
	public void setUs_intro(String us_intro) {
		this.us_intro = us_intro;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	@Override
	public String toString() {
		return "Qqlogin [nickname=" + nickname + ", us_picpath=" + us_picpath + ", us_sex=" + us_sex + ", us_intro="
				+ us_intro + ", openId=" + openId + "]";
	}
}
