package com.coder.hotel.dao;

import com.coder.hotel.entity.GoodsInfo;

import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/6/9
 */
public interface GoodsInfoDao {
    int save (GoodsInfo info);
    int update (GoodsInfo info);
    int delete(Object id);
    GoodsInfo selectId(Object id);
    List<GoodsInfo> selectByExample(GoodsInfo info,int page);
    Object[][] listToArray(List<GoodsInfo>list);
    Long getTotal(GoodsInfo info);
}
