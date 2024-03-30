package com.example.toutiao.req;

import lombok.Data;

import java.util.Date;

@Data
public class SelectOrderByTimeReq {
    // 开始时间
    private Date beginTime;
    private Date endTime;

}
