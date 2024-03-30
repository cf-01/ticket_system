package com.example.toutiao.controller;

import com.example.toutiao.base.ToutiaoBaseResponse;
import com.example.toutiao.base.ToutiaoResponseUtil;
import com.example.toutiao.entity.OrderInfo;
import com.example.toutiao.req.OrderReq;
import com.example.toutiao.req.SelectOrderByTimeReq;
import com.example.toutiao.req.UserReq;
import com.example.toutiao.resp.OrderResp;
import com.example.toutiao.resp.TurnoverResp;
import com.example.toutiao.service.OrderService;
import com.example.toutiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 订票
     * @param req
     * @return
     */
    @PostMapping(value = "/addOrder")
    public ToutiaoBaseResponse<String> register(@RequestBody OrderReq req) {
        return ToutiaoResponseUtil.success(orderService.addOrder(req));
    }

    /**
     * 退票
     * @param req
     * @return
     */
    @PostMapping(value = "/editOrder")
    public ToutiaoBaseResponse<String> editOrder(@RequestBody OrderReq req) {
        return ToutiaoResponseUtil.success(orderService.editOrder(req));
    }

    /**
     * 查看用户个人订单
     * @param req
     * @return
     */
    @PostMapping(value = "/selectByUserId")
    public ToutiaoBaseResponse<List<OrderResp>> selectByUserId(@RequestBody OrderReq req) {
        return ToutiaoResponseUtil.success(orderService.selectByUserId(req));
    }

    /**
     * 查询所有的售票数量
     * @return
     */
    @PostMapping(value = "/queryTicketNum")
    public ToutiaoBaseResponse<Integer> queryTicketNum() {
        return ToutiaoResponseUtil.success(orderService.queryTicketNum());
    }

    /**
     * 查询所有售票的价格总数
     * @return
     */
    @PostMapping(value = "/queryTicketPrice")
    public ToutiaoBaseResponse<Integer> queryTicketPrice() {
        return ToutiaoResponseUtil.success(orderService.queryTicketPrice());
    }

    /**
     * 查询售票数据 支持按照时间查询
     */
    @PostMapping("/queryTicketByDate")
    public ToutiaoBaseResponse<List<OrderResp>> queryTicketByDate(@RequestBody SelectOrderByTimeReq selectOrderByTimeReq) {
        return ToutiaoResponseUtil.success(orderService.queryTicketByDate(selectOrderByTimeReq));
    }

    /**
     * 查询营业数据 支持按照时间查询 按照天数统计
     */
    @PostMapping("/queryTurnoverByDate")
    public ToutiaoBaseResponse<TurnoverResp> queryTurnoverByDate(@RequestBody SelectOrderByTimeReq selectOrderByTimeReq) {
        return ToutiaoResponseUtil.success(orderService.queryTurnoverByDate(selectOrderByTimeReq));
    }
}
