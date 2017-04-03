package com.yc.taokefu.entity;

public class CompanyAll {
	private Integer comp_id;
	private String comp_name;
	private String comp_logo;
	private String comp_intor;
	private String comp_phone;
	private String comp_email;
	private String comp_link;
	private String comp_city;
	
	private Integer ct_id;
	private String ct_name;
	private String ct_picPath;
	private String ct_job;
	private String ct_tdesc;
	
	private Integer job_id;
	private Integer c_id;
	private String job_name;
	private String job_tags;
	private String job_department; //职位部门 
	private String job_nature;   //职位性质
	private String job_min_salary;
	private String job_max_salary;
	private String job_ftime;
	private String job_request;
	
	private Integer pro_id;
	private String pro_name;
	private String pro_link;
	private String pro_picPath;
	
	private Integer tag_id;
	private String tag_name;
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
	public Integer getCt_id() {
		return ct_id;
	}
	public void setCt_id(Integer ct_id) {
		this.ct_id = ct_id;
	}
	public String getCt_name() {
		return ct_name;
	}
	public void setCt_name(String ct_name) {
		this.ct_name = ct_name;
	}
	public String getCt_picPath() {
		return ct_picPath;
	}
	public void setCt_picPath(String ct_picPath) {
		this.ct_picPath = ct_picPath;
	}
	public String getCt_job() {
		return ct_job;
	}
	public void setCt_job(String ct_job) {
		this.ct_job = ct_job;
	}
	public String getCt_tdesc() {
		return ct_tdesc;
	}
	public void setCt_tdesc(String ct_tdesc) {
		this.ct_tdesc = ct_tdesc;
	}
	public Integer getJob_id() {
		return job_id;
	}
	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getJob_tags() {
		return job_tags;
	}
	public void setJob_tags(String job_tags) {
		this.job_tags = job_tags;
	}
	public String getJob_department() {
		return job_department;
	}
	public void setJob_department(String job_department) {
		this.job_department = job_department;
	}
	public String getJob_nature() {
		return job_nature;
	}
	public void setJob_nature(String job_nature) {
		this.job_nature = job_nature;
	}
	public String getJob_min_salary() {
		return job_min_salary;
	}
	public void setJob_min_salary(String job_min_salary) {
		this.job_min_salary = job_min_salary;
	}
	public String getJob_max_salary() {
		return job_max_salary;
	}
	public void setJob_max_salary(String job_max_salary) {
		this.job_max_salary = job_max_salary;
	}
	public String getJob_ftime() {
		return job_ftime;
	}
	public void setJob_ftime(String job_ftime) {
		this.job_ftime = job_ftime;
	}
	public String getJob_request() {
		return job_request;
	}
	public void setJob_request(String job_request) {
		this.job_request = job_request;
	}
	public Integer getPro_id() {
		return pro_id;
	}
	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getPro_link() {
		return pro_link;
	}
	public void setPro_link(String pro_link) {
		this.pro_link = pro_link;
	}
	public String getPro_picPath() {
		return pro_picPath;
	}
	public void setPro_picPath(String pro_picPath) {
		this.pro_picPath = pro_picPath;
	}
	public Integer getTag_id() {
		return tag_id;
	}
	public void setTag_id(Integer tag_id) {
		this.tag_id = tag_id;
	}
	public String getTag_name() {
		return tag_name;
	}
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	@Override
	public String toString() {
		return "CompanyAll [comp_id=" + comp_id + ", comp_name=" + comp_name + ", comp_logo=" + comp_logo
				+ ", comp_intor=" + comp_intor + ", comp_phone=" + comp_phone + ", comp_email=" + comp_email
				+ ", comp_link=" + comp_link + ", comp_city=" + comp_city + ", ct_id=" + ct_id + ", ct_name=" + ct_name
				+ ", ct_picPath=" + ct_picPath + ", ct_job=" + ct_job + ", ct_tdesc=" + ct_tdesc + ", job_id=" + job_id
				+ ", c_id=" + c_id + ", job_name=" + job_name + ", job_tags=" + job_tags + ", job_department="
				+ job_department + ", job_nature=" + job_nature + ", job_min_salary=" + job_min_salary
				+ ", job_max_salary=" + job_max_salary + ", job_ftime=" + job_ftime + ", job_request=" + job_request
				+ ", pro_id=" + pro_id + ", pro_name=" + pro_name + ", pro_link=" + pro_link + ", pro_picPath="
				+ pro_picPath + ", tag_id=" + tag_id + ", tag_name=" + tag_name + "]";
	}
	
	
}
