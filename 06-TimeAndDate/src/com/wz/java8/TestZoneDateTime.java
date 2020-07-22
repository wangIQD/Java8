package com.wz.java8;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * @author 隔壁老王
 * @create 2020-07-15 12:49
 * @微信公众号 隔壁老王说Java
 * @description ZonedDate、ZonedTime、ZonedDateTime: 与时区相关的日期、时间API
 */
public class TestZoneDateTime {
    @Test
    public void test01() {
        // 查看所有时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
    }

    @Test
    public void test02() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println(now);

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Europe/Tallinn") );
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Europe/Tallinn"));
        System.out.println(zonedDateTime);

    }

}
