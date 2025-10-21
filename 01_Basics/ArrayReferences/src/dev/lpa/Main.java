package dev.lpa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] myIntArray = new int[5];
        int[] anotherArray = myIntArray;
        System.out.println("MyintArray :" + Arrays.toString(anotherArray));
        System.out.println("MyintArray :" + Arrays.toString(myIntArray));


        anotherArray[0] = 1;
        modifyArray(myIntArray);
        System.out.println("after change MyintArray :" + Arrays.toString(myIntArray));
        System.out.println("after change MyintArray :" + Arrays.toString(anotherArray));
    }

    private static void modifyArray(int[ ] array) {

        array[1] = 2;
    }
}
