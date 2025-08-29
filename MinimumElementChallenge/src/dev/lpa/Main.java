package dev.lpa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        int[] intArray = readIntegers();
        System.out.println("min: " + findMin(intArray));


    }

    private static int[] readIntegers() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("input numbers separated by comma :");
        String input = scanner.nextLine();


        String[] newArray = input.split(",");

        int[] intArray = new int[newArray.length];

        for (int i = 0; i < newArray.length; i++) {
            intArray[i] = Integer.parseInt(newArray[i].trim());
        }

        return intArray;
    }

    private static int findMin(int[] num) {

        int min = num[0];

        for(int i : num) {

            if(i < min) {
                min = i;
            }
        }

        return min;
    }
}
