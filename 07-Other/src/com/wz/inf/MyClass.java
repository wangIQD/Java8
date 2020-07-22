package com.wz.inf;

/**
 * @author 隔壁老王
 * @create 2020-07-17 9:12
 * @微信公众号 隔壁老王说Java
 * @description
 */
public class MyClass extends SuperClass implements MyFunction,MyFunction2 {
    @Override
    public String getStr2() {
        return "MyClass 重写 getStr2";
    }

    @Override
    public String getStr3() {
        return "MyClass 重写两个接口中同名同参数的默认方法: getStr3";
    }

    public void method(){
        getStr3();  // 调用自己定义的重写的方法
        super.getStr1();    // 调用的是父类中声明的
        // 调用接口中的默认方法
        MyFunction.method1();
        MyFunction2.super.getStr3();
    }
}
