package com.example.toutiao.base;

import com.alibaba.fastjson.JSON;

public enum ToutiaoErrorCode {
    ACCOUNT_HAS_EXITED("0001", "账号名已存在"),
    ACCOUNT_NOT_EXIT("0002", "账号不存在"),
    PASSWORD_ERROR("0003", "密码错误"),
    SYSTEM_EXCEPTION("1000", "系统异常"),
    ;


    public final String code;
    public final String message;

    ToutiaoErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    public static String getMessage(String code) {
        ToutiaoErrorCode[] ErrorCodes = values();
        for (ToutiaoErrorCode ErrorCode : ErrorCodes) {
            if (ErrorCode.code.equals(code)) {
                return ErrorCode.message;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
