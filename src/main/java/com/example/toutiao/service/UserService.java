package com.example.toutiao.service;

import com.example.toutiao.entity.UserInfo;
import com.example.toutiao.req.UserReq;

import java.util.List;

public interface UserService {
    String register(UserReq userReq);

    Long login(UserReq userReq);

    List<UserInfo> selectAll(UserReq req);
}
