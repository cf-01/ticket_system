package com.example.toutiao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.toutiao.entity.OrderInfo;
import com.example.toutiao.entity.UserInfo;
import com.example.toutiao.resp.OrderResp;
import com.example.toutiao.resp.TurnoverResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<OrderInfo> {
    @Select("select t1.*,t2.name as showName,t2.content as showContent,t2.show_time as showTime,t3.name as buyUser from t_order t1 left join t_show t2 on t1.show_id = t2.id left join t_user t3 on t1.user_id = t3.id where t1.user_id = #{userId} ")
    List<OrderResp> selectByUserId(@Param("userId") Long userId);


    @Select("select sum(buy_num) from t_order where state = '0'")
    int queryTicketNum();


    @Select("SELECT SUM(o.buy_num * s.price) AS total_amount FROM t_order o JOIN t_show s ON o.show_id = s.id where o.state = '0';")
    int queryTicketPrice();

    @Select("SELECT * FROM t_order o where o.create_time between #{beginTime} and CONCAT(DATE_ADD(#{endTime}, INTERVAL 1 DAY), ' 00:00:00')")
    List<OrderResp> queryTicketByDate(@Param("beginTime") Date beginTime,@Param("endTime") Date endTime);

    @Select("SELECT SUM(sum_price) as sumTurnover FROM t_order o where o.create_time between #{beginTime} and CONCAT(DATE_ADD(#{endTime}, INTERVAL 1 DAY), ' 00:00:00')")
    TurnoverResp queryTurnoverByDate(Date beginTime, Date endTime);
}
