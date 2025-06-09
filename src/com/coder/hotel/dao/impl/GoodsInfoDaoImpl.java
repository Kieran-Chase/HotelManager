package com.coder.hotel.dao.impl;

import com.coder.hotel.dao.GoodsInfoDao;
import com.coder.hotel.entity.GoodsInfo;
import com.coder.hotel.entity.GoodsInfoQuery;
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
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/6/9
 */
public class GoodsInfoDaoImpl extends BaseDao<GoodsInfo> implements GoodsInfoDao {
    @Override
    public List<GoodsInfo> selectByExample(GoodsInfoQuery info, int page) {
        int s=(page-1)*5;
        String sql="select * from goodsinfo where 1=1";
        Map<String,Object> map=getArguments(info,sql);
        Object[] args= (Object[]) map.get("args");
        sql= (String) map.get("sql");
        sql+=" ORDER BY id limit "+s+",5";
        QueryRunner runner=new QueryRunner(DBUtil.getDataSource());
        try {
            List<GoodsInfo> query = runner.query(sql,
                    new BeanListHandler<GoodsInfo>(GoodsInfo.class),args);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Long getTotal(GoodsInfoQuery info) {
        String sql="select count(id) from goodsinfo where 1=1";
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
    private Map<String,Object> getArguments(GoodsInfoQuery info, String sql){
        List<Object> arguments=new ArrayList<>();
        if (!info.getType().equals("请选择")){
            sql+=" and type=?";
            arguments.add(info.getType());
        }
        if (StringUtil.isNotEmpty(info.getName())){
            sql+=" and name like ?";
            arguments.add("%"+info.getName()+"%");
        }
        if (info.getLowPrice()!=0){
            sql+=" and price>=?";
            arguments.add(info.getLowPrice());
        }
        if (info.getHighPrice()!=0){
            sql+=" and price<=?";
            arguments.add(info.getHighPrice());
        }
        Map<String,Object> map=new HashMap<>();
        map.put("args",arguments.toArray());
        map.put("sql",sql);
        return map;
    }

}
