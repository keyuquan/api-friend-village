package com.village.friend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthCodeMapper {
    @Insert("insert into  auth_code(username,auth_code,token) values (#{username},#{authCode},#{token}) on  duplicate key update  auth_code=#{authCode} ,token=#{token}")
    Integer addAuthCode(String username, String authCode, String token);
}
