package com.coder.hotel.service;

import com.coder.hotel.dao.MemberInfoDao;
import com.coder.hotel.dao.impl.MemberInfoDaoImpl;
import com.coder.hotel.entity.MemberInfo;
import com.coder.hotel.entity.MemberInfoQuery;
import com.coder.hotel.util.Page;

import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/5/26
 */
public class MemberInfoService {
    private static MemberInfoDao dao;
    static {
        dao=new MemberInfoDaoImpl();
    }
    public int save (MemberInfo info){
        return dao.save(info);
    }
    public Object [][] selectExample(MemberInfoQuery info, int page){
        List<MemberInfo> MemberInfos=dao.selectByExample(info,page);
        return dao.listToArray(MemberInfos);
    }
    public Page getPage(MemberInfoQuery info, long page){
        long total=dao.getTotal(info);
        long size=5;
        long pages=total%size==0?total/size:total/size+1;
        return new Page(pages,page,size,total);
    }

    public int deleteId(Object id) {
        return dao.delete(id);
    }

    public MemberInfo selectId(Object id) {
        return dao.selectId(id);
    }

    public int update(MemberInfo info) {
        return dao.update(info);
    }
}
