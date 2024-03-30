package com.example.toutiao.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class OrderReq {
    private Long showId;
    private Long id;
    private Long userId;
    private int ticketNum;
    private String useUser;
    private String identity;
    private String phone;
    private Integer flag;
}
