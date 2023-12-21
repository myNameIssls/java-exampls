package cn.tyrone.java.example.java8.time;

import java.time.LocalDateTime;
import java.time.Period;

public class PeriodDemo {

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusDays(3);
        Period between = Period.between(start.toLocalDate(), end.toLocalDate());
        int days = between.getDays();
        System.out.printf("" + days);

    }

}
