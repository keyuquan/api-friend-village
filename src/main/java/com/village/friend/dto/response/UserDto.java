package com.village.friend.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户信息")
public class UserDto {
    @ApiModelProperty(notes = "账户")
    String userName;
    @ApiModelProperty(notes = "头像地址")
    String headUrl;
    public UserDto() {
    }
    public UserDto(String userName, String headUrl) {
        this.userName = userName;
        this.headUrl = headUrl;
    }
}
