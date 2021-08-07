package com.village.friend.entity;

import lombok.Data;

@Data
public class AuthCodeEntity {
    String username;
    String authCode;
    String token;
    String createTime;
    String updateTime;
}
