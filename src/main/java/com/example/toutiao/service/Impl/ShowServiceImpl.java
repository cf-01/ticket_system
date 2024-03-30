package com.example.toutiao.service.Impl;

import com.example.toutiao.base.ToutiaoErrorCode;
import com.example.toutiao.entity.ShowInfo;
import com.example.toutiao.entity.UserInfo;
import com.example.toutiao.exception.ToutiaoException;
import com.example.toutiao.mapper.ShowMapper;
import com.example.toutiao.mapper.UserMapper;
import com.example.toutiao.req.ShowReq;
import com.example.toutiao.req.UserReq;
import com.example.toutiao.service.ShowService;
import com.example.toutiao.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Resource
    private ShowMapper showMapper;

    @Override
    public String addShow(ShowReq req) {
        ShowInfo showInfo = new ShowInfo();
        showInfo.setShowTime(req.getShowTime());
        showInfo.setTicketNum(req.getTicketNum());
        showInfo.setContent(req.getContent());
        showInfo.setName(req.getName());
        showInfo.setPrice(req.getPrice());
        showMapper.insert(showInfo);
        return "新增成功";
    }

    @Override
    public String editShow(ShowReq req) {
        ShowInfo showInfo = showMapper.selectById(req.getId());
        showInfo.setShowTime(req.getShowTime());
        showInfo.setTicketNum(req.getTicketNum());
        showInfo.setContent(req.getContent());
        showInfo.setName(req.getName());
        showInfo.setPrice(req.getPrice());
        showMapper.updateById(showInfo);
        return "编辑成功";
    }

    @Override
    public String updateIsDeletedByShowId(Integer showId) {
        // 取出对应id的isDeleted值
        ShowInfo showInfo = showMapper.selectById(showId);
        if (showInfo.getIsDeleted() == 0) {
            showMapper.updateIsDeletedByShowId(1,showId);
            return "启用成功";
        }else {
            showMapper.updateIsDeletedByShowId(0,showId);
            return "废弃成功";
        }
    }

    @Override
    public List<ShowInfo> selectAllShow() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 查询所有创建时间大于当前时间的展览，也就是小于当前时间的默认过期了，不展示
        List<ShowInfo> showInfos = showMapper.selectByCreateTime(sdf.format(new Date()));
        return showInfos;
    }

    @Override
    public List<ShowInfo> selectAllShow2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 查询所有创建时间大于当前时间的展览，也就是小于当前时间的默认过期了，不展示
        List<ShowInfo> showInfos = showMapper.selectByCreateTime2(sdf.format(new Date()));
        return showInfos;
    }
}
