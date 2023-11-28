package com.h9.noonreport.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: light
 * @Date: 2023/11/02 17:59
 * @Description：Date工具类
 */
public class DateUtils {


    public final static String YYYYMMDD = "yyyyMMdd";

    public final static String YYYYMMDD2 = "yyyy-MM-dd";
    public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public final static String YYYYMMDDHHMMSS2 = "yyyy-MM-dd HH:mm:ss";
    public final static String HHmm = "HHmm";

    /**
     * 获取格式：年
     *
     * @param date
     * @return
     */
    public static String getYearDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return format.format(date);
    }


    /**
     * 获取格式：月份
     *
     * @param date
     * @return
     */
    public static String getMonthDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("MM");
        return format.format(date);
    }


    /**
     * 获取格式天
     *
     * @param date
     * @return
     */
    public static String getDayDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd");
        return format.format(date);
    }

    /**
     * 获取普通日期格式
     *
     * @param date
     * @return
     */
    public static String getDateFormat(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }


    /**
     * 根据String 获取普通日期类型
     *
     * @param dateStr
     * @return
     */
    public static Date getDateByFormat(String dateStr,String dateFormat) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据num 获取距当前日期的时间
     *
     * @param num
     * @return
     */
    public static Date addNumByToday(int num) {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, day + num);
        return cal.getTime();
    }


    /**
     * 根据指定日期格式和指定日期获取日期字符串
     *
     * @param date
     * @param dataFormat
     * @return
     */
    public static String getFormatByDate(Date date, String dataFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dataFormat);
        return format.format(date);
    }

    /**
     * @param dateStr
     * @param dateFormat 原日期字符串 格式
     * @return
     */
    public static Date getDateStrByFormat(String dateStr, String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param dateStr
     * @param oldDateFormat 原日期字符串 格式
     * @param newDateFormat 新生成的日期字符串格式
     * @return
     */
    public static String getDateStrByFormat2(String dateStr, String oldDateFormat, String newDateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(oldDateFormat);
        try {
            Date date = format.parse(dateStr);
            return getFormatByDate(date, newDateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getDateStrByFormat3(LocalDateTime now) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = now.format(formatter);

        return formatDateTime;
    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getDateStringmmss(Date currentTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     *     * 获取现在时间
     *     *
     *     * @return 返回短时间字符串格式yyyy-MM-dd
     *
     */
    public static String getDateStringMMdd(Date currentTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getLocalDateTimeStringmmss(LocalDateTime localDateTime) {
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTimeString = dtf1.format(localDateTime);
        return localDateTimeString;
    }

    public static String getLocalDateTimeStringMMDDNian(LocalDateTime localDateTime) {
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String localDateTimeString = dtf1.format(localDateTime);
        return localDateTimeString;
    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getLocalDateTimeStringMMdd(LocalDateTime localDateTime) {
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String localDateTimeString = dtf1.format(localDateTime);
        return localDateTimeString;
    }


    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getLocalDateTimeYYMMdd(LocalDateTime localDateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        return dtf.format(localDateTime);
    }

    /**
     * date 转LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * LocalDateTime 转 date
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone( ZoneId.systemDefault()).toInstant());
    }


    public static void main(String[] args) {

        //zdiai_soms_sailing_zhaoshang_newhonor_20200302_20210105
//        String str = getDateStrByFormat2("2021/1/31 04:18:21","yyyy/MM/dd HH:mm:ss", "yyyyMMdd");
//        Date date = getDateByFormat("2021-01-31 00:00:00");
//        System.out.println(date);
        Date date = getDateByFormat("2021-01-31",YYYYMMDDHHMMSS2);
        System.out.println(date);

    }
}
