package com.coder.hotel.service;

import com.coder.hotel.dao.GoodsTypeDao;
import com.coder.hotel.dao.impl.GoodsTypeDaoImpl;
import com.coder.hotel.entity.GoodsType;

import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/6/7
 */
public class GoodsTypeService {
    private static GoodsTypeDao dao;
    static {
        dao=new GoodsTypeDaoImpl();
    }

    public int save(GoodsType type){
        return dao.save(type);
    }
    public Object[][] selectList(){
        return dao.listToArray(dao.selectList());
    }
    public int deleteId(Object id){
        return dao.delete(id);
    }
    public Object[][] selectByType(String type){
        List<GoodsType> list = dao.selectByType(type);
        return dao.listToArray(list);
    }
    public GoodsType selectId(Object id){
        return dao.selectId(id);
    }
    public int update(GoodsType type){
        return dao.update(type);
    }

    public List<GoodsType> getList() {
        return dao.selectList();
    }

    public Integer getIdByType(String type) {
        return dao.getIdByType(type);
    }
}
