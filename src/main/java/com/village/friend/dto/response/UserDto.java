package com.village.friend.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户信息")
public class UserDto {
    @ApiModelProperty(notes = "账户")
    String name;
    @ApiModelProperty(notes = "头像地址")
    String headUrl;
    public UserDto() {
    }
    public UserDto(String name, String headUrl) {
        this.name = name;
        this.headUrl = headUrl;
    }
}
