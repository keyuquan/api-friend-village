package com.village.friend.mapper;

import com.village.friend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user limit 1 ")
    User findUserByName(String userName);
}
