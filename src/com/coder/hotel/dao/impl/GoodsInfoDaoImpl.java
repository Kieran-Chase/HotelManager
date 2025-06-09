package com.coder.hotel.dao.impl;

import com.coder.hotel.dao.GoodsInfoDao;
import com.coder.hotel.entity.GoodsInfo;

import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/6/9
 */
public class GoodsInfoDaoImpl extends BaseDao<GoodsInfo> implements GoodsInfoDao {
    @Override
    public List<GoodsInfo> selectByExample(GoodsInfo info, int page) {
        return List.of();
    }

    @Override
    public Long getTotal(GoodsInfo info) {
        return 0L;
    }
}
