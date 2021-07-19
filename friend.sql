drop  table  user ;
CREATE TABLE user (
id INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
username VARCHAR(200) COMMENT '账号',
password  VARCHAR(200) COMMENT '密码',
nickname VARCHAR(200) COMMENT '昵称',
avatarurl VARCHAR(200) COMMENT '头像',
phone VARCHAR(200) COMMENT '电话',
mail VARCHAR(200) COMMENT '邮箱',
gender  int COMMENT '性别 1男 ,2 女',
birth  VARCHAR(200) COMMENT '生日',
sign VARCHAR(200) COMMENT '签名',
ext VARCHAR(1024) COMMENT '自定义字段',
create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立时间',
update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间'
) COMMENT='用户表' ;

insert into  user(username,password,nickname,avatarurl,phone,mail,gender,birth,sign,ext) values
('kequan','123456','哈哈哥','www.baidu.com/','18818406784','1242356@qq.com',1,'1990-11-05','gggddddd','') ;