package com.village.friend.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "注册请求")
public class RegisterDto {
    @ApiModelProperty(notes = "账户")
    String username;
    @ApiModelProperty(notes = "验证码")
    String authCode;
    @ApiModelProperty(notes = "性别:1男 2女")
    Integer gender;

    public RegisterDto() {
    }
}
