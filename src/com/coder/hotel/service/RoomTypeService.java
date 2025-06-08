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
public class RoomTypeService extends BaseService{
    private static RoomTypeDao dao;
    static {
        dao=new RoomTypeDaoImpl();
    }
    public Object[] getTypes(){
        List<RoomType> roomTypes = dao.selectList();
        Object[] types=new Object[roomTypes.size()+1];
        types[0]="---请选择---";
        for (int i = 0; i < roomTypes.size(); i++) {
            types[i+1]=roomTypes.get(i).getType();
        }
        return types;
    }
    public int save(RoomType type){return dao.save(type);}
    public Object[][] selectList(){return dao.listToArray(dao.selectList());}
    public int deleteId(Object id){return dao.delete(id);}
    /*public List<RoomType> selectList(){
        return dao.selectList();
    }*/
    public Object[][] selectByType(String type){
        List<RoomType> list = dao.selectByType(type);
        return dao.listToArray(list);
    }
    public RoomType selectId(Object id){
        return dao.selectId(id);
    }
    public int update(RoomType type){
        return dao.update(type);
    }

    public RoomType selectType(String type) {
        return dao.selectType(type);
    }
}
