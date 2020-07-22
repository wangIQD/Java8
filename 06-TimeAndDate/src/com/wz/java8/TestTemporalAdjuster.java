package com.wz.java8;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author 隔壁老王
 * @create 2020-07-15 11:23
 * @微信公众号 隔壁老王说Java
 * @description TemporalAdjuster: 时间校正器
 */

/**
 * TemporalAdjusters: 该类通过静态方法提供了大量的常用TemporalAdjuster的实现。
 */
public class TestTemporalAdjuster {
    @Test
    public void test01() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime localDateTime = now.withDayOfMonth(10);
        System.out.println(localDateTime);

        LocalDateTime with = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(with);


        // 自定义：下一个工作日
        LocalDateTime localDateTime1 = now.with((l) -> {
            LocalDateTime ldt = (LocalDateTime) l;
            DayOfWeek week = ldt.getDayOfWeek();
            if (week.equals(DayOfWeek.FRIDAY)) {
                return ldt.plusDays(3);
            } else if (week.equals(DayOfWeek.SATURDAY)) {
                return ldt.plusDays(2);
            } else {
                return ldt.plusDays(1);
            }
        });

        System.out.println(localDateTime1);

    }
}
