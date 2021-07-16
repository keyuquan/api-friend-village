package com.village.friend.entity;

import lombok.Data;

@Data
public class User {
    String name;
    String pwd;
    Integer age;
    Integer sex;
    String birthday;

    public User(String name, String pwd, Integer age, Integer sex, String birthday) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
    }
}


