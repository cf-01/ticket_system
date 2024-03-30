package com.example.toutiao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.toutiao.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {

    @Select("select * from t_user where account = #{account} ")
    UserInfo selectAllByAccount(@Param("account") String account);



}
