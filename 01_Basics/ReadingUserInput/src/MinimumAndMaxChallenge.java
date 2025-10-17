import java.util.Scanner;

public class MinimumAndMaxChallenge {

    public static void main(String[] args) {

        challenge();

    }

    public static void challenge() {

        Scanner scanner = new Scanner(System.in);
        double minimumValue = 0;
        double maximumValue = 0;
        double number = 0;
        boolean isNumber = true;
        boolean isTrue = true;

        do {

            System.out.println("Enter a valid number : ");

            try {
                number = Double.parseDouble(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Showing results....");
                isNumber = false;
            }
            if (isTrue) {
                minimumValue = number;
                isTrue = false;
            }
//            Math.round()

            minimumValue = returnMin(number, minimumValue);


            maximumValue = returnMax(number, maximumValue);

        } while (isNumber);

        System.out.println("Maximum number is : " + maximumValue);
        System.out.println("Minimum value is : " + minimumValue);
    }

    public static double returnMax(double number, double max) {
        if (number > max) {
            return number;
        }
        return max;
    }

    public static double returnMin(double number, double min) {
        if (number < min) {
            min = number;
        }
        return min;
    }
}
