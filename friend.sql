CREATE TABLE user (
id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
name VARCHAR(200) COMMENT '账号',
pwd  VARCHAR(200) COMMENT '密码',
age  int COMMENT '年龄',
sex  int COMMENT '性别 1男 ,2 女',
birthday  VARCHAR(200) COMMENT '出生年月',
create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立时间',
update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间'
) COMMENT='用户表' ;

insert into  user(name,pwd,age,sex,birthday) values('kequan','123456',30,1,'1990-11-05') ;
SELECT  *  from user ;