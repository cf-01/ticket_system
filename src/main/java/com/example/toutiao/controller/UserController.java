package com.example.toutiao.controller;

import com.example.toutiao.base.ToutiaoBaseResponse;
import com.example.toutiao.base.ToutiaoResponseUtil;
import com.example.toutiao.entity.UserInfo;
import com.example.toutiao.req.UserReq;
import com.example.toutiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ToutiaoBaseResponse<String> register(@RequestBody UserReq req) {
        return ToutiaoResponseUtil.success(userService.register(req));
    }

    @PostMapping(value = "/login")
    public ToutiaoBaseResponse<Long> louin(@RequestBody UserReq req) {
        return ToutiaoResponseUtil.success(userService.login(req));
    }

    @PostMapping(value = "/selectAll")
    public ToutiaoBaseResponse<List<UserInfo>> selectAll(@RequestBody UserReq req) {
        return ToutiaoResponseUtil.success(userService.selectAll(req));
    }

}
