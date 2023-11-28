package com.h9.noonreport.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class TimeConversion {
    public static void main(String[] args) {
        // 获取当前的时间戳
        long timeStamp = System.currentTimeMillis();

        // 将时间戳转换为本地日期时间
        Instant instant = Instant.ofEpochMilli(timeStamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

        // 指定目标时区偏移量为GMT-04:00
        ZoneOffset offset1 = ZoneOffset.ofHours(-4);

        // 将本地日期时间转换为GMT-04:00的日期时间
        OffsetDateTime offsetDateTime1 = OffsetDateTime.of(localDateTime, offset1);

        // 指定目标时区偏移量为GMT+04:00
        ZoneOffset offset2 = ZoneOffset.ofHours(4);

        // 将本地日期时间转换为GMT+04:00的日期时间
        OffsetDateTime offsetDateTime2 = OffsetDateTime.of(localDateTime, offset2);

        // 格式化输出
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDateTime1 = offsetDateTime1.format(formatter);
        String formattedDateTime2 = offsetDateTime2.format(formatter);

        // 输出结果
        System.out.println("GMT-04:00 时间：" + formattedDateTime1);
        System.out.println("GMT+04:00 时间：" + formattedDateTime2);
    }
}
