public class Main {
    public static void main(String[] args){

        String bulletIt = "Print a bulleted List:\n" +
                "\t\u2022 First Point\n" +
                "\t\t\u2022 Sub Point";

        System.out.println(bulletIt);

        String textBlock = """
                Print a bulleted List:
                    \u2022 First Point
                        \u2022 SubPoint""";

        System.out.println(textBlock);

        int age = 34;

        System.out.printf("Your age is %d%n, rest only %.2f ", age, (float) 40 - age);

        String formattedString = String.format("Yor age is %d", age);

        System.out.printf(formattedString);

    }
}
