package com.coder.hotel.dao;

import com.coder.hotel.entity.MemberLevel;

import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/5/18
 */
public interface MemberLevelDao {
    int save(MemberLevel Level);
    int delete(Object id);
    int update(MemberLevel level);
    MemberLevel selectId(Object id);
    List<MemberLevel> selectList();
    List<MemberLevel> selectByExample(MemberLevel level);
    Object[][] listToArray(List<MemberLevel> list);
    Integer selectByLevel(String level);
}
