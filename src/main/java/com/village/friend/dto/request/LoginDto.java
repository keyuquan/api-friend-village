package com.village.friend.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "登录请求")
public class LoginDto {
    @ApiModelProperty(notes = "账户")
    String username;
    @ApiModelProperty(notes = "密码")
    String password;

    public LoginDto() {
    }

    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
