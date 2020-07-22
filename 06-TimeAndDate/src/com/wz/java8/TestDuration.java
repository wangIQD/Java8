package com.wz.java8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

/**
 * @author 隔壁老王
 * @create 2020-07-13 15:28
 * @微信公众号 隔壁老王说Java
 * @description Duration（持续时间）：计算两个时间之间的间隔的。Period：计算两个日期之间的间隔
 */
public class TestDuration {
    @Test
    public void test01() {
        Instant now1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant now2 = Instant.now();
        Duration duration = Duration.between(now1, now2);
        System.out.println(duration.toMillis());

    }
    
    @Test
    public void test02() {
        LocalDate date = LocalDate.of(2018,10,10);
        LocalDate now = LocalDate.now();

        Period between = Period.between(date, now);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());


    }
    
}
