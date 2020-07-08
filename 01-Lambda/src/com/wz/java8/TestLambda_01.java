package com.wz.java8;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author 隔壁老王
 * @create 2020-07-07 14:03
 * @微信公众号 隔壁老王说Java
 * @description lambda表达式初体验
 */
public class TestLambda_01 {

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        };
        r1.run();

        System.out.println("*********************");

        Runnable r2 = () -> System.out.println("Lambda表达式");
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(comparator1.compare(12, 32));

        System.out.println("************");

        Comparator<Integer> comparator2 = (x,y) -> Integer.compare(x,y);
        System.out.println(comparator2.compare(32,12));

    }
}
