package com.yc.taokefu.entity;

public class Company {
	private Integer comp_id;
	private String comp_name;
	private String comp_fullname;
	private String comp_logo;
	private String comp_territory;
	private String comp_state;
	private String comp_phone;
	private String comp_email;
	private String comp_link;
	private String comp_city;
	private String comp_scale;
	private String comp_introduce;
	private String comp_introduces;
	private String comp_attestation;
	private String tag_name;
	private String find_comp;
	private String comp_search;
	public Integer getComp_id() {
		return comp_id;
	}
	public String getComp_name() {
		return comp_name;
	}
	public String getComp_fullname() {
		return comp_fullname;
	}
	public String getComp_logo() {
		return comp_logo;
	}
	public String getComp_territory() {
		return comp_territory;
	}
	public String getComp_state() {
		return comp_state;
	}
	public String getComp_phone() {
		return comp_phone;
	}
	public String getComp_email() {
		return comp_email;
	}
	public String getComp_link() {
		return comp_link;
	}
	public String getComp_city() {
		return comp_city;
	}
	public String getComp_scale() {
		return comp_scale;
	}
	public String getComp_introduce() {
		return comp_introduce;
	}
	public String getComp_introduces() {
		return comp_introduces;
	}
	public String getComp_attestation() {
		return comp_attestation;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setComp_id(Integer comp_id) {
		this.comp_id = comp_id;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	public void setComp_fullname(String comp_fullname) {
		this.comp_fullname = comp_fullname;
	}
	public void setComp_logo(String comp_logo) {
		this.comp_logo = comp_logo;
	}
	public void setComp_territory(String comp_territory) {
		this.comp_territory = comp_territory;
	}
	public void setComp_state(String comp_state) {
		this.comp_state = comp_state;
	}
	public void setComp_phone(String comp_phone) {
		this.comp_phone = comp_phone;
	}
	public void setComp_email(String comp_email) {
		this.comp_email = comp_email;
	}
	public void setComp_link(String comp_link) {
		this.comp_link = comp_link;
	}
	public void setComp_city(String comp_city) {
		this.comp_city = comp_city;
	}
	public void setComp_scale(String comp_scale) {
		this.comp_scale = comp_scale;
	}
	public void setComp_introduce(String comp_introduce) {
		this.comp_introduce = comp_introduce;
	}
	public void setComp_introduces(String comp_introduces) {
		this.comp_introduces = comp_introduces;
	}
	public void setComp_attestation(String comp_attestation) {
		this.comp_attestation = comp_attestation;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	
	public String getFind_comp() {
		return find_comp;
	}
	public void setFind_comp(String find_comp) {
		this.find_comp = find_comp;
	}
	public String getComp_search() {
		return comp_search;
	}
	public void setComp_search(String comp_search) {
		this.comp_search = comp_search;
	}
	@Override
	public String toString() {
		return "Company [comp_id=" + comp_id + ", comp_name=" + comp_name + ", comp_fullname=" + comp_fullname
				+ ", comp_logo=" + comp_logo + ", comp_territory=" + comp_territory + ", comp_state=" + comp_state
				+ ", comp_phone=" + comp_phone + ", comp_email=" + comp_email + ", comp_link=" + comp_link
				+ ", comp_city=" + comp_city + ", comp_scale=" + comp_scale + ", comp_introduce=" + comp_introduce
				+ ", comp_introduces=" + comp_introduces + ", comp_attestation=" + comp_attestation + ", tag_name="
				+ tag_name + ", find_comp=" + find_comp + ", comp_search=" + comp_search + "]";
	}
	
	
}
