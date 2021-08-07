package com.village.friend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "登录返回信息")
public class LoginResDto {
    @ApiModelProperty(notes = "账户")
    String username;
    @ApiModelProperty(notes = "token")
    String token;

    public LoginResDto() {
    }

    public LoginResDto(String username, String token) {
        this.username = username;
        this.token = token;
    }
}
