package com.wz.optional;

import com.wz.Cat;
import com.wz.Mouse;
import org.junit.Test;

import java.util.Optional;

/**
 * @author 隔壁老王
 * @create 2020-07-12 9:48
 * @微信公众号 隔壁老王说Java
 * @description
 */
/**
 * 1.Optional类:为了在程序中避免出现空指针异常而创建的。
 * 常用的方法(更多方法查看API文档): ofNullable(T t)
 *            orElse(T t)
 * Optional.of(T t) :创建一一个Optional实例，t必须非空;
 * Optional.empty() :创建一个空的 Optional实例
 * Optional.ofNullable(T t): t可以为mull
 */
public class OptionalTest {
    @Test
    public void test01() {
        Mouse mouse = new Mouse("Jerry");
        // of(T t):保证t是非空的
        Optional<Mouse> mouse1 = Optional.of(mouse);
        System.out.println(mouse1);

    }

    @Test
    public void test02() {
        Mouse mouse = new Mouse();
        mouse = null;
        // ofNullable(T t): t可以为null
        Optional<Mouse> mouse1 = Optional.ofNullable(mouse);
        System.out.println(mouse1);
        // orELse(T t1): 如果单前的Optional内部封装的t是非空的，则返回内部的t
        // 如果内部的t是空的，则返回orElse()方法中的参数t
        Mouse mouse2 = mouse1.orElse(new Mouse("Jerry"));
        System.out.println(mouse2);

    }

    public String getMouseName(Cat cat){
        Optional<Cat> cat1 = Optional.ofNullable(cat);
        // cat2一定非空
        Cat cat2 = cat1.orElse(new Cat("Tom", new Mouse()));
        Optional<Mouse> friend = Optional.ofNullable(cat2.getFriend());
        // mouse一定非空
        Mouse mouse = friend.orElse(new Mouse("Jerry"));
        return mouse.getName();
    }

    @Test
    public void test03() {
        Cat cat = new Cat();
        String mouseName = getMouseName(cat);
        System.out.println(mouseName);
    }
}
