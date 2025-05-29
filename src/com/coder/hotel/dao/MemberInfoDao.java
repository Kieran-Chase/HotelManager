package com.coder.hotel.dao;

import com.coder.hotel.entity.MemberInfo;

import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/5/26
 */
public interface MemberInfoDao {
    int save(MemberInfo info);
    int delete(Object id);
    int update(MemberInfo info);
    MemberInfo selectId(Object id);
    List<MemberInfo> selectList();
    List<MemberInfo> selectByExample(MemberInfo info,int page);
    Object[][] listToArray(List<MemberInfo> list);
    Long getTotal(MemberInfo info);
}
