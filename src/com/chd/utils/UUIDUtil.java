package com.chd.utils;

import java.util.UUID;

/**
 * 产生随机字符串的工具类
 */
public class UUIDUtil {
    public static String getUUID() {
       return UUID.randomUUID().toString().replace("-","");
    }
}
