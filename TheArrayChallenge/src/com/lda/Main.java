package com.lda;

import java.util.Arrays;
import java.util.Random;
public class Main {
    public static void main(String[] args) {

        int[] resultArray = getRandomArray(10);
        System.out.println(Arrays.toString(resultArray));
        Arrays.sort(resultArray);
        System.out.println(Arrays.toString(resultArray));
        resultArray = reverseSort(resultArray);

        System.out.println(Arrays.toString(resultArray));

    }

    private static int[] reverseSort(int[] array) {
        int[] reversedArray = new int[array.length];

        for (int i = 0, j = array.length - 1; i < array.length; i++, j--) {
            reversedArray[i] = array[j];
        }
        return reversedArray;

    }

    private static int[] getRandomArray(int len) {
        Random random = new Random();

        int[] array = new int[len];

        for (int i = 0; i < len; i++) {

            array[i] = random.nextInt(100);
        }

        return array;
    }
}


