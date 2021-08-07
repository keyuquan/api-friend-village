package com.village.friend.entity;

import lombok.Data;

@Data
public class UserEntity {
    String username;
    String password;
    String nickname;
    String avatarurl;
    String mail;
    String birth;
    Integer gender;
    String sign;
    String ext;

    public UserEntity() {
    }
}


