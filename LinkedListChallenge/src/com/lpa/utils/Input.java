package com.lpa.utils;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public char userInputToChar(char... a) {

        String input = "";

        boolean flag = true;

        while (flag) {
            try {
                input = scanner.nextLine().trim().toLowerCase();

            for (char i : a) {
                if (i == input.charAt(0)) {
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println("Insert an valid option!");

            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("That's not an option");
            }
        }


        return input.charAt(0);

    }
}
