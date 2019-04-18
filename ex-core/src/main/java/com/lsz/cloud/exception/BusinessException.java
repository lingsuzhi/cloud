package com.lsz.cloud.exception;

import com.lsz.cloud.util.ResponseInfo;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -778142600038732285L;
    private String message;
    private String code;

    public BusinessException(String message) {
        this(ResponseInfo.CODE_ERROR, message);
    }

    public BusinessException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static BusinessException authException() {
        return new BusinessException("401", "访问被拒绝");
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public ResponseInfo<Object> getResponse() {
        return ResponseInfo.error(code, message);
    }
}
