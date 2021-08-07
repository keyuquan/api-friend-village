package com.village.friend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "注册返回信息")
public class RegisterResDto {
    @ApiModelProperty(notes = "账户")
    String username;
    @ApiModelProperty(notes = "token")
    String token;

    public RegisterResDto() {
    }

    public RegisterResDto(String username, String token) {
        this.username = username;
        this.token = token;
    }
}
