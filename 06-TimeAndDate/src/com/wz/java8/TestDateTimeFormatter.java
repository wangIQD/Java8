package com.wz.java8;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author 隔壁老王
 * @create 2020-07-15 12:26
 * @微信公众号 隔壁老王说Java
 * @description TestDateTimeFormatter: 格式化时间或日期
 */
public class TestDateTimeFormatter {
    @Test
    public void test01() {

        // 方式一：预定义的标准格式
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String format = formatter.format(LocalDateTime.now());
        System.out.println(format);
        // 解析：字符串->日期
        TemporalAccessor accessor = formatter.parse(format);
        System.out.println(accessor);

        // 方式二：自定义格式
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format1 = formatter2.format(LocalDateTime.now());
        System.out.println(format1);

        // 方式三：本地化相关的格式。ofLocalizedDateTime()/ofLocalizedDate()
        // FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String s2 = formatter1.format(LocalDateTime.now());
        System.out.println(s2);

        // FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDate
        DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String s = formatter3.format(LocalDate.now());
        System.out.println(s);



    }
}
