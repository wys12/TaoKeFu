package com.yc.taokefu.entity;

import java.util.List;

public class CompanyAll {
	//公司
	private Integer comp_id;
	private String comp_name;//公司简称
	private String comp_fullname;//公司 全称
	private String comp_logo;
	private String comp_phone;
	private String comp_email;
	private String comp_link;//
	private String comp_city;
	private String comp_territory;//领域 (行业领域)
	private String comp_state;//发展阶段/状体(上市/a轮)
	private String comp_scale;//公司规模
	private String comp_introduce;//公司一句话介绍
	private String comp_introduces;//公司详情介绍
	private String comp_attestation;//公司认证状态
	
	private Integer ct_id;
	private String ct_name;//团队名称
	private String ct_picPath;//图片路径
	private String ct_job;//团队职位
	private String ct_tdesc;//团队描述
	
	private Integer cor_id;//简历id
	
	private String pro_name;//公司产品
	private String pro_link ;//产品链接
	private String pro_picPath;//图片路径
	private String pro_pdesc ;//产品描述
	
	private String de_name;//公司mi
	private String dee_link ;//公司深度链接
	
	private Integer inv_id;
	private String inv_name ;	//投资机构名称
	private String inv_state;	//投资机构发展阶段
	
	private Integer tag_id;
	private String tag_name;
	
	private Integer job_id;
	private Integer c_id;
	private String job_tags;
	private String job_name;
	private String job_department; 
	private String job_nature;    //职位性质（全职/兼职/实习
	private String job_min_salary;
	private String job_max_salary;
	private String job_ftime;
	private String job_education;
	private String job_tempt;	//职位诱惑
	private String job_responsibility;///工作职责
	private String job_need;//任职要求
	private String job_rests;
	private Integer job_number;
	private String job_state; //职位状态   （在线职位/下线职位）
	private String job_city;
	private String job_address;
	private String job_classes;	
	private String job_experience;
	
	private String jc_id;
	private String jc_name;
	
	private List<Job> jobs;
	

	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public String getJob_city() {
		return job_city;
	}
	public void setJob_city(String job_city) {
		this.job_city = job_city;
	}
	public String getJob_address() {
		return job_address;
	}
	public void setJob_address(String job_address) {
		this.job_address = job_address;
	}
	public String getJob_classes() {
		return job_classes;
	}
	public void setJob_classes(String job_classes) {
		this.job_classes = job_classes;
	}
	public String getJob_experience() {
		return job_experience;
	}
	public void setJob_experience(String job_experience) {
		this.job_experience = job_experience;
	}
	
	public Integer getComp_id() {
		return comp_id;
	}
	public void setComp_id(Integer comp_id) {
		this.comp_id = comp_id;
	}
	public String getComp_name() {
		return comp_name;
	}
	public Integer getCt_id() {
		return ct_id;
	}
	public void setCt_id(Integer ct_id) {
		this.ct_id = ct_id;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	public String getComp_fullname() {
		return comp_fullname;
	}
	public void setComp_fullname(String comp_fullname) {
		this.comp_fullname = comp_fullname;
	}
	public String getComp_logo() {
		return comp_logo;
	}
	public void setComp_logo(String comp_logo) {
		this.comp_logo = comp_logo;
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
	public String getComp_territory() {
		return comp_territory;
	}
	public void setComp_territory(String comp_territory) {
		this.comp_territory = comp_territory;
	}
	public String getComp_state() {
		return comp_state;
	}
	public void setComp_state(String comp_state) {
		this.comp_state = comp_state;
	}
	public String getComp_scale() {
		return comp_scale;
	}
	public void setComp_scale(String comp_scale) {
		this.comp_scale = comp_scale;
	}
	public String getComp_introduce() {
		return comp_introduce;
	}
	public void setComp_introduce(String comp_introduce) {
		this.comp_introduce = comp_introduce;
	}
	public String getComp_introduces() {
		return comp_introduces;
	}
	public void setComp_introduces(String comp_introduces) {
		this.comp_introduces = comp_introduces;
	}
	public String getComp_attestation() {
		return comp_attestation;
	}
	public void setComp_attestation(String comp_attestation) {
		this.comp_attestation = comp_attestation;
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
	public Integer getCor_id() {
		return cor_id;
	}
	public void setCor_id(Integer cor_id) {
		this.cor_id = cor_id;
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
	public String getPro_pdesc() {
		return pro_pdesc;
	}
	public void setPro_pdesc(String pro_pdesc) {
		this.pro_pdesc = pro_pdesc;
	}
	public String getDe_name() {
		return de_name;
	}
	public void setDe_name(String de_name) {
		this.de_name = de_name;
	}
	public String getDee_link() {
		return dee_link;
	}
	public void setDee_link(String dee_link) {
		this.dee_link = dee_link;
	}
	public Integer getInv_id() {
		return inv_id;
	}
	public void setInv_id(Integer inv_id) {
		this.inv_id = inv_id;
	}
	public String getInv_name() {
		return inv_name;
	}
	public void setInv_name(String inv_name) {
		this.inv_name = inv_name;
	}
	public String getInv_state() {
		return inv_state;
	}
	public void setInv_state(String inv_state) {
		this.inv_state = inv_state;
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
	public String getJob_tags() {
		return job_tags;
	}
	public void setJob_tags(String job_tags) {
		this.job_tags = job_tags;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
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
	public String getJob_education() {
		return job_education;
	}
	public void setJob_education(String job_education) {
		this.job_education = job_education;
	}
	public String getJob_tempt() {
		return job_tempt;
	}
	public void setJob_tempt(String job_tempt) {
		this.job_tempt = job_tempt;
	}
	public String getJob_responsibility() {
		return job_responsibility;
	}
	public void setJob_responsibility(String job_responsibility) {
		this.job_responsibility = job_responsibility;
	}
	public String getJob_need() {
		return job_need;
	}
	public void setJob_need(String job_need) {
		this.job_need = job_need;
	}
	public String getJob_rests() {
		return job_rests;
	}
	public void setJob_rests(String job_rests) {
		this.job_rests = job_rests;
	}
	public Integer getJob_number() {
		return job_number;
	}
	public void setJob_number(Integer job_number) {
		this.job_number = job_number;
	}
	public String getJob_state() {
		return job_state;
	}
	public void setJob_state(String job_state) {
		this.job_state = job_state;
	}
	public String getJc_id() {
		return jc_id;
	}
	public void setJc_id(String jc_id) {
		this.jc_id = jc_id;
	}
	public String getJc_name() {
		return jc_name;
	}
	public void setJc_name(String jc_name) {
		this.jc_name = jc_name;
	}
	@Override
	public String toString() {
		return "CompanyAll \n[comp_id=" + comp_id + ", comp_name=" + comp_name + ", comp_fullname=" + comp_fullname
				+ ", comp_logo=" + comp_logo + ", comp_phone=" + comp_phone + ", comp_email=" + comp_email
				+ ", comp_link=" + comp_link + ", comp_city=" + comp_city + ", comp_territory=" + comp_territory
				+ ", comp_state=" + comp_state + ", comp_scale=" + comp_scale + ", comp_introduce=" + comp_introduce
				+ ", comp_introduces=" + comp_introduces + ", comp_attestation=" + comp_attestation + ", ct_id=" + ct_id
				+ ", ct_name=" + ct_name + ", ct_picPath=" + ct_picPath + ", ct_job=" + ct_job + ", ct_tdesc="
				+ ct_tdesc + ", cor_id=" + cor_id + ", pro_name=" + pro_name + ", pro_link=" + pro_link
				+ ", pro_picPath=" + pro_picPath + ", pro_pdesc=" + pro_pdesc + ", de_name=" + de_name + ", dee_link="
				+ dee_link + ", inv_id=" + inv_id + ", inv_name=" + inv_name + ", inv_state=" + inv_state + ", tag_id="
				+ tag_id + ", tag_name=" + tag_name + ", job_id=" + job_id + ", c_id=" + c_id + ", job_tags=" + job_tags
				+ ", job_name=" + job_name + ", job_department=" + job_department + ", job_nature=" + job_nature
				+ ", job_min_salary=" + job_min_salary + ", job_max_salary=" + job_max_salary + ", job_ftime="
				+ job_ftime + ", job_education=" + job_education + ", job_tempt=" + job_tempt + ", job_responsibility="
				+ job_responsibility + ", job_need=" + job_need + ", job_rests=" + job_rests + ", job_number="
				+ job_number + ", job_state=" + job_state + ", job_city=" + job_city + ", job_address=" + job_address
				+ ", job_classes=" + job_classes + ", job_experience=" + job_experience + ", jc_id=" + jc_id
				+ ", jc_name=" + jc_name + "]";
	}
	
	
}
