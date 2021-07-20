drop  table  user ;
CREATE TABLE `user` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
`username` varchar(200) DEFAULT NULL COMMENT '账号',
`password` varchar(200) DEFAULT NULL COMMENT '密码',
`nickname` varchar(200) DEFAULT NULL COMMENT '昵称',
`avatarurl` varchar(200) DEFAULT NULL COMMENT '头像',
`phone` varchar(200) DEFAULT NULL COMMENT '电话',
`mail` varchar(200) DEFAULT NULL COMMENT '邮箱',
`gender` int DEFAULT NULL COMMENT '性别 1男 ,2 女',
`birth` varchar(200) DEFAULT NULL COMMENT '生日',
`sign` varchar(200) DEFAULT NULL COMMENT '签名',
`ext` varchar(1024) DEFAULT NULL COMMENT '自定义字段',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立时间',
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
PRIMARY KEY (`id`),
UNIQUE KEY `user_name` (`username`),
KEY `update_time` (`update_time`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

insert into  user(username,password,nickname,avatarurl,phone,mail,gender,birth,sign,ext) values
('kequan','123456','哈哈哥','www.baidu.com/','18818406784','1242356@qq.com',1,'1990-11-05','gggddddd','') ;