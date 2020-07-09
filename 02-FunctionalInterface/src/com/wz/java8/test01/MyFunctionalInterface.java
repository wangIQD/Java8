package com.wz.java8.test01;

/**
 * @author 隔壁老王
 * @create 2020-07-08 10:59
 * @微信公众号 隔壁老王说Java
 * @description 自定义的函数式接口
 */
@FunctionalInterface
public interface MyFunctionalInterface {
    double getValue(double num);
}

// 带泛型的自定义函数式接口
//@FunctionalInterface
//public interface MyFunctionalInterface<T> {
//    T getValue(T t);
//}