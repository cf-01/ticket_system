package com.example.toutiao.req;

import lombok.Data;

@Data
public class UserReq {
    private Long id;
    private String account;
    private String password;
    private String phoneNum;
}
