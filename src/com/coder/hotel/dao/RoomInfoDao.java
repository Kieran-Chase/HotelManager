package com.coder.hotel.dao;

import com.coder.hotel.entity.RoomInfo;
import com.coder.hotel.entity.RoomType;

import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/4/30
 */
public interface RoomInfoDao {
    int save (RoomInfo info);
    int update (RoomInfo info);
    int delete(Object id);

    RoomInfo selectId(Object id);
    List<RoomInfo> selectList();
    List<RoomInfo> selectByExample(RoomInfo info);
    Object[][] listToArray(List<RoomInfo>list);
}
