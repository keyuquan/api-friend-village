package com.village.friend.mapper;

import com.village.friend.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username} ")
    UserEntity findUserByName(String username);

    @Insert("insert into  user(username,password,nickname,avatarurl,gender) values (#{username},#{password},#{nickname},#{avatarurl},#{gender}) ")
    Integer addUser(String username, String password, String nickname, String avatarurl, Integer gender);

}
