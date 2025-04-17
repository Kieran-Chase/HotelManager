package com.coder.hotel.entity;

import com.coder.hotel.util.IdType;
import com.coder.hotel.util.TableId;

import java.time.LocalDateTime;

/**
 @author wangqicheng
 @project HotelManager
 @date 2025/4/16
 */

public class Admin {
    @TableId(IdType.AUTO_INCREMENT)
    private Integer id;
    private String name;
    private String pwd;
    private LocalDateTime lasttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public LocalDateTime getLasttime() {
        return lasttime;
    }

    public void setLasttime(LocalDateTime lasttime) {
        this.lasttime = lasttime;
    }
}
