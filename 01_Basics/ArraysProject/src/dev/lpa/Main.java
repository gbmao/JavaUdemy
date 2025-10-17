package dev.lpa;

import java.sql.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] myIntArray = new int[10];
        myIntArray[0] = 45;
        myIntArray[1] = 1;
        myIntArray[5] = 50;

        double[] myDoubleArray = new double[10];
        myDoubleArray[2] = 3.5;
        System.out.println(myDoubleArray[2]);

        int[] firstTen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("First = " + firstTen[0]);
        int arrayLength = firstTen.length;
        System.out.println("length of array " + arrayLength);


        int[] newArray;
        newArray = new int[]{5, 4, 3, 2, 1};

        for (int numbers : newArray){
            System.out.println(numbers);
        }

        System.out.println(newArray);

        String[] strArray = new String[]{"um", "dois"};

        String arrayElementsInString = Arrays.toString(newArray);
        System.out.println(arrayElementsInString);

        Object objectVariable = newArray;

        if (objectVariable instanceof  int[]){
            System.out.println("Is an int array");
        }

        Object[] objectArray = new Object[3];
        objectArray[0] = " Hello";
        objectArray[1] = new StringBuilder("World");
        objectArray[2] = 2;

    }
}
