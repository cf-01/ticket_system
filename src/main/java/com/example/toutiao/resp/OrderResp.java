package com.example.toutiao.resp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderResp {
    private Long id;

    private Long userId;
    private Long showId;
    private String showName;
    private String showContent;
    private int buyNum;
    private String state;
    private String useUser;
    private String buyUser;
    private String phone;
    private String identity;
    private BigDecimal sumPrice;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String showTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
