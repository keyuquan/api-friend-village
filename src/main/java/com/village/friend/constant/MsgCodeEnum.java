package com.village.friend.constant;

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

    // 全局
    SUCCESS("200", "ok"),
    SYSTEM_INNER_ERROR("404", "系统内部错误"),
    // 注册相关
    REGISTER_EXISTING_ACCOUNT("1001", "账户已存在"),
    //登录相关
    LOGIN_ERROR_PWD("2001", "账户或者密码错误"),
    //auth 相关
    Auth_TIME_OUT("401", "登录超时,请重新登录");

    private String code;
    private String msg;


}
