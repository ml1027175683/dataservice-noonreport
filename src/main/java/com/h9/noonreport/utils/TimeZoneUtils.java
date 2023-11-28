package com.h9.noonreport.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class TimeZoneUtils {
    public static void main(String[] args) {
        double latitude = 114.06455; // 经度
        double longitude = 22.54846; // 纬度


        long timeStamp = System.currentTimeMillis();

        String timeZoneId = getTimeZoneId(latitude, longitude);
        System.out.println(timeZoneId);
        TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
        System.out.println(timeZone);
        Instant instant = Instant.ofEpochMilli(timeStamp);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, timeZone.toZoneId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("HH");

        String formattedDateTime = localDateTime.format(formatter);
        String formattedDateTime1 = localDateTime.format(formatter1);
        String formattedDateTime2 = localDateTime.format(formatter2);
        String formattedDateTime3 = localDateTime.format(formatter3);

        System.out.println(formattedDateTime);
        System.out.println(formattedDateTime1);
        System.out.println(formattedDateTime2);
        System.out.println(formattedDateTime3);








    }


    public static String getTimeZoneId(double latitude, double longitude) {
        String timeZoneId = "";

        int offset = (int) (longitude / 15);
        if (offset < 0) {
            timeZoneId = "GMT" + offset;
        } else {
            timeZoneId = "GMT+" + offset;
        }

        return timeZoneId;
    }

    /**
     * 根据经度获取时区
     * @param currentLon
     * @return
     */
    public static int caculateTimeZone(double currentLon) {
        int timeZone ;
        int shangValue = (int)(currentLon / 15);
        double yushuValue =  Math.abs(currentLon % 15);
        if (yushuValue <= 7.5) {
            timeZone = shangValue;
        } else {
            timeZone = shangValue +(currentLon > 0 ?  1 :-1);
        }
        return timeZone;
    }

}
