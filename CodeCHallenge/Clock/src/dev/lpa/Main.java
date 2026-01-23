package dev.lpa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] num = {9};

        System.out.println(Arrays.toString(plusOne(num)));

    }

    public static int[] plusOne(int[] digits) {
        int number = 0;
        if(digits[digits.length-1] != 9 ) {
            digits[digits.length -1] += 1;

            return digits;
        } else {
            boolean isNine = true;
//            digits[digits.length -1] = 0;
        for(int i = digits.length - 1; i >= 0; i--) {

            if (isNine) {
                if(digits[i] != 9) {
                   digits[i] += 1;
                   return  digits;
                }
                if (i == 0 && digits[i] == 9) {
                    int[] response = new int[digits.length + 1];
                    response[0] = 1;
                    digits[i] = 0;
                    for (int j = 0; j < digits.length; j++) {
                        response[j + 1] = digits[j];
                    }
                    return response;
                }
                digits[i] = 0;
            }

        }
        }

        return digits;
    }
}
