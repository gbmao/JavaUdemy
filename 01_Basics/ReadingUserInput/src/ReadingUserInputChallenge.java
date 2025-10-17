import java.util.Scanner;

public class ReadingUserInputChallenge {

    public static void main(String[] args) {

        //ask for number
//    totalSum();

        gabarito();

        // print int in order

    }

    public static void totalSum() {

        int totalSum = 0;
        boolean validNumber = false;

        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {

            do {
                try {
                    System.out.println("Enter number #" + i + ":");
                    int num = convertToInt(scanner.nextLine());
                    totalSum = sum(num, totalSum);
                    validNumber = true;
                } catch (NumberFormatException e) {

                    System.out.println("That's not a valid number ");
                    validNumber = false;
                }


            } while (!validNumber);

        }
        System.out.println(totalSum);
    }

    public static int convertToInt(String number) {

        return Integer.parseInt(number);
    }

    public static int sum(int number, int sum) {

        return sum += number;
    }

    public static void gabarito(){
        Scanner scanner = new Scanner(System.in);

        int count = 1;
        int sum = 0;

        while(count <= 5){

            System.out.println("Enter a number #" + count + ":");

            try {
                sum += Integer.parseInt(scanner.nextLine());
                count++;
            }catch (NumberFormatException e){
                System.out.println("Invalid number");
            }

        }

        System.out.println("total sum is : " +sum);
    }
}
