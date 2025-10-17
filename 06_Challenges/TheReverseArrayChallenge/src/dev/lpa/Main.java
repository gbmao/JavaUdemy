package dev.lpa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] newArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        reverseArray(newArray);
        System.out.println(Arrays.toString(newArray));
    }

    private static void reverseArray(int[] nums) {
        printArray(nums);
        int[] reversedArray = new int[nums.length];
        int j = nums.length - 1;
        int temp = 0;
//        for (int i = 0; i < nums.length / 2; i++, j--) {
//            temp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = temp;
//
//        }

        for (int i : nums) {
            reversedArray[j] = i;
            j--;
        }

        printArray(reversedArray);

    }

    private static void printArray(int[] nums) {

        for (int i : nums) {
            System.out.print(i + " ");

        }
        System.out.println();
    }
}
