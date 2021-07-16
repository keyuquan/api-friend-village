package com.village.friend.controller;


import com.village.friend.dto.response.BaseResponse;
import com.village.friend.dto.response.MsgCodeEnum;

public class BaseController<T>  {

    public BaseResponse<T> retSuccess(T t) {
        return new BaseResponse<>(MsgCodeEnum.SUCCESS,t);
    }

    public BaseResponse<T> retError(T t) {
        return new BaseResponse<>(MsgCodeEnum.SYSTEM_INNER_ERROR,t);
    }

}
