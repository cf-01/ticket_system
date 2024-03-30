package com.example.toutiao.req;

import lombok.Data;

@Data
public class ShowReq {
    private String id;
    private String name;
    private String content;
    private int ticketNum;
    private double price;
    private String showTime;
}
