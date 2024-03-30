package com.example.toutiao.service;

import com.example.toutiao.entity.ShowInfo;
import com.example.toutiao.req.ShowReq;
import com.example.toutiao.req.UserReq;

import java.util.List;

public interface ShowService {

    List<ShowInfo> selectAllShow();

    List<ShowInfo> selectAllShow2();

    String addShow(ShowReq req);

    String editShow(ShowReq req);

    String updateIsDeletedByShowId(Integer showId);

}
