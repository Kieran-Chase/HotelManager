package com.coder.hotel.util;

import javax.swing.table.DefaultTableModel;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/6/8
 */
public class CustomModel extends DefaultTableModel {
    public CustomModel(Object[][] data, Object[] column) {
        super(data, column);
    }
    //禁止jtable可编辑
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}