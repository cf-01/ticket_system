package com.example.toutiao.service.Impl;

import com.example.toutiao.entity.OrderInfo;
import com.example.toutiao.entity.ShowInfo;
import com.example.toutiao.entity.UserInfo;
import com.example.toutiao.mapper.OrderMapper;
import com.example.toutiao.mapper.ShowMapper;
import com.example.toutiao.mapper.UserMapper;
import com.example.toutiao.req.OrderReq;
import com.example.toutiao.req.SelectOrderByTimeReq;
import com.example.toutiao.resp.OrderResp;
import com.example.toutiao.resp.TurnoverResp;
import com.example.toutiao.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private ShowMapper showMapper;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private UserMapper userMapper;


    @Override
    public String addOrder(OrderReq req) {
        // 判断库存是否大于0
        ShowInfo showInfo = showMapper.selectById(req.getShowId());
        if (showInfo.getTicketNum() <= 0) {
            return "购买失败，库存不足！";
        }

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setBuyNum(req.getTicketNum());
        orderInfo.setShowId(req.getShowId());
        orderInfo.setUserId(req.getUserId());
        orderInfo.setState("0"); // 0 正常 1 退票
        orderInfo.setUseUser(req.getUseUser());
        orderInfo.setIdentity(req.getIdentity());
        orderInfo.setPhone(req.getPhone());
        orderInfo.setShowTime(showInfo.getShowTime());
        // 计算订单总价
        ShowInfo showInfo1 = showMapper.selectById(req.getShowId());
        orderInfo.setSumPrice(BigDecimal.valueOf(showInfo1.getPrice()*req.getTicketNum()));
        // 获取当前购买人
        UserInfo userInfo = userMapper.selectById(req.getUserId());
        orderInfo.setBuyUser(userInfo.getName());
        // 入库
        orderMapper.insert(orderInfo);

        // 订票成功，展览的票数-1
        showInfo.setTicketNum(showInfo.getTicketNum()- req.getTicketNum());
        // 设置只有当库存大于0才能订票，否则订票失败
        showMapper.updateById(showInfo);
        return "订票成功";
    }

    @Override
    public String editOrder(OrderReq req) {
        // 根据userid查询订单
        OrderInfo orderInfo = orderMapper.selectById(req.getId());
        // 获取flag
        if (req.getFlag() == 1) {
            // flag=1代表改为已退票
            orderInfo.setState("1");
        } else if (req.getFlag() == 3){
            // flag=3 代表改为已使用
            orderInfo.setState("3");
        }
        orderMapper.updateById(orderInfo);
        return "退票成功";
    }

    @Override
    public List<OrderResp> selectByUserId(OrderReq req) {

        // 根据userid查询订单
        return orderMapper.selectByUserId(req.getUserId());
    }

    @Override
    public int queryTicketNum() {
        //查询
        return orderMapper.queryTicketNum();
    }

    @Override
    public Integer queryTicketPrice() {
        //查询

        return orderMapper.queryTicketPrice();
    }

    @Override
    public List<OrderResp> queryTicketByDate(SelectOrderByTimeReq selectOrderByTimeReq) {
        // 根据开始结束时间查询
        Date beginTime = selectOrderByTimeReq.getBeginTime();
        Date endTime = selectOrderByTimeReq.getEndTime();
        List<OrderResp> orderInfoList = orderMapper.queryTicketByDate(beginTime,endTime);
        for (OrderResp orderResp : orderInfoList) {
            orderResp.setShowName(showMapper.selectById(orderResp.getShowId()).getName());
        }
        return orderInfoList;
    }

    @Override
    public TurnoverResp queryTurnoverByDate(SelectOrderByTimeReq selectOrderByTimeReq) {
        // 根据开始结束时间查询
        Date beginTime = selectOrderByTimeReq.getBeginTime();
        Date endTime = selectOrderByTimeReq.getEndTime();
        TurnoverResp turnoverResp = orderMapper.queryTurnoverByDate(beginTime,endTime);
        return turnoverResp;
    }


}
