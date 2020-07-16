package com.wz.java8.test01;

/**
 * @author 隔壁老王
 * @create 2020-07-08 10:38
 * @微信公众号 隔壁老王说Java
 * @description 函数式接口测试
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

    // 消费型接口
    @Test
    public void test02(){
        // 以前的写法
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去天上人间买了瓶矿泉水，价格为：" + aDouble);
            }
        });

        System.out.println("********************");
        // Lambda表达式
        happyTime(400,money -> System.out.println("学习太累了，去天上人间喝了口水，价格为：" + money));
    }
    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    // 供给型接口
    @Test
    public void test03() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        numList.forEach(System.out::println);
    }
    // 产生指定个数的整数，放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    // 函数型接口
    @Test
    public void test04() {
        String s = strHandler("    Hello World   ", str -> str.toUpperCase().trim());
        System.out.println(s);
    }
    // 字符串转换成大写
    public String strHandler(String str, Function<String,String> function){
        return function.apply(str);
    }

    // 断定型接口
    @Test
    public void test05(){
        List<String> list = Arrays.asList("北京","南京","天津","东京","西京");

        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(filterStrs);

        List<String> filterStrs1 = filterString(list,s -> s.contains("京"));
        System.out.println(filterStrs1);
    }
    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for(String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }

}
