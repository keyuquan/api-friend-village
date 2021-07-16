package com.village.friend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBase<T> {

    private String code;
    private T data;

    public ResponseBase(T data, String code) {
        this.code = code;
        this.data = data;
    }

    public ResponseBase() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
