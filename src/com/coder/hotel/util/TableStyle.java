package com.coder.hotel.util;

import javax.swing.*;
import java.awt.*;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/5/1
 */
public class TableStyle {
    public static void setStyle (JTable table){
        //设计样式
        //设置表头背景色
        table.getTableHeader().setBackground(Color.BLUE);
        //设置表头前景色
        table.getTableHeader().setForeground(Color.WHITE);
        //设置表头高度
        table.getTableHeader().setPreferredSize(new Dimension(1,30));
        //设置行高
        table.setRowHeight(25);
    }
}
