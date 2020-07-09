package com.wz.java8.test01;

/**
 * @author 隔壁老王
 * @create 2020-07-08 10:38
 * @微信公众号 隔壁老王说Java
 * @description 函数式接口测试
 */

import org.junit.Test;

/**
 * 函数式接口：
 *  1.如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。我们可以在一个接口上使用@FunctionalInterface注解，
 * 这样做可以检查它是否是一个函数式接口。
 *  2.只要一个对象是函数式接口的实例，那么该对象就可以用Lambda表达式来表示，所以以前用匿名实现类表示的现在都可以用Lambda表达式来写。
 *  3.Java内置的四大核心函数式接口：
 *      消费型接口Consumer<T>     void accept(T t)
 *      供给型接口Supplier<T>     T get()
 *      函数型接口Function<T, R>  R apply(T t)
 *      断定型接口Predicate<T>    booLean test(T t)
 *  4.Lambda表达式就是一个函数式接口的实例，这就是 Lambda表达式和函数式接口的关系。
 */
public class TestFunctionalInterface {

    public double operation(double num,MyFunctionalInterface mFI){
        return mFI.getValue(num);
    }

    @Test
    public void test01() {
        // 以前的写法
        double operation1 = operation(20, new MyFunctionalInterface() {
            @Override
            public double getValue(double num) {
                return num * num;
            }
        });
        System.out.println(operation1);

        // Lambda表达式
        double operation2 = operation(100, (num) -> num * num);
        System.out.println(operation2);
        
    }

}
