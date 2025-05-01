package com.coder.hotel.service;

import com.coder.hotel.dao.RoomInfoDao;
import com.coder.hotel.dao.impl.RoomInfoDaoImpl;
import com.coder.hotel.entity.RoomInfo;
import com.coder.hotel.util.Page;

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
    public Object[][]selectList(int page){
        List<RoomInfo> roomInfos = dao.selectPage(page);
        return dao.listToArray(roomInfos);
    }
    public Page getPage(long page){
        long total=dao.getTotal();
        long size=5;
        long pages=total%size==0?total/size:total/size+1;
        return new Page(pages,page,size,total);
    }

    public int deleteId(Object id) {
        return dao.delete(id);
    }
}
