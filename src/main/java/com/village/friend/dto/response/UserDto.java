package com.village.friend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "用户信息")
public class UserDto {
    @ApiModelProperty(notes = "账户")
    String username;
    @ApiModelProperty(notes = "头像地址")
    String avatarurl;
    @ApiModelProperty(notes = "昵称")
    String nickname;
    @ApiModelProperty(notes = "token")
    String token;

    public UserDto() {

    }

    public UserDto(String username, String nickname, String avatarurl, String token) {
        this.username = username;
        this.avatarurl = avatarurl;
        this.nickname = nickname;
        this.token = token;
    }
}
