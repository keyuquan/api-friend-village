package com.village.friend.mapper;

import com.village.friend.entity.AuthCodeEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AuthCodeMapper {
    @Insert("insert into  auth_code(username,auth_code,token) values (#{username},#{authCode},#{token}) on  duplicate key update  auth_code=#{authCode} ,token=#{token}")
    Integer addAuthCode(String username, String authCode, String token);

    @Select("select username,auth_code authCode,token  from auth_code where username = #{username}")
    AuthCodeEntity findByUsername(String username);
}
