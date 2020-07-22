package com.wz.inf;

/**
 * @author 隔壁老王
 * @create 2020-07-17 9:06
 * @微信公众号 隔壁老王说Java
 * @description Java8中接口新特性: 可以定义静态方法，默认方法
 */
public interface  MyFunction {

    // 静态方法, public 可以省略
    public static void method1(){
        System.out.println("接口中的静态方法: method1");
    }


    // 接口中的默认方法, public 可以省略
    public default String getStr1(){
        return "接口中的默认方法1: getStr1";
    }

    public default String getStr2(){
        return "接口中的默认方法2: getStr2";
    }

    default String getStr3(){
        return "MyFunction接口中的默认方法3: getStr3";
    }
}
