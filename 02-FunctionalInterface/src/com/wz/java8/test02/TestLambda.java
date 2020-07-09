package com.wz.java8.test02;

import org.junit.Test;

/**
 * @author 隔壁老王
 * @create 2020-07-09 9:58
 * @微信公众号 隔壁老王说Java
 * @description
 */
public class TestLambda {
    @Test
    public void test01() {
        String strHandler = strHandler("Hello World",(str) -> {
            str = str.toUpperCase();
            str = str.substring(2,5);
            return str;
        });
        System.out.println(strHandler);
    }

    // 用于处理字符串
    public String strHandler(String str,StrFunctionalInterface strFunctionalInterface){
        return strFunctionalInterface.getValue(str);
    }

}
