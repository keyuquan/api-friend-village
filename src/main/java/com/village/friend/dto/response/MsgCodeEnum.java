package com.village.friend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 响应码枚举：
 * code=0表示成功，code<0表示出错，-1到-9为系统保留异常码
 *
 * @author ant_li@qq.com
 * @createTime 2019-07-31
 */
@Getter
@AllArgsConstructor
@ToString
public enum MsgCodeEnum {


    /**
     * 处理成功
     */
    SUCCESS("200", "ok"),
    SYSTEM_INNER_ERROR("404", "系统内部错误");
    private String code;
    private String msg;


}
