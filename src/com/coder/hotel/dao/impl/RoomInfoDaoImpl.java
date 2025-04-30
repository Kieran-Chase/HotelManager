package com.coder.hotel.dao.impl;

import com.coder.hotel.dao.RoomInfoDao;
import com.coder.hotel.entity.RoomInfo;

import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/4/30
 */
public class RoomInfoDaoImpl extends BaseDao<RoomInfo> implements RoomInfoDao {
    @Override
    public List<RoomInfo> selectByExample(RoomInfo info) {
        return null;
    }
}
