package com.village.friend.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "登录")
public class LoginDto {
    @ApiModelProperty(notes = "账户")
    String username;
    @ApiModelProperty(notes = "验证码")
    String authCode;

    public LoginDto() {
    }

    public LoginDto(String username, String authCode) {
        this.username = username;
        this.authCode = authCode;
    }
}
