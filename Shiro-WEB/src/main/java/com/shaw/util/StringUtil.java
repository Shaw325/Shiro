package com.shaw.util;

import java.util.regex.Pattern;

/**
 * @ClassName: StringUtil
 * @Description: 字符串工具类
 * @Author Lindsey Shaw
 * @Date 2018/8/29 16:50
 **/
public class StringUtil {

    /**
     * 字符串是否为空，包括空格字符
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str){
        return null != str && 0 != str.trim().length() ? false:true;
    }

    /**
     * 判断是否是为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str == null || "".equals(str) ? true:false;
    }

    /**
     * 判断是否为一个整数
     * @param str
     * @return
     */
    public static boolean isInteger(String str){
        return Pattern.compile("^(-)?([1-9]+\\d*|0)$").matcher(str).matches();
    }

    public static void main(String[] args) {
        boolean integer = isInteger("-01");
        System.out.println(integer);
    }
}
