package com.village.friend.service;

import com.village.friend.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User findUserByName(String name);

    Integer addUser(User user);

     User findUserByNamAndPwd(String name, String pwd);
}
