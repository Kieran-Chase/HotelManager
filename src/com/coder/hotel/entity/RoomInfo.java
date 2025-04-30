package com.coder.hotel.entity;

import com.coder.hotel.util.TableId;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/4/29
 */
public class RoomInfo {
    @TableId

    private Integer level;
    private Integer tid;
    private String roomnum;
    private Integer price;
    private Integer deposit;
    private String tel;
    private String status;
    private String remark;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getStates() {
        return status;
    }

    public void setStates(String states) {
        this.status = states;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
