package com.coder.hotel.dao.impl;

import com.coder.hotel.dao.MemberLevelDao;
import com.coder.hotel.entity.MemberLevel;

import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/5/18
 */
public class MemberLevelDaoImpl extends BaseDao<MemberLevel> implements MemberLevelDao {
    @Override
    public List<MemberLevel> selectByExample(MemberLevel level) {
        return null;
    }
}
