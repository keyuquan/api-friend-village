package com.village.friend.service.impl;

import com.village.friend.entity.User;
import com.village.friend.mapper.UserMapper;
import com.village.friend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserByName(String userName) {
        return userMapper.findUserByName(userName);
    }

    @Override
    public Integer addUser(User user) {
        return  userMapper.addUser(user.getName(),user.getPwd(),user.getAge(),user.getSex(),user.getBirthday()) ;
    }
}
