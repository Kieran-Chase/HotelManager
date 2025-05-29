package com.coder.hotel.dao.impl;

import com.coder.hotel.dao.MemberInfoDao;
import com.coder.hotel.entity.MemberInfo;
import com.coder.hotel.entity.RoomInfo;
import com.coder.hotel.util.DBUtil;
import com.coder.hotel.util.StringUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
@author wangqicheng
@project HotelManager
@date 2025/5/26
*/
public class MemberInfoDaoImpl extends BaseDao<MemberInfo> implements MemberInfoDao {
    @Override
    public List<MemberInfo> selectByExample(MemberInfo info, int page) {
        int s=(page-1)*5;
        String sql="select * from memberinfo where 1=1";
        Map<String,Object> map=getArguments(info,sql);
        Object[] args= (Object[]) map.get("args");
        sql= (String) map.get("sql");
        sql+=" ORDER BY r.id limit "+s+",5";
        QueryRunner runner=new QueryRunner(DBUtil.getDataSource());
        try {
            List<MemberInfo> query = runner.query(sql,
                    new BeanListHandler<MemberInfo>(MemberInfo.class),args);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long getTotal(MemberInfo info) {
        String sql="select count(id) from memberinfo r where 1=1";
        Map<String,Object> map=getArguments(info,sql);
        Object[] args= (Object[]) map.get("args");
        sql= (String) map.get("sql");
        QueryRunner runner=new QueryRunner(DBUtil.getDataSource());
        try {
            return runner.query(sql, new ScalarHandler<Long>(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Map<String,Object> getArguments(MemberInfo info, String sql){
        List<Object> arguments=new ArrayList<>();
        if (StringUtil.isNotEmpty(info.getName())){
            sql+=" and name like ?";
            arguments.add("%"+info.getName()+"%");
        }
        if (!info.getGender().equals("请选择")){
            sql+=" and  gender=?";
            arguments.add(info.getGender());
        }
        if(info.getLowAge()!=0){
            sql+=" and age>=?";
            arguments.add(info.getLowAge());
        }
        if(info.getHighAge()!=0){
            sql+=" and age<=?";
            arguments.add(info.getHighAge());
        }
        if (!info.getLevel().equals("请选择")){
            sql+=" and level=?";
            arguments.add(info.getLevel());
        }
        Map<String,Object> map=new HashMap<>();
        map.put("args",arguments.toArray());
        map.put("sql",sql);
        return map;
    }

}
