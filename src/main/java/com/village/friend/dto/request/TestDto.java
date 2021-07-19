package com.village.friend.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "登录请求")
public class TestDto extends BaseRequest {
    @ApiModelProperty(notes = "账户")
    String username;

    public TestDto() {
    }

    public TestDto(String username) {
        this.username = username;
    }
}
