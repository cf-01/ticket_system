//package com.example.toutiao.page;
//
//import lombok.Data;
//import org.springframework.util.CollectionUtils;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//public class PageResult<T> implements Serializable {
//
//    /**
//     * 总数
//     */
//    private long total;
//    /**
//     * 总页数
//     */
//    private long pageCount;
//    /**
//     * 当前页数
//     */
//    private long pageNum;
//    /**
//     * 每页数量
//     */
//    private long pageSize;
//    /**
//     * 结果集
//     */
//    private List<T> datas;
//
//    private Boolean next;
//
//
//    /**
//     * 封装分页返回数据
//     *
//     * @param pageInfo
//     * @return
//     */
//    public PageResult build(PageInfo pageInfo) {
//        PageResult pageResult = new PageResult();
//        pageResult.setTotal(pageInfo.getTotal());
//        pageResult.setPageCount(pageInfo.getPages());
//        pageResult.setPageNum(pageInfo.getPageNum());
//        pageResult.setPageSize(pageInfo.getPageSize());
//        pageResult.setNext((CollectionUtils.isEmpty(pageInfo.getList()) || pageInfo.getList().size() <= pageInfo.getPageSize())
//                ? Boolean.FALSE : Boolean.TRUE);
//        if (!CollectionUtils.isEmpty(pageInfo.getList())) {
//            pageResult.setDatas(pageInfo.getList().subList(0, Math.min(pageInfo.getList().size(), pageInfo.getPageSize())));
//        } else {
//            pageResult.setDatas(new ArrayList());
//        }
//        return pageResult;
//    }
//
//}
