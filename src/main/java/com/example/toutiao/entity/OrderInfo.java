package com.example.toutiao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("t_order")
public class OrderInfo{
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long showId;
    private int buyNum;
    private String state;
    private String useUser;
    private String identity;
    private String phone;
    private String buyUser;
    private BigDecimal sumPrice;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String showTime;

}
