package com.wz.java8;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * @author 隔壁老王
 * @create 2020-07-13 14:51
 * @微信公众号 隔壁老王说Java
 * @description 测试 LocalDate（本地日期）/LocalTime（本地时间）/LocalDateTime（本地日期时间），这种数据更有利于人理解
 */

/**
 * Java8新日期时间API位于 java.time 包下
 */
public class TestLocalDateTime {
    @Test
    public void test01() {
        // 获取当前系统时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        // 指定时间
        LocalDateTime time = LocalDateTime.of(2018, 10, 12, 16, 25, 44);
        System.out.println(time);

        // 加减操作
        LocalDateTime newTime = time.plusYears(2);
        System.out.println(newTime);
        LocalDateTime time1 = newTime.minusMonths(3);
        System.out.println(time1);

        // get操作
        int monthValue = time1.getMonthValue();
        System.out.println(monthValue);
        Month month = time1.getMonth();
        System.out.println(month);

        // set操作
        LocalDateTime localDateTime = now.withDayOfMonth(5);
        System.out.println(localDateTime);


    }

}
