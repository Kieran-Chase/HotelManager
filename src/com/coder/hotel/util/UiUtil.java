package com.coder.hotel.util;

import javax.swing.*;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/4/17
 */
public class UiUtil {
    public static void indent(JFrame src,JFrame dest){
        if(src!=null){
            src.setVisible(false);
        }
        if(dest!=null){
            dest.setVisible(true);
        }
    }

}
