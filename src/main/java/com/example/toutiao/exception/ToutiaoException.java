package com.example.toutiao.exception;

import com.example.toutiao.base.ToutiaoErrorCode;
import lombok.Getter;

@Getter
public class ToutiaoException extends RuntimeException {

    final private String errCode;
    final private String errMsg;

    public ToutiaoException(ToutiaoErrorCode easySpiralErrorCode){
        super(easySpiralErrorCode.getMessage());
        this.errCode = easySpiralErrorCode.getCode();
        this.errMsg = easySpiralErrorCode.getMessage();
    }

    /**
     * 对于同一个错误码下的细分错误，可以使用该构造方法，传入自定义的message信息
     */
    public ToutiaoException(ToutiaoErrorCode easySpiralErrorCode, String errMsg) {
        super(errMsg);
        this.errCode = easySpiralErrorCode.getCode();
        this.errMsg = errMsg;
    }

}
