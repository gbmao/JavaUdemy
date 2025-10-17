package dev.lpa.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    Scanner scanner = new Scanner(System.in);

    public  int intInput(int a, int b) {

        boolean isInt = true;
        int response = 0;
        while(isInt) {
            isInt = false;
            try {
                System.out.print("Digite : ");
                response = scanner.nextInt();
                if(response < a || response> b){
                    throw new  IllegalArgumentException(
                            String.format("Valor fora do range%nDigite um valor entre %s e %s%n", a, b));
                }
            } catch (InputMismatchException e) {
                System.out.println("Isto nao e um numero inteiro");
                scanner.nextLine();
                isInt = true;
            } catch (IllegalArgumentException e){
                System.out.print(e.getMessage());
                isInt = true;
            }
        }
        scanner.nextLine();
        return response;
    }

    public String[] separatedByCommaInput() {

        String response = "";
        boolean notValid = true;
         try {
             System.out.println("Digite os items separados por virgula: ");
              response = scanner.nextLine().trim();
         } catch (InputMismatchException e) {
             System.out.println("Digitou algo errado ai");
         }


         return  response.trim().toLowerCase().split(",");
    }
}
