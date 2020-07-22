package com.wz.anno;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author 隔壁老王
 * @create 2020-07-17 11:14
 * @微信公众号 隔壁老王说Java
 * @description Java注解新特性：重复注解与类型注解
 */
public class TestAnnotation {

    @Test
    public void test01() throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method show = clazz.getMethod("show");

        MyAnnotation[] annotations = show.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation annotation : annotations) {
            System.out.println(annotation.value());
        }
    }
    
    @MyAnnotation("Hello")
    @MyAnnotation("老王")
    public void show(@MyAnnotation("test") String str){

    }

}
