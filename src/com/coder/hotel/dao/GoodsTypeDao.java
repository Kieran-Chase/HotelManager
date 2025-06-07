package com.coder.hotel.dao;

import com.coder.hotel.entity.GoodsType;

import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/6/7
 */


public interface GoodsTypeDao {
    int save(GoodsType goodsType);
    int delete(Object id);
    int update(GoodsType goodsType);
    GoodsType selectId(Object id);
    List<GoodsType> selectList();
    List<GoodsType> selectByType(String typeName);
    Object[][] listToArray(List<GoodsType> list);

    Integer getIdByType(String type);
}
