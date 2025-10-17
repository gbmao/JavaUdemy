public class RightMostDigit {
    public static void main(String[] args) {

        hasSameLastDigit(10, 11, 81);

    }
    public static boolean hasSameLastDigit(int a, int b, int c){

        //check for range
        // if((a < 10 || a > 1000) || (b < 10 || b > 1000) || (c < 10 || c > 1000) ) return false;
        if(!isValid(a)) return false;
        if(isValid(b)) return false;
        if(isValid(c)) return false;


        int rightmostA = a % 10;
        int rightmostB = b % 10;
        int rightmostC = c % 10;

        return (rightmostA == rightmostB) || (rightmostA == rightmostC) || ( rightmostB == rightmostC);

    }

    public static boolean isValid(int num){

        return (num >= 10 && num <= 1000);
    }
}
