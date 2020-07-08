package com.wz.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author 隔壁老王
 * @create 2020-07-07 15:36
 * @微信公众号 隔壁老王说Java
 * @description Lambda表达式的使用
 */
/*
 * 1.举例：(o1,o2) -> Integer.compare(o1,o2);
 * 2.格式：
 *   ->： lambda操作符或箭头操作符
 *   ->左边：lambda形参列表, 其实就是接口中的抽象方法的形参列表
 *   ->右边：lambda体, 其实就是重写的抽象方法的方法体
 * 3.Lambda的使用：分为六种情况
 *   总结：
 *      ->左边: lambda形参列表的参数类型可以省略;如果Lambda形参列表只有一个参数，其一对()可以省略
 *      ->右边：lambda体应该是用一对{}包裹;如果lambda体只有一条执行语句（可能是return语句），可以省略这一对{}和return关键字。
 *          注意：当这一条语句是return语句时，如果省略{}，则必须省略return关键字。
 * 4.Lambda的本质：作为接口的实例
 */
public class TestLambda_02 {


    // 语法格式一：无参，无返回值
    @Test
    public void test01() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        };
        r1.run();

        System.out.println("*********************");

        Runnable r2 = () -> {
            System.out.println("Lambda表达式");
        };
        r2.run();
    }

    // 语法格式二：Lambda 需要一个参数，但是没有返回值
    @Test
    public void test02() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("你选择相信童话，还是相信现实？");

        System.out.println("**************");

        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };
        consumer1.accept("即使我知道真相，我仍旧选择相信童话。");
    }

    // 语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test03() {
        Consumer<String> consumer = (String s) -> {
            System.out.println(s);
        };
        consumer.accept("你选择相信童话，还是相信现实？");
        System.out.println("**************");
        Consumer<String> consumer1 = (s) -> {
            System.out.println(s);
        };
        consumer1.accept("即使我知道真相，我仍旧选择相信童话。");
    }

    // 语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test04() {
        Consumer<String> consumer = (s) -> {
            System.out.println(s);
        };
        consumer.accept("你选择相信童话，还是相信现实？");
        System.out.println("**************");
        Consumer<String> consumer1 = s -> {
            System.out.println(s);
        };
        consumer1.accept("即使我知道真相，我仍旧选择相信童话。");
    }

    // 语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test05() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(comparator.compare(12,21));
        System.out.println("********************");
        Comparator<Integer> comparator1 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };
        System.out.println(comparator1.compare(12,21));
    }

    // 语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
    @Test
    public void test06() {
        Comparator<Integer> comparator = (o1,o2) -> {
            return Integer.compare(o1,o2);
        };
        System.out.println(comparator.compare(12,21));

        System.out.println("*****************");

        Comparator<Integer> comparator1 = (o1,o2) -> Integer.compare(o1,o2);
        System.out.println(comparator1.compare(12,21));

    }

}
