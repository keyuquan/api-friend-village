package com.village.friend.dto.request;

import com.village.friend.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data

@ApiModel(description = "注册请求")
public class RegisterDto {
    @ApiModelProperty(notes = "账户")
    String username;
    @ApiModelProperty(notes = "密码")
    String password;
    @ApiModelProperty(notes = "昵称")
    String nickname;
    @ApiModelProperty(notes = "头像")
    String avatarurl;
    @ApiModelProperty(notes = "电话")
    String phone;
    @ApiModelProperty(notes = "邮件")
    String mail;
    @ApiModelProperty(notes = "性别:1男2女")
    Integer gender;
    @ApiModelProperty(notes = "生日")
    String birth;

    public RegisterDto() {
    }
}
