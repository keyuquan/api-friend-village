package com.village.friend.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 此类的描述是：
 *
 * @author ant_li@qq.com
 * @createTime 2019-07-31
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "数据请求对象")
public class AuthRequest {

    @ApiModelProperty(notes = "账户")
    String username;

    @ApiModelProperty(notes = "token")
    private String token;

}
