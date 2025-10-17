public class Ispalindrome {
    public static void main(String[] args) {
        isPalindrome(33);
    }
    public static boolean isPalindrome(int number){

        int lastDigit = 0;
        int initNumber = number;
        if(number / 10 == 0) return true;

        while((number  / 10) > 0){

            lastDigit = (lastDigit * 10) + number % 10;
            number = number / 10;
        }
        lastDigit = (lastDigit * 10) + number % 10;


        return lastDigit == initNumber;

    }
}
