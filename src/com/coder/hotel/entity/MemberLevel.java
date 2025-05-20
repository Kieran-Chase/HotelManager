package com.coder.hotel.entity;

import com.coder.hotel.util.TableId;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/5/18
 */
public class MemberLevel {
    @TableId
    private Integer id;
    private String level;
    private Integer low;
    private Integer high;
    private Double discount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getLow() {
        return low;
    }

    public void setLow(Integer low) {
        this.low = low;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
