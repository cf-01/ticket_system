package com.example.toutiao.page;

import lombok.Data;

@Data
public class BasePageReq {

    /**
     * 分页页码（默认为第一页）
     */
    private int pageNum = 1;

    /**
     * 分页显示条数（默认每页10条）
     */
    private int pageSize = 10;

}
