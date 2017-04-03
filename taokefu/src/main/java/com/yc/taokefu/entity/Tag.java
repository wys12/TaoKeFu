package com.yc.taokefu.entity;

public class Tag {
	
	private Integer c_id;
	private Integer tag_id;
	private String tag_name;
	public Integer getTag_id() {
		return tag_id;
	}
	public void setTag_id(Integer tag_id) {
		this.tag_id = tag_id;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	@Override
	public String toString() {
		return "Tag [c_id=" + c_id + ", tag_id=" + tag_id + ", tag_name=" + tag_name + "]";
	}
	
	
	
}
