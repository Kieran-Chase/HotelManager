package com.coder.hotel.entity;

import com.coder.hotel.util.TableField;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/5/31
 */
public class MemberInfoQuery extends MemberInfo{
    private Integer lowAge;
    private Integer highAge;

    public Integer getLowAge() {
        return lowAge;
    }

    public void setLowAge(Integer lowAge) {
        this.lowAge = lowAge;
    }

    public Integer getHighAge() {
        return highAge;
    }

    public void setHighAge(Integer highAge) {
        this.highAge = highAge;
    }
}
