package com.coder.hotel.entity;

import com.coder.hotel.util.TableId;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/6/7
 */

public class GoodsType {
    @TableId
    private Integer id;
    private String typeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}

