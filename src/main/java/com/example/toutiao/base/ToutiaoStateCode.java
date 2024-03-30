package com.example.toutiao.base;


public enum ToutiaoStateCode {

    SUCCESS("100","SUCCESS"),
    ;

    private String code;
    private String message;

    ToutiaoStateCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
