package com.coder.hotel.service;

import com.coder.hotel.dao.RoomInfoDao;
import com.coder.hotel.dao.impl.RoomInfoDaoImpl;
import com.coder.hotel.entity.RoomInfo;

import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/4/30
 */
public class RoomInfoService {
    private static RoomInfoDao dao;
    static {
        dao=new RoomInfoDaoImpl();
    }
    public Object[][]selectList(){
        List<RoomInfo> roomInfos = dao.selectList();
        return dao.listToArray(roomInfos);
    }
}
