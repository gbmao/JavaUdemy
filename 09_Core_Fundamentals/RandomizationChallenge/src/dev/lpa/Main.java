package dev.lpa;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        List<Integer> result = new ArrayList<>(rollAllDices(random));

        game(result, random);


    }


    public static boolean game(List<Integer> result, Random random) {

        boolean flag = true;

        while (flag) {

            showResult(result);
            Scanner scanner = new Scanner(System.in);

            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("ALL")) {
                result = rollAllDices(random);
            } else if (response.isBlank()) {
                System.out.println("-->");
                System.out.println("Game over. Real game would score and continue");
                flag = false;
            } else {


                try {
                    int [] dicesToBeReroll = Arrays.stream(dicesToBeReroll(response)).sorted().toArray();

                    List<Integer> keep = new ArrayList<>(result);

                    for (int i = dicesToBeReroll.length - 1; i >= 0; i-- ) {
                        keep.remove(dicesToBeReroll[i]);
                        result.set(dicesToBeReroll[i], random.nextInt(1,7));
                    }


                    System.out.println("Keeping : " + keep);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid input! ");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input");
                }
            }
        }

        return true;
    }

    public static List<Integer> rollAllDices(Random random) {
        return random.ints(5, 1, 7)
                .boxed().toList();
    }

    public static void showResult(List<Integer> result) {
        System.out.println("You're dice are: " + result);
        System.out.println("Press Enter to Score.");
        System.out.println("Type \"ALL\" to re-roll all the dice.");
        System.out.println("List numbers (separated by spaces) to re-roll selected dice.");
    }

    public static int[] dicesToBeReroll(String response){

        return
                Arrays.stream(response.split(" "))
                        .mapToInt(Integer::parseInt)
                        .map(n -> n - 1)
                        .toArray()
                        ;
    }


}
