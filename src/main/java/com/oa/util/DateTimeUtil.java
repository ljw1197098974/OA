package com.oa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang.StringUtils;

public class DateTimeUtil {

    public static final String GMT = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";
    public static final String YYYY = "yyyy";
    public static final String YYYY_MM = "yyyy-MM";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMMDD_HH_MM = "yyyyMMdd HH:mm";
    public static final String YYYYMMDD_HH_MM_SS = "yyyyMMdd HH:mm:ss";
    public static final String YYYYMMDDHH_MM_SS = "yyyyMMddHH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String JS_DATE = "yyyy/MM/dd HH:mm:ss";
    public static final String MM_DD_HH_MM = "MM-dd HH:mm";
    public static final String HH_MM = "HH:mm";
    public static final String HH_MM_SS = "HH:mm:ss";
    public static final String WEEKDAY_START_TIME = " 08:30";
    public static final String WEEKDAY_END_TIME = " 17:30";

    public DateTimeUtil() {
    }

    public static Boolean isDateType(Object obj) {
        if (obj.equals((Object)null)) {
            return false;
        } else {
            return ("" + obj).length() < 8 ? false : true;
        }
    }

    public static String getMonthAgo(int months, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(2, months);
        String date = sdf.format(calendar.getTime());
        return date;
    }

    public static List<String> getDates(String startDate, String endDate, String format) {
        List<String> ret = new ArrayList();
        if (!StringUtils.isBlank(startDate) && !StringUtils.isBlank(endDate)) {
            try {
                int limit = haveDays(startDate, endDate, format);
                Date start = parse(startDate, format);
                int i = 0;

                for(int j = limit; i <= j; ++i) {
                    ret.add(getDaysAfter(start, i, format));
                }
            } catch (Exception var8) {
                //logger.error("getDates", var8);
            }

            return ret;
        } else {
            return ret;
        }
    }

    public static String getSomeMonthYet(int months, String pDate, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(pDate));
        calendar.add(2, months);
        String date = sdf.format(calendar.getTime());
        return date;
    }

    public static String getSomeMinutesDate(String dateTiem, int minutes, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(dateTiem));
        calendar.add(12, minutes);
        String date = sdf.format(calendar.getTime());
        return date;
    }

    public static String getToday() {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }

    public static Date getNow() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    public static String getFirstDayOfYear(int preOrNext, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(6, 1);
        calendar.add(1, preOrNext);
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String date = sdf.format(calendar.getTime());
        return date;
    }

    public static String getPreviousYearFirst() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String year = dateFormat.format(date);
        int years_value = Integer.parseInt(year);
        --years_value;
        return years_value + "-01-01";
    }

    public static String getToday(String format) {
        return (new SimpleDateFormat(format)).format(new Date());
    }

    public static Date convertToDateTime(String _date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;

        try {
            date = sdf.parse(_date);
        } catch (ParseException var5) {
            //logger.error("", var5);
        }

        return date;
    }

    public static Calendar convertToCalendar(String _date, String format) {
        Date date = convertToDateTime(_date, format);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static String convertDateToString(Date _date, String format) {
        if (null != _date) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(_date);
        } else {
            return null;
        }
    }

    public static Integer dateDiff(String howToCompare, Date startDate, Date endDate) {
        return null;
    }

    public static String replaceDigtalToChineseNumber(String date) {
        return null;
    }

    public static String replaceChineseNumber(String date) {
        return null;
    }

    public static String convertChineseYear(String date) {
        return null;
    }

    public static String convertChineseMonth(String date) {
        return null;
    }

    public static String convertChineseDate(String date) {
        return null;
    }

    public static String convertChineseWeek(Integer day) {
        return null;
    }

    public static Date getMondyDayOfWeek(Date dt) {
        return null;
    }

    public static Date getStartDayOfWeek(Date dt) {
        return null;
    }

    public static Date getDateIndexOfWeek(Date dt) {
        return null;
    }

    public static String addDate(String date, Integer dateCount, String formate) throws ParseException {
        if (null == formate || formate.isEmpty()) {
            formate = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        Calendar calendar = null;
        Date date2 = sdf.parse(date);
        calendar = Calendar.getInstance();
        calendar.setTime(date2);
        calendar.add(5, dateCount);
        return sdf.format(calendar.getTime());
    }

    public static String getDays(Date date, int days, String formate) throws ParseException {
        return getDays(date, days, formate, false);
    }

    public static String getDaysAfter(Date date, int days, String formate) throws ParseException {
        return getDays(date, days, formate, true);
    }

    private static String getDays(Date date, int days, String formate, boolean f) throws ParseException {
        if (null == formate || formate.isEmpty()) {
            formate = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (f) {
            calendar.set(5, calendar.get(5) + days);
        } else {
            calendar.set(5, calendar.get(5) - days);
        }

        String endDate = sdf.format(calendar.getTime());
        return endDate;
    }

    public static String addMinutes(String date, int minutes, String formate) throws ParseException {
        if (null == formate || formate.isEmpty()) {
            formate = "yyyy-MM-dd HH:mm:ss";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        Calendar calendar = null;
        Date date2 = sdf.parse(date);
        calendar = Calendar.getInstance();
        calendar.setTime(date2);
        calendar.add(12, minutes);
        return sdf.format(calendar.getTime());
    }

    public static String addSecondsByNow(int seconds, String formate, Locale locale) {
        if (null == formate || formate.isEmpty()) {
            formate = "yyyy-MM-dd HH:mm:ss";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(formate, locale);
        Calendar calendar = Calendar.getInstance();
        calendar.add(13, seconds);
        return sdf.format(calendar.getTime());
    }

    public static Integer haveDays(String startDate, String endDate, String format) {
        long days = -1L;
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date1 = null;
        Date date2 = null;

        try {
            date1 = sdf.parse(startDate);
            date2 = sdf.parse(endDate);
            long result = date2.getTime() - date1.getTime();
            days = result / 86400000L;
        } catch (ParseException var10) {
            //logger.error("", var10);
        }

        return Integer.parseInt(String.valueOf(days));
    }

    public static int havaMinutes(String startDate, String endDate, String format) {
        int minutes = -1;
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date1 = null;
        Date date2 = null;

        try {
            date1 = sdf.parse(startDate);
            date2 = sdf.parse(endDate);
            int result = NumberUtil.convertToInt(date2.getTime() - date1.getTime());
            minutes = result / '\uea60';
        } catch (Exception var8) {
            //logger.error("", var8);
        }

        return minutes;
    }

    public static int compareDate(String strDate, Date date, String format) throws Exception {
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date1 = null;
        Date date2 = null;

        try {
            date1 = sdf.parse(strDate);
            date2 = sdf.parse(sdf.format(date));
            if (date1.getTime() > date2.getTime()) {
                return 1;
            } else {
                return date1.getTime() < date2.getTime() ? -1 : 0;
            }
        } catch (Exception var7) {
            throw new Exception("compareDate", var7);
        }
    }

    public static int compareDate(String strDate1, String strDate2, String format) throws Exception {
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date1 = null;
        Date date2 = null;

        try {
            date1 = sdf.parse(strDate1);
            date2 = sdf.parse(strDate2);
            if (date1.getTime() > date2.getTime()) {
                return 1;
            } else {
                return date1.getTime() < date2.getTime() ? -1 : 0;
            }
        } catch (Exception var7) {
            throw new Exception("compareDate", var7);
        }
    }

    public static String format(String strDate, String formate) throws Exception {
        if (StringUtils.isEmpty(formate)) {
            formate = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat(formate);
        Date date = sdf.parse(strDate);
        return sdf2.format(date);
    }

    public static String format(Date date, String formate) {
        if (StringUtils.isEmpty(formate)) {
            formate = "yyyy-MM-dd";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        return sdf.format(date);
    }

    public static Date parse(String strDate, String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(strDate);
    }

    public static String getDateStatus(String pushDate) throws Exception {
        String return_Code = null;
        String format = "yyyy-MM-dd HH:mm:ss";
        String nowTime = getToday(format);
        if (pushDate.length() == 10) {
            pushDate = pushDate + " 00:00:00";
        } else if (null == pushDate.split(" ")[1].split(":")[1]) {
            pushDate = pushDate + ":00:00";
        } else if (null == pushDate.split(" ")[1].split(":")[2]) {
            pushDate = pushDate + ":00";
        }

        int minutes = havaMinutes(pushDate, nowTime, format);
        int days = haveDays(pushDate, nowTime, format);
        if (compareDate(pushDate, nowTime, format) < 0) {
            if (minutes < 60 && minutes >= 0) {
                return_Code = minutes + "分钟前";
            } else if (minutes >= 60 && days < 1) {
                int hours = minutes / 60;
                return_Code = hours + "小时前";
            } else if (days >= 1 && days < 2) {
                return_Code = days + "天前";
            } else if (days >= 2 && days < 3) {
                return_Code = days + "天前";
            } else if (days >= 3) {
                return_Code = pushDate.split(" ")[0];
            }
        } else {
            return_Code = pushDate.split(" ")[0];
        }

        return return_Code;
    }

    public static String getLastMonthFinallyDate() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(2);
        calendar.set(2, month - 1);
        calendar.set(5, calendar.getActualMaximum(5));
        Date date = calendar.getTime();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String returDate = sf.format(date);
        return returDate;
    }

    public static boolean scope(String now, String ss, String ee) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        long s = sdf.parse(ss).getTime();
        long e = sdf.parse(ee).getTime();
        long c = sdf.parse(sdf.format(convertToDateTime(now, "HH:mm"))).getTime();
        return c >= s && c <= e;
    }

    public static long getSeconds(Date date, int minutes) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(12, minutes);
        long seconds = calendar.getTime().getTime();
        return seconds;
    }
}
