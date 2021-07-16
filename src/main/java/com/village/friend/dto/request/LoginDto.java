package com.village.friend.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "登录请求")
public class LoginDto {
    @ApiModelProperty(notes = "账户")
    String name;
    @ApiModelProperty(notes = "密码")
    String pwd;

    public LoginDto() {
    }

    public LoginDto(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }
}
