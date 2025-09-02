package dev.lpa;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        DayOfTheWeek weekDay = DayOfTheWeek.TUES;
        System.out.println(weekDay);


        for(int i = 0; i < 10; i++) {
            weekDay = getRandomDay();
//        System.out.printf("Name is %s, ordial value  = %d%n",
//                weekDay.name(), weekDay.ordinal());
//
//
//        if(weekDay == DayOfTheWeek.FRI) {
//            System.out.println("Found a FRIDAY!");
//        }
            switchDayOfWeek(weekDay);
        }


        for( Topping topping : Topping.values()) {
            System.out.println(topping.name() + " : " + topping.getPrice());
        }


    }

    public static void switchDayOfWeek(DayOfTheWeek weekDay) {
        int weekDayInteger = weekDay.ordinal() +1;

        switch (weekDay) {
            case WED -> System.out.println("Wednesday is day " + weekDayInteger);
            case SAT -> System.out.println("Saturday is day " + weekDayInteger);
            default -> System.out.println(weekDay.name().charAt(0) +
                    weekDay.name().substring(1).toLowerCase() +
                    "day is day " +weekDayInteger);
        }
    }

    public static DayOfTheWeek getRandomDay() {

        int randomInteger = new Random().nextInt(7);
        var allDays = DayOfTheWeek.values();

        return allDays[randomInteger];
    }
}
