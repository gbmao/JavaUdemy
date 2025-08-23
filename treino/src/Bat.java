public class Bat {

    public static String front22(String str) {

        if(str.length() < 2) return str + str.charAt(0) + str.charAt(0);
        char firstChar = str.charAt(0);
        char secondChar = str.charAt(1);


        return "" +firstChar + secondChar + str+ firstChar + secondChar;
    }

    public static boolean hasTeen(int a, int b, int c) {



        if(a >= 13 && 19 <= a) return true;
        if(b >= 13 && 19 >= b) return true;
        if(c >= 13 && 19 <= c) return true;
        return false;
    }


}
