package dev.lpa;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;

public class Main {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate Five5 = LocalDate.of(2022, 5, 5);
        System.out.println(Five5);

        LocalDate May5th = LocalDate.of(2022, Month.MAY, 5);
        System.out.println(May5th);

        LocalDate day125 = LocalDate.ofYearDay(2025,125);
        System.out.println(day125);

        LocalDate may5 = LocalDate.parse("2022-05-05");
        System.out.println(may5);

        System.out.println(may5.getYear());
        System.out.println(may5.getMonth());


        System.out.println(may5.getMonthValue());
        System.out.println(may5.getDayOfMonth());
        System.out.println(may5.getDayOfWeek());
        System.out.println(may5.getDayOfYear());

        System.out.println(may5.get(ChronoField.YEAR));
        System.out.println(may5.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(may5.get(ChronoField.DAY_OF_MONTH));
        System.out.println(may5.get(ChronoField.DAY_OF_YEAR));

        System.out.println(may5.withYear(2000));
        System.out.println(may5.withMonth(3));
        System.out.println(may5.withDayOfMonth(4));
        System.out.println(may5.withDayOfYear(126));

        System.out.println(may5.with(ChronoField.DAY_OF_YEAR, 126));

        System.out.println(may5.plusYears(120));
        System.out.println(may5.plusMonths(120));
        System.out.println(may5.plusDays(120));
        System.out.println(may5.plusWeeks(120));

        System.out.println("May5 > today? " + may5.isAfter(today));
        System.out.println("May5 < today? " + may5.isBefore(today));

        System.out.println("May5 > today? " + may5.compareTo(today));
        System.out.println("May5 < today? " + today.compareTo(may5));

        System.out.println(today.isLeapYear());
        System.out.println(may5.minusYears(2).isLeapYear());

        System.out.println("-------------------------");
        may5.datesUntil(may5.plusDays(7))
                .forEach(System.out::println);

        System.out.println("-------------------------");
        may5.datesUntil(may5.plusYears(1), Period.ofDays(7))
                .forEach(System.out::println);


        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime sevenAM = LocalTime.of(7,0);
        LocalTime seventhirtAM = LocalTime.of(7,30,15);

        System.out.println(sevenAM);
        System.out.println(seventhirtAM);

        LocalTime sevenPM = LocalTime.parse("19:00");
        LocalTime sevenThirtyPM = LocalTime.parse("19:30:15.1000");

        System.out.println(sevenPM);
        System.out.println(sevenThirtyPM);

        System.out.println(sevenThirtyPM.getHour());

        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);


        System.out.println(LocalDate.now().format(dtf));
        }
}
