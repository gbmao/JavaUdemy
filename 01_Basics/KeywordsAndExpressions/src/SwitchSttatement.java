public class SwitchSttatement {
    public static void main(String[] args) {
        int switchValue = 4;

        switch (switchValue) {
            case 1 -> System.out.println("Value is 1");
            case 2 -> System.out.println("Value is 2");
            case 3, 4, 5 -> {
                System.out.println("Value is " + switchValue);
            }
            default -> System.out.println("Not value at all");
        }
        String month = "MARCH";
        System.out.println(month + " is in the " + getQuarter(month));

    }

    public static String getQuarter(String month) {
        return switch (month) {
            case "JANUARY", "FEBRUARY", "MARCH" -> {
               yield "1st";
            }

            case "APRIL", "MAY", "JUNE" -> "2nd";

            case "JULY", "AUGUST", "SEPTEMBER" -> "3rd";

            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4th";

            default -> "bad";
        };
    }

}
