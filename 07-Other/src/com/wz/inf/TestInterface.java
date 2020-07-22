package com.wz.inf;

import org.junit.Test;

/**
 * @author 隔壁老王
 * @create 2020-07-17 9:03
 * @微信公众号 隔壁老王说Java
 * @description
 */
public class TestInterface {

    @Test
    public void test01() {
        // 通过实现类的对象，可以调用接口中的默认方法，如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
        MyClass myClass = new MyClass();
        System.out.println(myClass.getStr2());

        // 如果子类(或实现类)继承的父类和实现的接口中声明了同名同参数的方法，
        // 那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法。-->类优先原则
        System.out.println(myClass.getStr1());

        // 如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，那么在实现类没有重写此方法的情况下，
        // 报错-->接口冲突，这就需要我们必须在实现类中重写此方法
        System.out.println(myClass.getStr3());


        // 接口中定义的静态方法，只能通过接口来调用
        //myClass.method1();   // 报错
        MyFunction.method1();

    }

}
