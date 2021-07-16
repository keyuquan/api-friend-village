package com.village.friend.service;

import com.village.friend.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User findUserByName(String userName);
}
