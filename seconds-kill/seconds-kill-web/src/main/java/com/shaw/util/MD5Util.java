package com.shaw.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @ClassName: MD5Util
 * @Description: 加密工具类
 * @Author Lindsey Shaw
 * @Date 2018/8/29 17:09
 **/
public class MD5Util {

    public static String md5(String str){
        return new Md5Hash(str).toString();
    }

    public static String md5(String str,String salt){
        return new Md5Hash(str,salt).toString();
    }
}
