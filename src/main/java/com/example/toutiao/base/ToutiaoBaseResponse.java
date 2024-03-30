package com.example.toutiao.base;

import lombok.Data;

import java.io.Serializable;


@Data
public class ToutiaoBaseResponse<T> implements Serializable {
    protected String code;

    protected String message;

    protected T data;

    public ToutiaoBaseResponse() {
    }

    public ToutiaoBaseResponse(String code) {
        this.code = code;
    }

    public ToutiaoBaseResponse(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public ToutiaoBaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ToutiaoBaseResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
