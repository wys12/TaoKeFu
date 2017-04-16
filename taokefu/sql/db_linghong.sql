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
alter table tkfuser modify(us_picpath varchar2(150)) 
select * from tkfuser where openId = 'B74616B0E1E0AB1DA413995D5EE8C101'
delete tkfuser where us_id = '1001'