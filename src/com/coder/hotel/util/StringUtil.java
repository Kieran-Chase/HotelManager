package com.coder.hotel.util;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author wangqicheng
 * @project HotelManager
 * @date 2025/4/17
 */
public class StringUtil {
    public static String getCode(){
        Random random = new Random();
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        int i = random.nextInt(9999);
        String s = decimalFormat.format(i);
        return s;
    }
}
