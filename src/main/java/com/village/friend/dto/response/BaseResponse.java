package com.village.friend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 此类的描述是：
 *
 * @author ant_li@qq.com
 * @createTime 2019-07-31
 *
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel( description ="数据返回对象")
public class BaseResponse<T> {
    /**
     * 返回码
     */
    @ApiModelProperty(notes = "返回码")
    private String code;
    /**
     * 返回信息
     */
    @ApiModelProperty(notes = "返回信息")
    private String msg;
    /**
     * 返回数据
     */
    @ApiModelProperty(notes = "返回数据")
    private T data;


    public BaseResponse() {}

    public BaseResponse(MsgCodeEnum msgCodeEnum) {
        this.code = msgCodeEnum.getCode();
        this.msg = msgCodeEnum.getMsg();
    }

    public BaseResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(MsgCodeEnum msgCodeEnum, T data) {
        this.code = msgCodeEnum.getCode();
        this.msg = msgCodeEnum.getMsg();
        this.data = data;
    }





}
