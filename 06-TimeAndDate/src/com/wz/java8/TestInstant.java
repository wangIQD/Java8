package com.wz.java8;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author 隔壁老王
 * @create 2020-07-13 15:13
 * @微信公众号 隔壁老王说Java
 * @description 测试Instant（时间戳：以Unix元年，1970年1月1日00:00:00到某个时间之间的毫秒值，这种数据更有利于计算机处理）
 */
public class TestInstant {
    @Test
    public void test01() {
        // 默认获取 UTC 时区的Instant类的对象
        Instant now = Instant.now();
        System.out.println(now);

        // 静态方法，返回在1970-01-01 00:00:00基础上加上指定毫秒数之后的Instant类的对象
        Instant instant = Instant.ofEpochSecond(60L);
        System.out.println(instant);

        // 结合即时的偏移来创建一个OffsetDateTime，即添加偏移量
        OffsetDateTime atOffset = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(atOffset);

        // 返回1970-01-01 00:00:00到当前时间的毫秒数，即为时间戳
        long l = now.toEpochMilli();
        System.out.println(l);
    }
}
