package com.coder.hotel.entity;

import com.coder.hotel.util.IdType;
import com.coder.hotel.util.Tableld;

import java.time.LocalDateTime;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/4/14
 */
public class Admin {
    @Tableld(IdType.AUTO_INCREMENT)
    private int id;
    private String name;
    private String password;


    public LocalDateTime getLasttime() {
        return lasttime;
    }

    public void setLasttime(LocalDateTime lasttime) {
        this.lasttime = lasttime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private LocalDateTime lasttime;
}
