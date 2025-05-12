package com.coder.hotel.dao.impl;

import com.coder.hotel.dao.RoomInfoDao;
import com.coder.hotel.entity.RoomInfo;
import com.coder.hotel.util.DBUtil;
import com.coder.hotel.util.Page;
import com.coder.hotel.util.StringUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/4/30
 */
public class RoomInfoDaoImpl extends BaseDao<RoomInfo> implements RoomInfoDao {
    @Override
    public List<RoomInfo> selectByExample(RoomInfo info, int page) {
        int s=(page-1)*5;
        List<Object> arguments=new ArrayList<>();
        String sql="select r.id,r.tid,r.level,r.roomnum,r.price,r.deposit,r.tel,r.status,r.remark,t.type from roominfo r join roomtype t on tid=t.id where 1=1";
        if(StringUtil.isNotEmpty(info.getType())){
            sql+=" and r.tid=(select id from roomtype where type=?)";
            arguments.add(info.getType());
        }
        if(info.getLevel()!=0){
            sql+=" and r.level=?";
            arguments.add(info.getLevel());
        }
        if(StringUtil.isNotEmpty(info.getRoomnum())){
            sql+=" and r.roomnum like ?";
            arguments.add("%"+info.getRoomnum()+"%");
        }
        Object[] args=arguments.toArray();
        QueryRunner runner=new QueryRunner(DBUtil.getDataSource());
        try {
            List<RoomInfo> query = runner.query(sql,
                    new BeanListHandler<RoomInfo>(RoomInfo.class),args);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<RoomInfo> selectPage(int page) {
        int s=(page-1)*5;
        String sql="select r.id,r.tid,r.level,r.roomnum,r.price,r.deposit,r.tel,r.status,r.remark,t.type from roominfo r join roomtype t on tid=t.id ORDER BY r.id limit ?,?";
        QueryRunner runner =new QueryRunner(DBUtil.getDataSource());
        try {
            //List<RoomInfo> query = runner.query(sql, new BeanListHandler<RoomInfo>(RoomInfo.class));
            return runner.query(sql, new BeanListHandler<>(RoomInfo.class),s,5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long getTotal() {
        String sql="select count(id) from roominfo";
        QueryRunner runner =new QueryRunner(DBUtil.getDataSource());

        try {
            return runner.query(sql, new ScalarHandler<Long>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}