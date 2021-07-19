package com.village.friend.mapper;

import com.village.friend.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username} ")
    User findUserByName(String username);

    @Select("select username,password,nickname,avatarurl,phone,mail,gender,birth,sign,ext from user where username = #{username} and  password= #{password}")
    User findUserByNamAndPwd(String username, String password);

    @Insert("insert into  user(username,password,nickname,avatarurl,phone,mail,gender,birth,sign,ext) values (#{username},#{password},#{nickname},#{avatarurl},#{phone},#{mail},#{gender},#{birth},#{sign},#{ext})")
    Integer addUser(String username, String password, String nickname, String avatarurl, String phone, String mail, Integer gender, String birth, String sign, String ext);

}
