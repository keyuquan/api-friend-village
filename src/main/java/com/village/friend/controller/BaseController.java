package com.village.friend.controller;
import com.village.friend.constant.MsgCodeEnum;
import com.village.friend.dto.response.BaseResponse;

public class BaseController<T> {
    public BaseResponse<T> resp(MsgCodeEnum msgCodeEnum, T t) {
        return new BaseResponse<>(msgCodeEnum, t);
    }
}
