package com.village.friend.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "发送验证码")
public class SendAuthCodeDto {
    @ApiModelProperty(notes = "电话")
    String phone;
}
