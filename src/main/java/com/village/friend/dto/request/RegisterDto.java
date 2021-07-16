package com.village.friend.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data

@ApiModel(description = "注册请求")
public class RegisterDto {
    @ApiModelProperty(notes = "账户")
    String name;
    @ApiModelProperty(notes = "密码")
    String pwd;
    @ApiModelProperty(notes = "电话")
    String phone;
    @ApiModelProperty(notes = "性别:1男2女")
    Integer sex;
    @ApiModelProperty(notes = "年龄")
    Integer age;
    @ApiModelProperty(notes = "生日")
    String birthday;
    public RegisterDto() {}
}
