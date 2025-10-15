package dev.lpa;

public class Main {
    public static void main(String[] args) {

        Theatre teatro = new Theatre("Teatro Popular", 6, 32);

        teatro.printSeatMap();

        teatro.reserveSeat2("B", 1);
        teatro.reserveSeat2("B", 1);
        teatro.reserveSeat2("C", 1);
        teatro.printSeatMap();
    }
}
