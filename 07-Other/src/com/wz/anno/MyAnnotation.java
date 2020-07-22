package com.wz.anno;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author 隔壁老王
 * @create 2020-07-17 11:15
 * @微信公众号 隔壁老王说Java
 * @description
 */
@Repeatable(MyAnnotations.class)        // 使其可以重复注解
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER})    // TYPE_PARAMETER使其可以注解类型
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "隔壁老王";
}
