package com.village.friend.controller;


import com.village.friend.dto.response.BaseResponse;
import com.village.friend.dto.response.MsgCodeEnum;

public class BaseController<T> {
    public BaseResponse<T> resp(MsgCodeEnum msgCodeEnum, T t) {
        return new BaseResponse<>(msgCodeEnum, t);
    }
}
