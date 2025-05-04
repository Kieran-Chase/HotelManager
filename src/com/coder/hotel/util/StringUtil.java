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

    public static boolean isEmpty(String str){
        if(str==null)
            return true;
        if(str.equals(""))
            return true;
        if(str.trim().equals(""))
            return true;
        return false;
    }
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
