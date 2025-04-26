package com.coder.hotel.service;

import com.coder.hotel.dao.RoomTypeDao;
import com.coder.hotel.dao.impl.RoomTypeDaoImpl;
import com.coder.hotel.entity.RoomType;

import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/4/23
 */
public class RoomTypeService {
    private static RoomTypeDao dao;
    static {
        dao=new RoomTypeDaoImpl();
    }
    public int save(RoomType type){
        return dao.save(type);
    }

    public int deleteId(Object id){
        return dao.delete(id);
    }
    /*public List<RoomType> selectList(){
        return dao.selectList();
    }*/
    public Object[][] selectList(){
        return dao.listToArray(dao.selectList());
    }
    public Object[][] selectByType(String type){
        List<RoomType> list = dao.selectByType(type);
        return dao.listToArray(list);
    }
}
