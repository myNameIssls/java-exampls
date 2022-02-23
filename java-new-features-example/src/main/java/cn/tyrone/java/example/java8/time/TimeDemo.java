package cn.tyrone.java.example.java8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;

/**
 * JDK 8 日期示例程序
 */
public class TimeDemo {

    public static void main(String[] args) {
        // 获取当前日期
        LocalDate localDate = LocalDate.now();
        System.out.println("获取当前日期：" + localDate);
        // 获取当前日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("获取当前日期时间：" + localDateTime);
        System.out.println("---------------------------------");
        // 获取当前日期-年份
        int year = localDateTime.getYear(); // 年份
        System.out.println("获取当前日期-年份：" + year);
        // 获取当前日期-月份
        int monthValue = localDateTime.getMonthValue(); // 月
        System.out.println("获取当前日期-月份：" + monthValue);
        // 获取当前日期-日
        int dayOfMonth = localDateTime.getDayOfMonth(); // 日
        System.out.println("获取当前日期-日：" + dayOfMonth);
        // 获取当前日期时间小时
        int hour = localDateTime.getHour();
        System.out.println("获取当前日期时间小时：" + hour);
        // 获取当前日期时间分钟
        int minute = localDateTime.getMinute();
        System.out.println("获取当前日期时间分钟：" + minute);
        // 获取当前日期时间秒
        int second = localDateTime.getSecond();
        System.out.println("获取当前日期时间秒：" + second);
        // 获取当前日期当月第一天是几号
        int firstDay = localDateTime.with(TemporalAdjusters.firstDayOfMonth()).getDayOfMonth();
        System.out.println("获取当前日期当月第一天：" + firstDay);
        // 获取当前日期当月最后一天是几号
        int lastDay = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
        System.out.println("获取当前日期当月最后一天：" + lastDay);

        WeekFields weekFields = WeekFields.of(DayOfWeek.SUNDAY, 7);
        // 获取当前日期是当年第几周
        int weekCount = localDate.get(weekFields.weekOfYear());
        System.out.println("获取当前日期是当年第几周：" + weekCount);

        System.out.println("---------------------------------");
        // 当前日期加1天,
        LocalDate plusDays = localDate.plusDays(1);
        System.out.println("当前日期：" + localDate + "\t" + "当前日期加1天：" + plusDays);
        // 当前日期减1天,
        LocalDate minusDays = localDate.minusDays(1);
        System.out.println("当前日期：" + localDate + "\t" + "当前日期加1天：" + minusDays);
        // 当前日期减1周,
        LocalDate minusWeeks = localDate.minusWeeks(1);
        System.out.println("当前日期：" + localDate + "\t" + "当前日期减1周：" + minusWeeks);
        // 当前日期减1月
        LocalDate minusMonths = localDate.minusMonths(1);
        System.out.println("当前日期：" + localDate + "\t" + "当前日期减1月：" + minusMonths);
        // 当前日期减1年
        LocalDate minusYears = localDate.minusYears(1);
        System.out.println("当前日期：" + localDate + "\t" + "当前日期减1年：" + minusYears);
        // 当前时间减1小时
        LocalDateTime minusHours = localDateTime.minusHours(1);
        // 当前时间减1分钟
        LocalDateTime minusMinutes = localDateTime.minusMinutes(1);
        // 当前时间减1秒
        LocalDateTime minusSeconds = localDateTime.minusSeconds(1);
        System.out.println("---------------------------------");



    }

}
