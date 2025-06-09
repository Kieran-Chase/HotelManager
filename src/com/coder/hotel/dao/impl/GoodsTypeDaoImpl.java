package com.coder.hotel.dao.impl;

import com.coder.hotel.dao.GoodsTypeDao;
import com.coder.hotel.entity.GoodsType;
import com.coder.hotel.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/6/7
 */
public class GoodsTypeDaoImpl extends BaseDao<GoodsType> implements GoodsTypeDao {
    @Override
    public List<GoodsType> selectByType(String typeName) {
        String sql="select id,typename from goodstype where typename like ?";
        QueryRunner queryRunner=new QueryRunner(DBUtil.getDataSource());
        try {
            return queryRunner.query(sql,
                    new BeanListHandler<GoodsType>(GoodsType.class),
                    "%" + typeName + "%");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Integer getIdByType(String type) {
        String sql="select id from goodstype where typename=?";
        QueryRunner queryRunner=new QueryRunner(DBUtil.getDataSource());
        try {
            return queryRunner.query(sql,
                    new ScalarHandler<>(),type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}