insert into admin values(1,'aaa','a');
update admin set ad_pwd='6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2' where ad_id=1
select * from admin;
---admin管理员
alert table admin add (ad_email varchar2(50));
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
<<<<<<< HEAD
--insert into tkfuser values (login_sql.nextval,'李四',null,'我是李四',default,'衡大','三年','12345678901','111111@qq.com');
select * from LOGIN
select * from tkfuser
select * from LOGIN
=======


create table otherlogin(
  ol_id varchar2(50) primary key ,
  ol_name varchar2(50),
  ol_email varchar2(20)
);
--drop table otherlogin
select * from otherlogin
>>>>>>> branch 'master' of ssh://git@github.com/wys12/TaoKeFu
--insert into tkfuser values (login_sql.nextval,'李四',null,'我是李四',default,'衡大','三年','12345678901','111111@qq.com');
--user  个人信息  
update set tkfuser us_name=${us_name},us_picpath=${us_picpath},us_intro=${us_intro},
		us_sex=${us_sex},us_educationa=${us_educationa},us_work_year=${us_work_year},us_phone=${us_phone}
		 where us_id=${us_id} or openId=${openId} or us_email=${us_email}
insert into tkfuser us_name=${us_name},us_picpath=${us_picpath},us_picpath=${us_picpath},us_intro=${us_intro},
us_sex=${us_sex},us_educationa=${us_educationa},us_work_year=${us_work_year},us_phone=${us_phone} 
where us_id=${us_id} or us_email=${us_email} or openId=${openId}  
select * from tkfuser
create table tkfuser(
  us_id number primary key,	--id等于 login id
  us_name varchar2(10) ,	--名称
  us_picpath varchar2(50),      --图片路径
  us_intro varchar2(100),       --简介
  us_sex  varchar2(3) check (us_sex in('男','女')),         --性别
  us_educationa varchar2(10) ,  -- 学历
  us_work_year  varchar2(20) ,  --工作年限
  us_phone varchar2(10) ,       --联系方式
  us_email varchar2(30) UNIQUE ,  --邮箱 
  openId varchar2(50) UNIQUE
);
--insert into company values
--(company_sql.nextval,'百度','百度搜索'，'logo','互联网','上市','13613931201','baidu.1603.com','www.baidu.com','北京',
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

select * from usResume login tkfuser
insert into usResume(usr_id,tkf_id) values(usResume_sql.nextval,)
--drop table usResume
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
 
 --product 产品
	pro_name varchar2(10),	--公司产品
	pro_link varchar2(20),	--产品链接
	pro_picPath varchar2(20),	--图片路径
	pro_pdesc varchar2(100), --产品描述
 --deepness 公司深度
 	de_name varchar2(20),	--公司深度名称
 	dee_link varchar2(20)	--公司深度链接
);
--company_team 公司管理团队
create table company_team(
	ct_name varchar2(20),  --团队名称
	ct_picPath varchar2(20),	--图片路径
	ct_job varchar2(20),	--团队职位
	ct_tdesc varchar2(100),	--团队描述
);
	select * from job j join company comp on j.c_id = comp.comp_id join coResume cor on cor.c_id = comp.comp_id join tag t on cor.c_id=t.c_id join invest inv on inv.c_id = t.c_id where j.job_name like '%微信%' 
 --succeed	作品展示
create table succeed(
	suc_id number primary key,
	tkf_id number constraint fk_suc_id references usResume(usr_id),
	suc_name varchar2(20),	--作品名称
	suc_link varchar2(30)	--作品链接
);
 --experience	工作经历
create table experience(
	exp_id number  primary key,
	tkf_id number constraint fk_exp_id references usResume(usr_id),
	exp_company_name varchar2(30),	--工作公司
	exp_job_name varchar2(30),	--工作职位
	exp_start_year varchar2(20),	--起始时间
	exp_end_year varchar2(20)   --结束时间
);
 --educationa 个人学历
create table educationa(
	edu_id number primary key,
	tkf_id number constraint fk_edu_id references usResume(usr_id),
	edu_shool_name varchar2(30),  --学校名称
	edu_major varchar2(30), --所学专业
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
	  tak_job_name varchar2(30), --职位名称
	  tak_job_city varchar2(20),	--工作城市
	  tak_state varchar2(50),	--发展状态
	  tak_territory varchar2(50),	--行业领域
	  tak_min_salary varchar2(10),	--工资
	  tak_max_salary varchar2(10)	--工资
);
select * from tkfuser
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
	inv_name varchar2(30),	--投资机构名称
	inv_state varchar2(20)	--投资机构发展阶段
) ;
insert into job 
values(job_sql.nextval,'1001','五险一金','qq客服','客服联系','全职','3k','5k','2017-04-05','本科','休息时间多','工作职责','任职要求',
'其他','0','-1');
insert into job 
values(job_sql.nextval,'1001','年终奖金翻倍','微信客服','客服联系','全职','4k','6k','2017-04-07','本科','休息时间少','工作职责','任职要求',
'其他','0','-1');
--职位表
select * from job
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

select * from job where c_id=1001
insert into job values(job_id,c_id,job_tags,job_name,job_department,job_nature,job_min_salary,job_max_salary,job_request)
insert into job values(job_sql.nextval,1001,'编程','qq客服','网络客服','初级客服','3k','3.5k','2017-4-3','研究生')
insert into job values(job_sql.nextval,1001,'编程','微信客服','网络客服','初级客服','3k','5k','2017-4-3','本科')

update job set job_request='清华硕士' where job_id=1001
--select tkfuser_sql.nextval from dual;
--drop sequence jobcalss_sql--用户信息序列
alter table tkfuser modify (us_id varchar2(30));
--	删除表
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
--	删除序列
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
<<<<<<< HEAD
	
=======
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





insert into admin values(1,'admin','3207c5b7f39532e0ca9008b428ed420e54e91227');
---admin管理员
select * from admin
drop table admin
create table admin(
  ad_id number primary key ,
  ad_name varchar2(30) not null,
  ad_pwd varchar2(50) not null
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
insert into company (comp_id,comp_email) values (company_sql.nextval,'12345@163.com');
select * from company;
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
	usr_id number constraint fk_suc_id references usResume(usr_id),
	suc_name varchar2(10) not null,	--作品名称
	suc_link varchar2(10) not null	--作品链接
);
 --experience	工作经历
create table experience(
	exp_id number  primary key,
	usr_id number constraint fk_exp_id references usResume(usr_id),
	exp_company_name varchar2(10) not null,	--工作公司
	exp_job_name varchar2(10) not null,	--工作职位
	exp_start_year varchar2(20) not null,	--起始时间
	exp_end_year varchar2(20) not null   --结束时间
);
 --educationa 个人学历
create table educationa(
	edu_id number primary key,
	usr_id number constraint fk_edu_id references usResume(usr_id),
	edu_shool_name varchar2(20) not null,  --学校名称
	edu_major varchar2(10) not null, --所学专业
	edu_educationa varchar2(20) not null, --学历
	edu_start_year varchar2(20) not null,-- 开始年份
	edu_end_year varchar2(20) not null --毕业年份
);

--收藏职位
create table collect(
	  col_id number primary key,
	  tkf_id number constraint fk_col_id references tkfuser(us_id),
	  col_job_id varchar2(10) not null	--职位id
);
--订阅职位
create table take(
	  tak_id number primary key,
	  tkf_id number constraint fk_tak_id references tkfuser(us_id),
	  col_job_id varchar2(10) not null,	--职位id
	  col_email varchar2(50) not null UNIQUE,   --邮箱 
	  col_time varchar2(10) not null,	--接收时间
	  col_job_name varchar2(20) not null, --职位名称
	  col_job_city varchar2(20) not null,	--工作城市
	  col_state varchar2(50) not null,	--发展状态
	  col_territory varchar2(50) not null,	--行业领域
	  col_min_salary varchar2(10) not null,	--工资
	  col_max_salary varchar2(10) not null	--工资
);
---------
--tag公司标签
create table tag(
	tag_id number primary key,
	c_id number constraint fk_tag_id references company(comp_id),	--外键关联
	tag_name varchar2(20)	--标签名称
);
--invest 投资机构
create table  invest(
	inv_id number primary key,
	c_id number constraint fk_inv_id references company(comp_id),	--外键关联
	inv_name varchar2(20),	--投资机构名称
	inv_state varchar2(20)	--投资机构发展阶段
) ;
--职位表
create table job(
  job_id number primary key,
  c_id number not null,
  job_tags varchar2(30) ,  --标签 （股票期权/五险一金）
  job_name varchar2(20) ,  --名称
  job_department  varchar2(20) , --职位部门 
  job_nature varchar2(20) , --职位性质（全职/兼职/实习）
  job_min_salary varchar2(10) ,  --最少工资
  job_max_salary varchar2(10) ,  --最多工资
  job_ftime varchar2(10)  ,--发布时间
  job_education varchar2(50) ,  --学历要求,
  job_tempt varchar2(100),  --职位诱惑
  job_responsibility varchar2(100),--工作职责
  job_need varchar2(100) ,--任职要求
  job_rests varchar2(100) ,--其他
  job_number varchar2(100) , --点击量
  job_state varchar2(10) check(job_state in('-0','-1')), --职位状态   （在线职位/下线职位）
  foreign key (c_id) references company(comp_id) --外键关联
);
insert into job (job_id,c_id,job_tags,job_name,job_department,job_nature,job_min_salary, job_max_salary,job_tempt, job_need)
values(job_sql.nextval,1002,'编程','qq客服','网络客服','兼职','3k','3.5k','2017-4-7','研究生')
select * from  job;
drop table job --company
--职位分类表
select * from JOB_CLASS
create table job_class(
  jc_id number primary key ,
  jc_name varchar2(20) not null
);
insert into JOB_CLASS values(jobClass_sql.nextval,'编程');

>>>>>>> branch 'master' of ssh://git@github.com/wys12/TaoKeFu
----------------------------------------------------------------------------------
<<<<<<< HEAD
=======

----------------------------------------------------------------------------------

----------------------------------------------------------------------------------

select * from job where c_id=1001
insert into job() values(job_id,c_id,job_tags,job_name,job_department,job_nature,job_min_salary,job_max_salary,job_request)
insert into job values(job_sql.nextval,1001,'编程','微信客服','网络客服','初级客服','3k','5k','2017-4-3','本科')

update job set job_request='清华硕士' where job_id=1001
--select tkfuser_sql.nextval from dual;
--drop sequence jobcalss_sql--用户信息序列

>>>>>>> branch 'master' of ssh://git@github.com/wys12/TaoKeFu
--查询
select * from admin--管理员
select * from login
select * from tkfuser--用户
	select * from educationa--教育信息
	--select * from project--项目经验
	select * from hope_job--工作期望
	select * from description--自我描述
	select * from experience--工作经历
	select * from succeed --项目成果
	
select * from company--公司
	select * from tag--公司标签
	select * from company_team--公司团队
	select * from product--公司产品（项目）
select * from job_class--职位分类
	select * from job --职位信息
	
	select * from job j join company comp on j.c_id = comp.comp_id join product pr on pr.c_id = comp.comp_id join product pro on pro.c_id = pr.c_id join tag t on pro.c_id=t.c_id where j.job_id=1001
	
select *
  from job j
  join company comp
    on j.c_id = comp.comp_id
  join product pr
    on pr.c_id = comp.comp_id
  join product pro
    on pro.c_id = pr.c_id
 where j.job_id = 1001
<<<<<<< HEAD
     
 --resume	用户简历表(详情)
create table usResume(
	tkf_id number c_id number constraint tkf_id references company(comp_id),
	c_id number constraint fk_c_id references company(comp_id),
 --resume	简历
	usr_id number primary key,
	usr_name varchar2(10) not null,	--简历名称
	usr_state varchar2(10)	--简历状态（投递成功/简历查看/通过初选/通知面试/不合适）
 --educationa 个人学历
	edu_shool_name varchar2(20) ,  --学校名称
	edu_major varchar2(10), --所学专业
	edu_educationa varchar2(20) , --学历
	edu_start_year varchar2(20) ,-- 开始年份
	edu_end_year varchar2(20) , --毕业年份
 --hope_job	期望工作
	hj_name varchar2(10) ,	--职位名称
	hj_city varchar2(10) ,	--工作地址
	hj_salary varchar2(10) ,	--期望月薪 
	hj_state varchar2(100),  --职位状态   （在线职位/下线职位）
  --description	自我描述
	des_content varchar2(10), --描述内容
 --experience	工作经历
	exp_company_name varchar2(10),	--工作公司
	exp_job_name varchar2(10),	--工作职位
	exp_start_year varchar2(20),	--起始时间
	exp_end_year varchar2(20),   --结束时间
 --succeed	作品展示
	suc_name varchar2(10),	--作品名称
	suc_link varchar2(10)	--作品链接
	foreign key (c_id) references company(comp_id)
     
 --resume	用户简历表(详情)
create table usResume(
	tkf_id number c_id number constraint tkf_id references company(comp_id),
	c_id number constraint fk_c_id references company(comp_id),
 --resume	简历
	usr_id number primary key,
	usr_name varchar2(10) not null,	--简历名称
	usr_state varchar2(10)	--简历状态（投递成功/简历查看/通过初选/通知面试/不合适）
 --educationa 个人学历
	edu_shool_name varchar2(20) ,  --学校名称
	edu_major varchar2(10), --所学专业
	edu_educationa varchar2(20) , --学历
	edu_start_year varchar2(20) ,-- 开始年份
	edu_end_year varchar2(20) , --毕业年份
 --hope_job	期望工作
	hj_name varchar2(10) ,	--职位名称
	hj_city varchar2(10) ,	--工作地址
	hj_salary varchar2(10) ,	--期望月薪 
	hj_state varchar2(100),  --职位状态   （在线职位/下线职位）
  --description	自我描述
	des_content varchar2(10), --描述内容
 --experience	工作经历
	exp_company_name varchar2(10),	--工作公司
	exp_job_name varchar2(10),	--工作职位
	exp_start_year varchar2(20),	--起始时间
	exp_end_year varchar2(20),   --结束时间
 --succeed	作品展示
	suc_name varchar2(10),	--作品名称
	suc_link varchar2(10)	--作品链接
	foreign key (c_id) references company(comp_id)
=======
	
	
select * from educationa where tkf_id=1061
select * from job where job_name='前端开发'
--创建序列
--select sequence
create sequence admin_sql INCREMENT BY 1 START WITH 1001 ;--管理员序列序列
create sequence login_sql INCREMENT BY 1 START WITH 1001 ;--登录序列
create sequence tkfuser_sql INCREMENT BY 1 START WITH 1001 ;--个人信息序列
	create sequence edu_sql INCREMENT BY 1 START WITH 1001 ;--学历序列
	create sequence project_sql INCREMENT BY 1 START WITH 1001 ;--项目经验序列
	create sequence hope_job_sql INCREMENT BY 1 START WITH 1001 ;--期望序列
create sequence com_sql INCREMENT BY 1 START WITH 1001 ;--公司序列
	create sequence tag_sql INCREMENT BY 1 START WITH 1001 ;--公司标签序列
	create sequence company_team_sql INCREMENT BY 1 START WITH 1001 ;--公司团队序列
	create sequence product_sql INCREMENT BY 1 START WITH 1001 ;--公司产品序列
create sequence jobClass_sql INCREMENT BY 1 START WITH 1001 ;--职位类别序列
	create sequence job_sql INCREMENT BY 1 START WITH 1001 ;--职位序列



--select tkfuser_sql.nextval from dual;
--drop sequence jobcalss_sql--用户信息序列

---admin
select * from admin;
create table admin(
  ad_id number primary key ,
  ad_name varchar2(10) not null,
  ad_pwd varchar2(10) not null
);
insert into admin values(1,'aaa','a');

select * from login;
insert into login values (login_sql.nextval,'123@qq.com','6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2','1');
update LOGIN set l_type=0 where l_id=1041

--insert into login values (login_sql.nextval,'123@qq.com','6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2','1');

create table login(
  l_id number primary key ,
  l_email varchar2(20) not null UNIQUE,
  l_pwd varchar2(100) not null,
  l_type varchar2(10) check (l_type in('0','1'))  not null
  other_l_id varchar2(50),
);

create table otherlogin(
  ol_id varchar2(50) primary key ,
  ol_name varchar2(50),
  ol_email varchar2(20)
);
drop table otherlogin
select * from otherlogin

--insert into tkfuser values (login_sql.nextval,'李四',null,'我是李四',default,'衡大','三年','12345678901','111111@qq.com');
--  个人信息user  --个人介绍
create table tkfuser(
  us_id varchar2(50) primary key,
  us_name varchar2(20) ,
  us_picpath varchar2(50),      --图片路径
  us_intro varchar2(100),       --简介
  us_sex  varchar2(3) ,         --性别
  us_educationa varchar2(10) ,  -- 学历
  us_work_year  varchar2(20) ,  --工作年限
  us_phone varchar2(11) ,       --联系方式
  us_email varchar2(50),   --邮箱 
  openId varchar2(50) 
);
select * from tkfuser where openId = 'B74616B0E1E0AB1DA413995D5EE8C101'
delete tkfuser where us_id = '1001'

--insert into educationa values(edu_sql.nextval,tkf_id,edu_shoolname,edu_major,edu_educationa,edu_graduation_year);
--教育经验表
create table educationa(
  edu_id number primary key,
  tkf_id number not null,
  edu_shool_name varchar2(20) not null,  --学校名称
  edu_major varchar2(10) not null, --所学专业
  edu_educationa varchar2(20) not null, --学历
  edu_graduation_year varchar2(20) not null, --毕业年份
  foreign key (tkf_id) references tkfuser(us_id),
);


--项目经验  project
create table project(
  pro_id  number primary key,
  tkf_id number not null,
  pro_name varchar2(20)not null,
  pro_duty varchar2(10)not null,  --职责 
  pro_start_time varchar2(10)not null,
  pro_end_time varchar2(10)not null,
  pro_pdesc varchar2(200)not null,  --项目描述
  pro_link varchar2(30)not null,   --项目链接 
  foreign key (tkf_id) references tkfuser(us_id)
);


--期望工作 hope_job
create table hope_job(
  hj_id  number primary key,
  tkf_id number not null,
  hj_name varchar2(10)not null,
  hj_city varchar2(10)not null,
  hj_salary varchar2(10)not null,
  hj_state varchar2(100),   --说明
  foreign key (tkf_id) references tkfuser(us_id)
);

insert into company (comp_id,comp_name,comp_email ) values(com_sql.nextval,'百度','666666.qq.com')
--公司 company
create table company(
  comp_id number primary key,
  comp_name varchar2(10),
  comp_logo varchar2(50),
  comp_intor varchar2(50), 
  comp_phone varchar2(20),
  comp_email varchar2(100) not null UNIQUE,
  comp_link varchar2(255), 
  comp_city varchar2(20)
);

 insert into tag values(tag_sql.nextval,1001,'网络')
 insert into tag values(tag_sql.nextval,1001,'客服')
 insert into tag values(tag_sql.nextval,1001,'计算机')
select * from tag
update tag set c_id=1002 where tag_id=1002
delete tag where tag_id=1003
--公司标签
 create table tag(
  tag_id number primary key,
  c_id number not null,
  tag_name varchar2(50),
  foreign key (c_id) references company(comp_id)
 );
 
 insert into COMPANY_team (ct_id,c_id,ct_name,ct_tdesc) values (company_team_sql.nextval,1001,'编程开发','计算机行业的领头羊')
--公司管理团队
--drop table company_team
create table company_team(
  ct_id number primary key,
  c_id number not null,
  ct_name varchar2(20) not  null,  --
  ct_picPath varchar2(50),
  ct_job varchar2(20),   
  ct_tdesc varchar2(100),  --描述
  foreign key (ct_id) references company(comp_id)
);

insert into product (pro_id,c_id,pro_name,pro_link) values (product_sql.nextval,1001,'百度搜索','https://www.baidu.com')
--产品product
create table product(
  pro_id number  primary key,
  c_id number not null,
  pro_name varchar2(10) not null,
  pro_link varchar2(50) not null,
  pro_picPath varchar2(50) ,
  pro_pdesc varchar2(100),
  foreign key (c_id) references company(comp_id)
);

select * from company where comp_id=1001

select * from job where c_id=1001
insert into job values(job_id,c_id,job_tags,job_name,job_department,job_nature,job_min_salary,job_max_salary,job_request)
insert into job values(job_sql.nextval,1001,'编程','qq客服','网络客服','初级客服','3k','3.5k','2017-4-3','清华硕士')
insert into job values(job_sql.nextval,1001,'编程','微信客服','网络客服','初级客服','3k','5k','2017-4-3','本科')

update job set job_request='清华硕士' where job_id=1001
select * from COMPANY
--职位表
create table job(
  job_id number primary key,
  c_id number not null,
  job_tags varchar2(30)  not null,
  job_name varchar2(20) not null,
  job_department  varchar2(10) not null, --职位部门 
  job_nature varchar2(20) not null, --职位性质
  job_min_salary varchar2(10) not null,
  job_max_salary varchar2(10) not null,
  job_ftime varchar2(10) not null ,--发布时间
  job_request varchar2(50) not null,  --职位要求,
  
  job_tempt varchat2(100) not null,	--职位诱惑
  job_responsibility varchat2(100) not null,--工作职责
  job_need varchat2(100) not null,--职位需求详情
  jon_rests varchat2(100) not null,--其他
  jon_number varchat2(100) not null--点击量
   foreign key (c_id) references company(comp_id)
);
insert into JOB_CLASS values(jobClass_sql.nextval,'编程')

--职位分类表
select * from JOB_CLASS
create table job_class(
  jc_id number primary key ,
  jc_name varchar2(20) not null
);
>>>>>>> branch 'master' of ssh://git@github.com/wys12/TaoKeFu
