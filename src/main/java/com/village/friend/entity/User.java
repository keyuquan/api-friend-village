package com.village.friend.entity;

import lombok.Data;

@Data
public class User {
    String username;
    String password;
    String nickname;
    String avatarurl;
    String phone;
    String mail;
    String birth;
    Integer gender;
    String sign;
    String ext;

    public User() {
    }
}


