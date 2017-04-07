package com.yc.taokefu.entity;

public class Qqlogin {
	private String nickname;
	private String openId;
	private String accessToken;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	@Override
	public String toString() {
		return "Qquser [nickname=" + nickname + ", openId=" + openId + ", accessToken=" + accessToken + "]";
	}
	
	
	
}
