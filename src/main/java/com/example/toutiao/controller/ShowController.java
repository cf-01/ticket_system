package com.example.toutiao.controller;

import com.example.toutiao.base.ToutiaoBaseResponse;
import com.example.toutiao.base.ToutiaoResponseUtil;
import com.example.toutiao.entity.ShowInfo;
import com.example.toutiao.req.ShowReq;
import com.example.toutiao.req.UserReq;
import com.example.toutiao.service.ShowService;
import com.example.toutiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    /**
     * 查看每日的余票，也就是查询所有可以预订的票
     * @return
     */
    @PostMapping(value = "/selectAllShow")
    public ToutiaoBaseResponse<List<ShowInfo>> selectAllShow() {
        return ToutiaoResponseUtil.success(showService.selectAllShow());
    }

    /**
     * 查看每日的余票 供服务端调用
     * @return
     */
    @PostMapping(value = "/selectAllShow2")
    public ToutiaoBaseResponse<List<ShowInfo>> selectAllShow2() {
        return ToutiaoResponseUtil.success(showService.selectAllShow2());
    }

    /**
     * 管理员新增展览
     * @param req
     * @return
     */
    @PostMapping(value = "/addShow")
    public ToutiaoBaseResponse<String> addShow(@RequestBody ShowReq req) {
        return ToutiaoResponseUtil.success(showService.addShow(req));
    }

    /**
     * 编辑展览，改票数什么的
     * @param req
     * @return
     */
    @PostMapping(value = "/editShow")
    public ToutiaoBaseResponse<String> editShow(@RequestBody ShowReq req) {
        return ToutiaoResponseUtil.success(showService.editShow(req));
    }

    /**
     * 废弃展览
     * @return
     */
    @PostMapping("/deleteByShowId")
    public ToutiaoBaseResponse<String> deleteByShowId(@RequestParam("showId") Integer showId) {
        return ToutiaoResponseUtil.success(showService.updateIsDeletedByShowId(showId));
    }

}
