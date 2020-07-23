package com.qianluohan.basic.utils;

import com.qianluohan.basic.exception.CustomizedException;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期处理
 *
 * @author luyuwei luyuwei@bmsoft.com.cn
 */
public class DateUtils {

	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
    public final static String DATE_PATTERN_CN = "yyyy年MM月dd日";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_TIME_DETAIL = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     * @param date  日期
     * @return  返回yyyy-MM-dd格式日期
     */
	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String formatCn(Date date) {
        return format(date, DATE_PATTERN_CN);
    }

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     * @param date  日期
     * @param pattern  格式，如：DateUtils.DATE_TIME_PATTERN
     * @return  返回yyyy-MM-dd格式日期
     */
    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 字符串转换成日期
     * @param strDate 日期字符串
     * @param pattern 日期的格式，如：DateUtils.DATE_TIME_PATTERN
     */
    public static Date stringToDate(String strDate, String pattern) {
        if (StringUtils.isNull(strDate)){
            return null;
        }

        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
        return fmt.parseLocalDateTime(strDate).toDate();
    }

    public static Date stringToSpecialDate(String strDate, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            //将字符串转换成Date类型方便SimpleDateFormat的转换
            Date date = new Date(strDate);
            //再将date转换成指定样式的字符串
            String format1 = format.format(date);
            Date parse = format.parse(format1);
            System.out.println("时间为----------------"+parse);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String date2str(Date d) {
        if (d != null) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sf.format(d);
        }
        return null;
    }

    public static String date2String(Date d) {
        if (d != null) {
            SimpleDateFormat sf = new SimpleDateFormat(DATE_PATTERN);
            return sf.format(d);
        }
        return null;
    }

    /**
     * 根据周数，获取开始日期、结束日期
     * @param week  周期  0本周，-1上周，-2上上周，1下周，2下下周
     * @return  返回date[0]开始日期、date[1]结束日期
     */
    public static Date[] getWeekStartAndEnd(int week) {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime.plusWeeks(week));

        date = date.dayOfWeek().withMinimumValue();
        Date beginDate = date.toDate();
        Date endDate = date.plusDays(6).toDate();
        return new Date[]{beginDate, endDate};
    }

    /**
     * 对日期的【秒】进行加/减
     *
     * @param date 日期
     * @param seconds 秒数，负数为减
     * @return 加/减几秒后的日期
     */
    public static Date addDateSeconds(Date date, int seconds) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusSeconds(seconds).toDate();
    }

    /**
     * 对日期的【分钟】进行加/减
     *
     * @param date 日期
     * @param minutes 分钟数，负数为减
     * @return 加/减几分钟后的日期
     */
    public static Date addDateMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMinutes(minutes).toDate();
    }

    /**
     * 对日期的【小时】进行加/减
     *
     * @param date 日期
     * @param hours 小时数，负数为减
     * @return 加/减几小时后的日期
     */
    public static Date addDateHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(hours).toDate();
    }

    /**
     * 对日期的【天】进行加/减
     *
     * @param date 日期
     * @param days 天数，负数为减
     * @return 加/减几天后的日期
     */
    public static Date addDateDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(days).toDate();
    }

    /**
     * 对日期的【周】进行加/减
     *
     * @param date 日期
     * @param weeks 周数，负数为减
     * @return 加/减几周后的日期
     */
    public static Date addDateWeeks(Date date, int weeks) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusWeeks(weeks).toDate();
    }

    /**
     * 对日期的【月】进行加/减
     *
     * @param date 日期
     * @param months 月数，负数为减
     * @return 加/减几月后的日期
     */
    public static Date addDateMonths(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMonths(months).toDate();
    }

    /**
     * 对日期的【年】进行加/减
     *
     * @param date 日期
     * @param years 年数，负数为减
     * @return 加/减几年后的日期
     */
    public static Date addDateYears(Date date, int years) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusYears(years).toDate();
    }

    /**
     * 相差年数：date1 - date2
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int dateDifferenceByYear(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar2.setTime(date2);

        int year1 = calendar1.get(Calendar.YEAR);
        int year2 = calendar2.get(Calendar.YEAR);

        return year1 - year2;
    }

    /**
     * 相差月数：date1 - date2
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int dateDifferenceByMonth(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar2.setTime(date2);

        // 算上年份差
        int differenceYear = dateDifferenceByYear(date1, date2);

        int month1 = (differenceYear * 12) + calendar1.get(Calendar.MONTH) + 1;
        int month2 = calendar2.get(Calendar.MONTH) + 1;

        return month1 - month2;
    }

    /**
     * 相差天数：date1 - date2
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int dateDifferenceByDay(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar2.setTime(date2);

        // 算上年份差
        int differenceYear = dateDifferenceByYear(date1, date2);

        int day1 = (differenceYear * 365) + calendar1.get(Calendar.DAY_OF_YEAR) + 1;
        int day2 = calendar2.get(Calendar.DAY_OF_YEAR) + 1;

        return day1 - day2;
    }

    /**
     * 获取某个时间段的所有日期字符串yyyy-MM-dd
     */
    public static List<String> dateListBetweenDate(String beginDate, String endDate){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dBegin = sdf.parse(beginDate);
            Date dEnd = sdf.parse(endDate);
            List<String> lDate = new ArrayList<String>();
            lDate.add(sdf.format(dBegin));
            while (dEnd.after(dBegin)){
                dBegin = addDateDays(dBegin, 1);
                lDate.add(sdf.format(dBegin));
            }
            return lDate;
        }catch (ParseException e){
            throw new CustomizedException("时间输入出错");
        }
    }

    /**
     * 获取某个时间段的所有月份字符串yyyy-MM
     */
    public static List<String> monthListBetweenMonth(String beginDate, String endDate){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            Date dBegin = sdf.parse(beginDate);
            Date dEnd = sdf.parse(endDate);
            List<String> lDate = new ArrayList<String>();
            lDate.add(beginDate);
            while (dEnd.after(dBegin)){
                dBegin = addDateMonths(dBegin, 1);
                lDate.add(sdf.format(dBegin));
            }
            return lDate;
        }catch (ParseException e){
            throw new CustomizedException("时间输入出错");
        }
    }

    /**
     * 获取某一周内的所有日期字符串yyyy-MM-dd
     */
    public static List<String> dateListBetweenWeek(String week){
        List<String> lDate = new ArrayList<String>();
        Date weekDate = stringToDate(week, "yyyy-ww");
        Calendar cl = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        assert weekDate != null;
        cl.setTime(weekDate);
        c2.setTime( new Date());
        int weekNum = cl.get(Calendar.WEEK_OF_YEAR);
        int nowWeek = c2.get(Calendar.WEEK_OF_YEAR);
        Date[] weekStartAndEnd = getWeekStartAndEnd(weekNum - nowWeek);
        return dateListBetweenDate(date2str(weekStartAndEnd[0]), date2str(weekStartAndEnd[1]));
    }

    /**
     * 增加日期的天数。失败返回null。
     *
     * @param date
     *            日期
     * @param dayAmount
     *            增加数量。可为负数
     * @return 增加天数后的日期
     */
    public static Date addDay(Date date, int dayAmount) {
        return addInteger(date, Calendar.DATE, dayAmount);
    }

    /**
     * 增加日期中某类型的某数值。如增加日期
     *
     * @param date
     *            日期
     * @param dateType
     *            类型
     * @param amount
     *            数值
     * @return 计算后日期
     */
    private static Date addInteger(Date date, int dateType, int amount) {
        Date myDate = null;
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(dateType, amount);
            myDate = calendar.getTime();
        }
        return myDate;
    }

    /**判断是否超过几小时
     *
     * @param date1
     * @param date2
     * @param hour
     * @return boolean
     * @throws Exception
     */

    public static boolean isMoreHours(String date1, String date2,int hour) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date start = sdf.parse(date1);

        Date end = sdf.parse(date2);

        long cha = end.getTime() - start.getTime();

        if(cha<0){

            return false;

        }

        double result = cha * 1.0 / (1000 * 60 * 60);

        if(result<=hour){

            return true;

        }else{

            return false;

        }

    }

}
