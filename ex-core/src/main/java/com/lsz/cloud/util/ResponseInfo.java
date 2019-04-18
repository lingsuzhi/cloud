package com.lsz.cloud.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResponseInfo<T> implements Serializable {
    public static final String KEY_CODE = "code";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_DATA = "data";
    public static final String CODE_SUCCESS = "0000";
    public static final String CODE_ERROR = "9999";
    public static final String CODE_SUCCESS_MSG = "成功";
    public static final String CODE_ERROR_MSG = "系统异常，请稍后再试";
    private static final long serialVersionUID = 0x20170713;
    private String code;

    private String message;

    private T data;

    public static <T> ResponseInfo<T> success(T data) {
        return new ResponseInfo<>(CODE_SUCCESS, CODE_SUCCESS_MSG, data);
    }

    public static <T> ResponseInfo<T> assertion(T data) {
        if (data != null) {
            return success(data);
        } else {
            return error(data);
        }
    }

    public static <T> ResponseInfo<T> error(T data) {
        return new ResponseInfo<>(CODE_ERROR, CODE_ERROR_MSG, data);
    }

    public static <T> ResponseInfo<T> error(String code, T data) {
        return new ResponseInfo<>(code, CODE_ERROR_MSG, data);
    }
}
