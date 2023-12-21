package cn.tyrone.java.example.java8.time;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationDemo {

    public static void main(String[] args) {

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusMinutes(1);

        Duration between = Duration.between(start, end);
        long seconds = between.getSeconds();
        System.out.printf("" + seconds);

    }

}
