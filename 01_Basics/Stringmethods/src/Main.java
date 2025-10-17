public class Main {
    public static void main(String[] args) {
//        String hi = "Hello world";
//
//        System.out.println(hi.indexOf('a'));
//
//        String ei = hi.replaceAll("Hello", "hihi");
//
//        System.out.println(ei);

//        String birthDate = "25/11/1982";
//        int startingIndex = birthDate.indexOf("1982");
//        System.out.println("startingIndex = " + startingIndex);
//        System.out.println("Birth year " + birthDate.substring(startingIndex));
//        System.out.println("Month = " + birthDate.substring(3, 5));
//
//        String newDate = String.join("/", "25", "11", "1982");
//        System.out.println("newDate = " + newDate);
//
//        System.out.println(newDate.replace("25", "aqui"));

        String helloWorld = "Hello" + " World";
        helloWorld.concat(" and goodbye");

        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
        helloWorldBuilder.append(" and Goodbye");

        printInformation(helloWorldBuilder);
        printInformation(helloWorld);

        StringBuilder emptyStart = new StringBuilder();
        StringBuilder emptyStart32 = new StringBuilder(32);

        printInformation(emptyStart);
        printInformation(emptyStart32);
    }

    public static void printInformation(String string) {

        System.out.println("String = " + string);
        System.out.println("Length = " + string.length());
    }

    public static void printInformation(StringBuilder builder) {
        System.out.println("StringBuilder = " + builder);
        System.out.println("Length = " + builder.length());
        System.out.println("capacity = " + builder.capacity());
    }
}
