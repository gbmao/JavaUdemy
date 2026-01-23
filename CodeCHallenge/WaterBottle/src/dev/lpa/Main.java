package dev.lpa;

public class Main {
    public static void main(String[] args) {


        System.out.println(numWaterBottles(15, 4));

    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int totalDrinkBottles = numBottles;

        int emptyBottles = numBottles;
        while ((numBottles / numExchange) > 0) {

            emptyBottles = numBottles % numExchange;

            numBottles = numBottles / numExchange;

            totalDrinkBottles += numBottles;

            numBottles += emptyBottles;
        }


        return totalDrinkBottles;
    }

}

