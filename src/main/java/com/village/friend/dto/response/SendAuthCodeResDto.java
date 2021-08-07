package com.village.friend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "发送验证码返回信息")
public class SendAuthCodeResDto {
    @ApiModelProperty(notes = "验证码")
    String authCode;
}
