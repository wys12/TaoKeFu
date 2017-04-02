package com.yc.taokefu.entity;

public class Company {
	private Integer comp_id;
	private String comp_name;
	private String comp_logo;
	private String comp_intor;
	private String comp_phone;
	private String comp_email;
	private String comp_link;
	private String comp_city;
	public Integer getComp_id() {
		return comp_id;
	}
	public void setComp_id(Integer comp_id) {
		this.comp_id = comp_id;
	}
	public String getComp_name() {
		return comp_name;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	public String getComp_logo() {
		return comp_logo;
	}
	public void setComp_logo(String comp_logo) {
		this.comp_logo = comp_logo;
	}
	public String getComp_intor() {
		return comp_intor;
	}
	public void setComp_intor(String comp_intor) {
		this.comp_intor = comp_intor;
	}
	public String getComp_phone() {
		return comp_phone;
	}
	public void setComp_phone(String comp_phone) {
		this.comp_phone = comp_phone;
	}
	public String getComp_email() {
		return comp_email;
	}
	public void setComp_email(String comp_email) {
		this.comp_email = comp_email;
	}
	public String getComp_link() {
		return comp_link;
	}
	public void setComp_link(String comp_link) {
		this.comp_link = comp_link;
	}
	public String getComp_city() {
		return comp_city;
	}
	public void setComp_city(String comp_city) {
		this.comp_city = comp_city;
	}
	@Override
	public String toString() {
		return "Company [comp_id=" + comp_id + ", comp_name=" + comp_name + ", comp_logo=" + comp_logo + ", comp_intor="
				+ comp_intor + ", comp_phone=" + comp_phone + ", comp_email=" + comp_email + ", comp_link=" + comp_link
				+ ", comp_city=" + comp_city + "]";
	}

	
}
