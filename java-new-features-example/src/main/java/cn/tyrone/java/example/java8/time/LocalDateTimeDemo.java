package cn.tyrone.java.example.java8.time;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDemo {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

//        String s = rfc3339(now);

        formatT();

    }

    public static String rfc3339(LocalDateTime localDateTime){

        // format : 2023-12-21T19:43:34.803551+08:00
        String format = localDateTime.atOffset(ZoneOffset.ofHours(8)).format((DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        System.out.println("" + format);

        // format : 2023-12-21T19:43:34+08:00
        String format1 = localDateTime.atOffset(ZoneOffset.ofHours(8)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX"));
        System.out.printf("" + format1);


        return format;

    }

    public static void formatT(){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();
        String format = now.format(dateTimeFormatter);
        System.out.println(format);

        LocalDateTime parse = LocalDateTime.parse(format, dateTimeFormatter);
        System.out.println(parse.toString());


    }


}
