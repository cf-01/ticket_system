package com.example.toutiao.service.Impl;

import com.example.toutiao.base.ToutiaoErrorCode;
import com.example.toutiao.entity.UserInfo;
import com.example.toutiao.exception.ToutiaoException;
import com.example.toutiao.mapper.UserMapper;
import com.example.toutiao.req.UserReq;
import com.example.toutiao.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public String register(UserReq userReq) {
        //校验账号是否重复
        UserInfo userInfo = userMapper.selectAllByAccount(userReq.getAccount());
        if (null != userInfo) {
            throw new ToutiaoException(ToutiaoErrorCode.ACCOUNT_HAS_EXITED);
        }

        //入库
        userInfo = new UserInfo();
        userInfo.setAccount(userReq.getAccount());
        userInfo.setPassword(userReq.getPassword());
        userInfo.setPhoneNum(userReq.getPhoneNum());
        userInfo.setName("用户");
        userMapper.insert(userInfo);
        return "注册成功";
    }

    @Override
    public Long login(UserReq userReq) {
        //校验账号是否存在
        UserInfo userInfo = userMapper.selectAllByAccount(userReq.getAccount());
        if (null == userInfo) {
            throw new ToutiaoException(ToutiaoErrorCode.ACCOUNT_NOT_EXIT);
        }

        //校验密码
        if (!userReq.getPassword().equals(userInfo.getPassword())) {
            throw new ToutiaoException(ToutiaoErrorCode.PASSWORD_ERROR);
        }
        return userInfo.getId();
    }

    @Override
    public List<UserInfo> selectAll(UserReq req) {
        // todo 各种查询
        return userMapper.selectList(null);
    }
}
