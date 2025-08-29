package dev.lpa;

public class Main {
    public  static void main(String... args) {
        System.out.println("Hello world again");

        String[] splitStrings = "Hello world again".split(" ");
        printText(splitStrings);
        System.out.println("-".repeat(20));
        printText("Here");
        System.out.println("-".repeat(20));
        printText("Hello", "World", "Again");
        System.out.println("-".repeat(20));
        printText();
        String[] sArray = {"First", "Second", "Third", "Fourth", "Fifth"};
        System.out.println(String.join(",", sArray));


        int[] integer = new int[] {1,2,3};
        sum(integer);
        sum(10);
    }

    private static void printText(String... textList) {

        for(String t : textList) {
            System.out.println(t);
        }
    }

    private static void sum(int... num) {
        int total = 0;
        for(int u : num) {
            total += u;
        }

        System.out.println(total);
    }
}
