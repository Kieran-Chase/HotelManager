package com.coder.hotel.service;

import com.coder.hotel.dao.GoodsInfoDao;
import com.coder.hotel.dao.impl.GoodsInfoDaoImpl;
import com.coder.hotel.entity.GoodsInfo;
import com.coder.hotel.entity.GoodsInfoQuery;
import com.coder.hotel.util.Page;

import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/6/9
 */
public class GoodsInfoService extends BaseService {
    private static GoodsInfoDao dao;
    static {
        dao=new GoodsInfoDaoImpl();
    }
    public int save (GoodsInfo info){
        return dao.save(info);
    }
    public Object [][] selectExample(GoodsInfoQuery info, int page){
        List<GoodsInfo> GoodsInfos=dao.selectByExample(info,page);
        return dao.listToArray(GoodsInfos);
    }
    public Page getPage(GoodsInfoQuery info, long page){
        long total=dao.getTotal(info);
        long size=5;
        long pages=total%size==0?total/size:total/size+1;
        return new Page(pages,page,size,total);
    }

    public int deleteId(Object id) {
        return dao.delete(id);
    }

    public GoodsInfo selectId(Object id) {
        return dao.selectId(id);
    }

    public int update(GoodsInfo info) {
        return dao.update(info);
    }
}
