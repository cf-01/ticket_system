package com.example.toutiao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.toutiao.entity.ShowInfo;
import com.example.toutiao.entity.UserInfo;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

@Mapper
public interface ShowMapper extends BaseMapper<ShowInfo> {

    @Select("select * from t_show where create_time > #{date} and is_deleted =1")
    List<ShowInfo> selectByCreateTime(String date);

    @Select("select * from t_show where create_time > #{date}")
    List<ShowInfo> selectByCreateTime2(String date);


    @Update("update t_show set is_deleted = #{isDeleted} where id = #{showId}")
    int updateIsDeletedByShowId(@Param("isDeleted") Integer isDeleted,@Param("showId") Integer showId);

    @Update("UPDATE t_show SET show_time = DATE_ADD(show_time, INTERVAL 1 DAY)")
    int updateAllShowDate();
}
