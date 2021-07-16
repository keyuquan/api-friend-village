package com.village.friend.dto.response;

import lombok.Data;

@Data
public class ResponseBase<T> {

    private String code;
    private String msg;
    private T data;

}
