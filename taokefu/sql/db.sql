insert into admin values(1,'aaa','a');
---admin管理员
create table admin(
  ad_id number primary key ,
  ad_name varchar2(10) not null,
  ad_pwd varchar2(10) not null
);
--login	登录
create table login(
  l_id number primary key ,
  l_email varchar2(20) not null UNIQUE,
  l_pwd varchar2(100) not null,
  l_type varchar2(10) not null check (l_type in('0','1')) 
);



--insert into tkfuser values (login_sql.nextval,'李四',null,'我是李四',default,'衡大','三年','12345678901','111111@qq.com');
--user  个人信息  
create table tkfuser(
  us_id number primary key,	--id等于 login id
  us_name varchar2(10) ,	--名称
  us_picpath varchar2(50),      --图片路径
  us_intro varchar2(100),       --简介
  us_sex  varchar2(3) check (us_sex in('男','女')),         --性别
  us_educationa varchar2(10) ,  -- 学历
  us_work_year  varchar2(20) ,  --工作年限
  us_phone varchar2(10) ,       --联系方式
  us_email varchar2(30) UNIQUE   --邮箱 
);
--insert into company values
--(company_sql.nextval,'百度','百度搜索'，'logo','互联网','上市','13613931201','baidu.163.com','www.baidu.com','北京',
--'500-1000','你来就好','百度公司','-1');


--company 公司 
create table company(
  comp_id number primary key,
  comp_name varchar2(10),	--公司简称
  comp_fullname varchar2(10),	--公司 全称
  comp_logo varchar2(20),	--logo
  comp_territory varchar2(30), 	--领域 (行业领域)
  comp_state varchar2(20),	--发展阶段/状体(上市/a轮)
  comp_phone varchar2(20),	--联系方式
  comp_email varchar2(100) not null UNIQUE, --邮箱
  comp_link varchar2(255), 	--公司主页链接
  comp_city varchar2(20), --城市
  comp_scale varchar2(20), --公司规模
  comp_introduce varchar2(10),	--公司一句话介绍
  comp_introduces varchar2(100),	--公司详情介绍
  comp_attestation varchar2(10) check(comp_attestation in('-0','-1'))--公司认证状态
);

select * from login tkfuser
insert into usResume(usr_id,tkf_id) values(usResume_sql.nextval,)
 --resume	用户简历表(详情)
create table usResume(
	usr_id number primary key,
	tkf_id number constraint tkf_id references tkfuser(us_id),
	c_id number constraint fk_usR_id references company(comp_id),
	usr_name varchar2(10),	--简历名称
	usr_state varchar2(10) check(usr_state in('-0','-1','-2','-3','-4')),	--简历状态（投递成功/简历查看/通过初选/通知面试/不合适）
 --hope_job	期望工作
	hj_name varchar2(10) ,	--职位名称
	hj_city varchar2(10) ,	--工作地址
	hj_min_salary varchar2(10),	--期望月薪 
	hj_max_salary varchar2(10),	--期望月薪 
  	hj_nature varchar2(20) check(hj_nature in('-0','-1','-2')), --职位性质（全职/兼职/实习）
  --description	自我描述
	des_content varchar2(100) --描述内容
);

insert into coResume values(comResume_sql.nextval,'1001','百度团队','团队图片','CEO','这是一个测试描述','百度搜索','www.baidu.com','产品图片','强大的搜索引擎','公司深度','深度链接');
 --resume	公司简历表(详情)
create table coResume(
	cor_id number primary key,
	c_id number constraint fk_coR_id references company(comp_id),
 --company_team 公司管理团队
	ct_name varchar2(20),  --团队名称
	ct_picPath varchar2(20),	--图片路径
	ct_job varchar2(20),	--团队职位
	ct_tdesc varchar2(100),	--团队描述
 --product 产品
	pro_name varchar2(10),	--公司产品
	pro_link varchar2(20),	--产品链接
	pro_picPath varchar2(20),	--图片路径
	pro_pdesc varchar2(100), --产品描述
 --deepness 公司深度
 	de_name varchar2(20),	--公司深度名称
 	dee_link varchar2(20)	--公司深度链接
);

 --succeed	作品展示
create table succeed(
	suc_id number primary key,
	tkf_id number constraint fk_suc_id references usResume(usr_id),
	suc_name varchar2(10),	--作品名称
	suc_link varchar2(10)	--作品链接
);
 --experience	工作经历
create table experience(
	exp_id number  primary key,
	tkf_id number constraint fk_exp_id references usResume(usr_id),
	exp_company_name varchar2(10),	--工作公司
	exp_job_name varchar2(10),	--工作职位
	exp_start_year varchar2(20),	--起始时间
	exp_end_year varchar2(20)   --结束时间
);
 --educationa 个人学历
create table educationa(
	edu_id number primary key,
	tkf_id number constraint fk_edu_id references usResume(usr_id),
	edu_shool_name varchar2(20),  --学校名称
	edu_major varchar2(10), --所学专业
	edu_educationa varchar2(20), --学历
	edu_start_year varchar2(20),-- 开始年份
	edu_end_year varchar2(20) --毕业年份
);

--收藏职位
create table collect(
	  col_id number primary key,
	  tkf_id number constraint fk_col_id references tkfuser(us_id),
	  col_job_id varchar2(10) 	--职位id
);
--订阅职位
create table take(
	  tak_id number primary key,
	  tkf_id number constraint fk_tak_id references tkfuser(us_id),
	  tak_job_id varchar2(10) ,	--职位id
	  tak_email varchar2(50) UNIQUE,   --邮箱 
	  tak_time varchar2(10),	--接收时间
	  tak_job_name varchar2(20), --职位名称
	  tak_job_city varchar2(20),	--工作城市
	  tak_state varchar2(50),	--发展状态
	  tak_territory varchar2(50),	--行业领域
	  tak_min_salary varchar2(10),	--工资
	  tak_max_salary varchar2(10)	--工资
);

insert into tag values(tag_sql.nextval,'1001','五险一金');
--tag公司标签
create table tag(
	tag_id number primary key,
	c_id number constraint fk_tag_id references company(comp_id),	--外键关联
	tag_name varchar2(20)	--标签名称
);
insert into invest values(invest_sql.nextval,1001,'支付宝金融','上市公司');
--invest 投资机构
create table  invest(
	inv_id number primary key,
	c_id number constraint fk_inv_id references company(comp_id),	--外键关联
	inv_name varchar2(20),	--投资机构名称
	inv_state varchar2(20)	--投资机构发展阶段
) ;
select * from job
insert into job 
values(job_sql.nextval,'1001','五险一金','qq客服','客服联系','全职','3k','5k','2017-04-05','本科','休息时间多','工作职责','任职要求',
'其他','0','-1');
insert into job 
values(job_sql.nextval,'1001','年终奖金翻倍','微信客服','客服联系','全职','4k','6k','2017-04-07','本科','休息时间少','工作职责','任职要求',
'其他','0','-1');
--职位表
create table job(
  job_id number primary key,
  c_id number not null,
  job_tags varchar2(30) ,  --标签 （股票期权/五险一金）
  job_name varchar2(20) ,  --名称
  job_department  varchar2(20) , --职位部门 
  job_nature varchar2(20) , --职位性质（全职/兼职/实习）
  job_min_salary varchar2(10) ,  --最少工资
  job_max_salary varchar2(10),  --最多工资
  job_ftime varchar2(10)  ,--发布时间
  job_education varchar2(50) ,  --学历要求,
  job_tempt varchar2(100),  --职位诱惑
  job_responsibility varchar2(100) ,--工作职责
  job_need varchar2(100) ,--任职要求
  job_rests varchar2(100) ,--其他
  job_number varchar2(100), --点击量
  job_state varchar2(10) check(job_state in('-0','-1')), --职位状态   （在线职位/下线职位）
   foreign key (c_id) references company(comp_id) --外键关联
);
select * from job

--职位分类表
create table job_class(
  jc_id number primary key ,
  jc_name varchar2(20) not null
);
insert into JOB_CLASS values(jobClass_sql.nextval,'编程');

----------------------------------------------------------------------------------

----------------------------------------------------------------------------------

----------------------------------------------------------------------------------

select * from job where c_id=1001
insert into job values(job_id,c_id,job_tags,job_name,job_department,job_nature,job_min_salary,job_max_salary,job_request)
insert into job values(job_sql.nextval,1001,'编程','qq客服','网络客服','初级客服','3k','3.5k','2017-4-3','研究生')
insert into job values(job_sql.nextval,1001,'编程','微信客服','网络客服','初级客服','3k','5k','2017-4-3','本科')

update job set job_request='清华硕士' where job_id=1001
--select tkfuser_sql.nextval from dual;
--drop sequence jobcalss_sql--用户信息序列
alter table tkfuser modify (us_id varchar2(30));
--删除表
drop table admin;
drop table login;
drop table tkfuser;--用户基本信息
	drop table usResume;--信息
		drop table educationa;--教育信息
		drop table experience;--工作经验
		drop table succeed;	--作品展示
		drop table collect;	--收藏
		drop table take;	--订阅
drop table company;--公司基本信息
	drop table coResume;--信息
		drop table invest;--投资机构
		drop table tag;--公司标签
	drop table job_class; --职位类别
		drop table job;--职位信息
--删除序列
drop sequence admin_sql;
drop sequence login_sql;
drop sequence tkfuser_sql;
	drop sequence usResume_sql;
	  drop sequence succeed_sql; 
	  drop sequence experience_job_sql;        
	  drop sequence educationa_sql;
	  drop sequence collect_sql;
	  drop sequence take_job_sql;
drop sequence company_sql;
	  drop sequence comResume_sql;
		drop sequence tag_sql;
		drop sequence invest_sql;
	drop sequence jobClass_sql;
		drop sequence job_sql;
--创建序列
--select sequence
create sequence admin_sql INCREMENT BY 1 START WITH 1001 ;--管理员序列序列
create sequence login_sql INCREMENT BY 1 START WITH 1001 ;--登录序列
create sequence tkfuser_sql INCREMENT BY 1 START WITH 1001 ;--个人信息序列
create sequence usResume_sql INCREMENT BY 1 START WITH 1001 ;--简历序列
  create sequence succeed_sql INCREMENT BY 1 START WITH 1001 ;--作品展示序列
  create sequence experience_job_sql INCREMENT BY 1 START WITH 1001 ;--工作经历序列
  create sequence educationa_sql INCREMENT BY 1 START WITH 1001 ;--学历序列
  create sequence collect_sql INCREMENT BY 1 START WITH 1001 ;--收藏序列
  create sequence take_job_sql INCREMENT BY 1 START WITH 1001 ;--订阅序列
create sequence company_sql INCREMENT BY 1 START WITH 1001 ;--公司序列
create sequence comResume_sql INCREMENT BY 1 START WITH 1001 ;--公司简历/信息序列
	create sequence tag_sql INCREMENT BY 1 START WITH 1001 ;--公司标签
	create sequence invest_sql INCREMENT BY 1 START WITH 1001 ;--投资结构序列
create sequence jobClass_sql INCREMENT BY 1 START WITH 1001 ;--职位类别序列
	create sequence job_sql INCREMENT BY 1 START WITH 1001 ;--职位序列
