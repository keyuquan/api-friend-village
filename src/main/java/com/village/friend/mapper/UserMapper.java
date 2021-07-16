package com.village.friend.mapper;

import com.village.friend.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{userName} ")
    User findUserByName(String userName);

    @Insert("insert into  user(name,pwd,age,sex,birthday) values(#{name},#{pwd},#{age},#{sex},#{birthday})")
    Integer addUser(String name, String pwd, Integer age, Integer sex, String birthday);

}
