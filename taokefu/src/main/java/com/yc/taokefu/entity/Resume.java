package com.yc.taokefu.entity;

public class Resume {
	/*----------------个人基础信息---------------------*/
	private Integer res_id;
	private Integer c_id;
	private Integer usr_id;
	private String us_name;
	private String us_picpath;//图片路径
	private String us_intro;//简介
	private String us_sex;
	private String us_educationa;//学历
	private String us_work_year;//工作年限
	private String us_phone;//联系方式
	private String us_email;//邮箱
	/*----------------个人简历表---------------------*/
	
	private String usr_name;//简历名称
	private String usr_state;//简历状态（投递成功/简历查看/通过初选/通知面试/不合适）
	private String hj_name;//职位名称
	private String hj_city;//工作地址
	private String hj_min_salary;//期望月薪 
	private String hj_max_salary;//期望月薪 
	private String hj_nature;//职位性质（全职/兼职/实习）
	private String des_content;//描述内容

	/*---------------作品展示----------------------*/
	private String suc_name;//作品名称
	private String suc_link;//作品链接

	/*--------------工作经历-----------------------*/
	private String exp_company_name;//工作公司
	private String exp_job_name;//工作职位
	private String exp_start_year;//起始时间
	private String exp_end_year;//结束时间
	private String exp_work;
	private String  exp_city;
	private String edu_shool_name ;  //学校名称
	private String edu_major ; //所学专业
	private String edu_educationa ;//学历
	private String edu_start_year ;// 开始年份
	private String edu_end_year  ;//毕业年份
	public String getEdu_shool_name() {
		return edu_shool_name;
	}
	public void setEdu_shool_name(String edu_shool_name) {
		this.edu_shool_name = edu_shool_name;
	}
	public String getEdu_major() {
		return edu_major;
	}
	public void setEdu_major(String edu_major) {
		this.edu_major = edu_major;
	}
	public String getEdu_educationa() {
		return edu_educationa;
	}
	public void setEdu_educationa(String edu_educationa) {
		this.edu_educationa = edu_educationa;
	}
	public String getEdu_start_year() {
		return edu_start_year;
	}
	public void setEdu_start_year(String edu_start_year) {
		this.edu_start_year = edu_start_year;
	}
	public String getEdu_end_year() {
		return edu_end_year;
	}
	public void setEdu_end_year(String edu_end_year) {
		this.edu_end_year = edu_end_year;
	}
	public Integer getRes_id() {
		return res_id;
	}
	public void setRes_id(Integer res_id) {
		this.res_id = res_id;
	}
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public Integer getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(Integer usr_id) {
		this.usr_id = usr_id;
	}
	public String getUs_name() {
		return us_name;
	}
	public void setUs_name(String us_name) {
		this.us_name = us_name;
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
	public String getUsr_name() {
		return usr_name;
	}
	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}
	public String getUsr_state() {
		return usr_state;
	}
	public void setUsr_state(String usr_state) {
		this.usr_state = usr_state;
	}
	public String getHj_name() {
		return hj_name;
	}
	public void setHj_name(String hj_name) {
		this.hj_name = hj_name;
	}
	public String getHj_city() {
		return hj_city;
	}
	public void setHj_city(String hj_city) {
		this.hj_city = hj_city;
	}
	public String getHj_min_salary() {
		return hj_min_salary;
	}
	public void setHj_min_salary(String hj_min_salary) {
		this.hj_min_salary = hj_min_salary;
	}
	public String getHj_max_salary() {
		return hj_max_salary;
	}
	public void setHj_max_salary(String hj_max_salary) {
		this.hj_max_salary = hj_max_salary;
	}
	public String getHj_nature() {
		return hj_nature;
	}
	public void setHj_nature(String hj_nature) {
		this.hj_nature = hj_nature;
	}
	public String getDes_content() {
		return des_content;
	}
	public void setDes_content(String des_content) {
		this.des_content = des_content;
	}
	public String getSuc_name() {
		return suc_name;
	}
	public void setSuc_name(String suc_name) {
		this.suc_name = suc_name;
	}
	public String getSuc_link() {
		return suc_link;
	}
	public void setSuc_link(String suc_link) {
		this.suc_link = suc_link;
	}
	public String getExp_company_name() {
		return exp_company_name;
	}
	public void setExp_company_name(String exp_company_name) {
		this.exp_company_name = exp_company_name;
	}
	public String getExp_job_name() {
		return exp_job_name;
	}
	public void setExp_job_name(String exp_job_name) {
		this.exp_job_name = exp_job_name;
	}
	public String getExp_start_year() {
		return exp_start_year;
	}
	public void setExp_start_year(String exp_start_year) {
		this.exp_start_year = exp_start_year;
	}
	public String getExp_end_year() {
		return exp_end_year;
	}
	public void setExp_end_year(String exp_end_year) {
		this.exp_end_year = exp_end_year;
	}
	public String getExp_work() {
		return exp_work;
	}
	public void setExp_work(String exp_work) {
		this.exp_work = exp_work;
	}
	public String getExp_city() {
		return exp_city;
	}
	public void setExp_city(String exp_city) {
		this.exp_city = exp_city;
	}
	@Override
	public String toString() {
		return "Resume [res_id=" + res_id + ", c_id=" + c_id + ", usr_id=" + usr_id + ", us_name=" + us_name
				+ ", us_picpath=" + us_picpath + ", us_intro=" + us_intro + ", us_sex=" + us_sex + ", us_educationa="
				+ us_educationa + ", us_work_year=" + us_work_year + ", us_phone=" + us_phone + ", us_email=" + us_email
				+ ", usr_name=" + usr_name + ", usr_state=" + usr_state + ", hj_name=" + hj_name + ", hj_city="
				+ hj_city + ", hj_min_salary=" + hj_min_salary + ", hj_max_salary=" + hj_max_salary + ", hj_nature="
				+ hj_nature + ", des_content=" + des_content + ", suc_name=" + suc_name + ", suc_link=" + suc_link
				+ ", exp_company_name=" + exp_company_name + ", exp_job_name=" + exp_job_name + ", exp_start_year="
				+ exp_start_year + ", exp_end_year=" + exp_end_year + ", exp_work=" + exp_work + ", exp_city="
				+ exp_city + ", edu_shool_name=" + edu_shool_name + ", edu_major=" + edu_major + ", edu_educationa="
				+ edu_educationa + ", edu_start_year=" + edu_start_year + ", edu_end_year=" + edu_end_year + "]";
	}

}
