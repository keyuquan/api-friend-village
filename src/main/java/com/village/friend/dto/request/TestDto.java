package com.village.friend.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "登录请求")
public class TestDto extends AuthRequest {

    public TestDto() {
    }

}
