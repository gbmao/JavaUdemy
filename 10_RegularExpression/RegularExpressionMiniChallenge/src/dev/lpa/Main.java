package dev.lpa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String helloWorld = """
        Hello, World!
        Hola, Mundo!
        Olá, Mundo!""";

        System.out.println(matches(helloWorld,"Hello, World!"));

        System.out.println("----------------");

        System.out.println(streamMatch(helloWorld, "Hello, World!"));


        System.out.println("Challenge 2:");

        String helloWorld2 = """
        The bike is red.
        I am a new student.
        hello World.
        How are you?
        """;

        var splitHelloWorld = helloWorld2.split("\\R");
        for (String s : splitHelloWorld) {

        System.out.println("Expression: (" + s + ")  IS " + secondChallenge(s));
        }

        //tim solution

        String match = "[A-Z].*\\.";

        for (String s : splitHelloWorld) {
            boolean matched = s.matches(match);
            System.out.println(matched + ": " + s);
        }

        System.out.println("Mini challenge 3");

        String helloWorld3 = """
        The bike is red, and has flat tires.
        I love being a new L.P.A student!
        Hello, friends and family:Welcome!
        How are you,Mary?
        """;
         var splitHelloWorld3 = helloWorld3.split("\\R");

        String startMatch = "[A-Z].*[.|!?]";
//        String endMatch = ".*[.|!?]";

        for (String s : splitHelloWorld3) {
            boolean matched = s.matches(startMatch);
//            && s.matches(endMatch));
            System.out.println(matched + ": " + s);
        }


    }

    public static String matches(String input, String regex) {

        var split = input.split("\\R");
        for (String s : split) {
        if(s.matches(regex)) {
           return "matches";
        }
        }
        return "Not matches";
    }

    public static String streamMatch(String input, String matches) {

        return input.lines()
                .filter(s -> s.matches(matches))
                .findAny()
                .orElse("Not matches");
//        return Arrays.stream(input.split("\\R"))
//                .filter(s -> s.matches(matches))
//                .findAny()
//                .orElse("Not matches");
    }

    public static String secondChallenge(String input) {
        var split = input.split("");


        if (split[0].matches("[A-Z]")
        && split[split.length -1].matches("\\.")) {
            return "A MATCH!";
        }

        return "NOT MATCH!";
    }




}
