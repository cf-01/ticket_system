package com.example.toutiao.service;

import com.example.toutiao.entity.OrderInfo;
import com.example.toutiao.req.OrderReq;
import com.example.toutiao.req.SelectOrderByTimeReq;
import com.example.toutiao.req.UserReq;
import com.example.toutiao.resp.OrderResp;
import com.example.toutiao.resp.TurnoverResp;

import java.util.List;

public interface OrderService {
    String addOrder(OrderReq req);

    String editOrder(OrderReq req);

    List<OrderResp> selectByUserId(OrderReq req);

    int queryTicketNum();

    Integer queryTicketPrice();


    List<OrderResp> queryTicketByDate(SelectOrderByTimeReq selectOrderByTimeReq);

    TurnoverResp queryTurnoverByDate(SelectOrderByTimeReq selectOrderByTimeReq);
}
