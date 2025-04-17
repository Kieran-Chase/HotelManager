package com.coder.hotel.dao;

import com.coder.hotel.entity.Admin;

import java.util.List;


/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/4/14
 */



public interface AdminDao {
    int save(Admin admin);

    int delete(Object id);

    int update(Admin admin);

    Admin login(String name, String pwd);

    List<Admin> selectList();

    List<Admin> selectByName(String name);
}
