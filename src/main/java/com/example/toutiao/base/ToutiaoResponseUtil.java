package com.example.toutiao.base;


import com.example.toutiao.exception.ToutiaoException;

public class ToutiaoResponseUtil<T> {
    /**
     * 成功响应返回数据
     */
    public static <T> ToutiaoBaseResponse<T> success() {
        return new ToutiaoBaseResponse<T>(ToutiaoStateCode.SUCCESS.getCode(), ToutiaoStateCode.SUCCESS.getMessage());
    }
    /**
     * 成功响应返回数据
     */
    public static <T> ToutiaoBaseResponse<T> success(T t) {
        return new ToutiaoBaseResponse<>( ToutiaoStateCode.SUCCESS.getCode(), ToutiaoStateCode.SUCCESS.getMessage(), t);
    }

    /**
     * 错误响应返回数据
     */
    public static <T> ToutiaoBaseResponse<T> error(ToutiaoErrorCode exception) {
        return new ToutiaoBaseResponse<>(exception.getCode(),exception.getMessage());
    }

    /**
     * 支持输入增加输入自定义信息
     */
    public static <T> ToutiaoBaseResponse<T> error(ToutiaoException e) {
        return new ToutiaoBaseResponse<>(e.getErrCode(), e.getErrMsg());
    }



}
