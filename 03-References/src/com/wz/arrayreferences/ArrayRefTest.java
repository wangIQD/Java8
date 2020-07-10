package com.wz.arrayreferences;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author 隔壁老王
 * @create 2020-07-09 16:06
 * @微信公众号 隔壁老王说Java
 * @description 数组引用
 */

/**
 * 1.大家可以把数组看作是一个特殊的类则写法与构造器引用一致。
 */
public class ArrayRefTest {
    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer,String[]> function = (length) -> new String[length];
        System.out.println(function.apply(5).length);
        System.out.println("**********************");
        Function<Integer,String[]> function1 = String[]::new;
        System.out.println(function1.apply(10).length);
        ;
    }
}
