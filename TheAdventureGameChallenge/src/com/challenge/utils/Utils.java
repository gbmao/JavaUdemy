package com.challenge.utils;

import java.util.Scanner;
import java.util.Set;

public class Utils {

    private static Scanner scanner = new Scanner(System.in);


    public static String inputResponse(Set<String> keys) {
        while (true) {
            String response = scanner.nextLine();
            try {
                if (!keys.contains(response.substring(0, 1).toUpperCase()) &&
                        response.toLowerCase().charAt(0) != 'q') {
                    System.out.println(response + " Not a valid answer!");
                    System.out.print("Response: ");
                } else {
                    return response.substring(0, 1).toUpperCase();
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println(response + " Not a valid answer!");
                System.out.print("Response: ");
            }
        }
    }

}
