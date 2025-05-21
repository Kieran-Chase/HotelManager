package com.coder.hotel.dao.impl;

import com.coder.hotel.dao.MemberLevelDao;
import com.coder.hotel.entity.MemberLevel;
import com.coder.hotel.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/5/18
 */
public class MemberLevelDaoImpl extends BaseDao<MemberLevel> implements MemberLevelDao {
    @Override
    public List<MemberLevel> selectByExample(MemberLevel level) {
        String sql="select id,level,low,high,discount from memberlevel where 1=1";
        List<Object> args=new ArrayList<Object>();
        if(StringUtil.isNotEmpty(level.getLevel())){
            sql+=" and level like ?";
            args.add(level.getLevel());
        }
        if(level.getHigh()!=0){
            sql+=" and high<= ?";
            args.add(level.getHigh());
        }
        if(level.getLow()!=0){
            sql+=" and low>= ?";
            args.add(level.getLow());
        }
        return null;
    }
}
