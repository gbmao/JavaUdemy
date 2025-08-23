public class DigitSumChallenge {
    public static void main(String[] args){
        System.out.println(sumDigits(5));
    }
    public static int sumDigits(int number){
        if(number < 0 ) return -1;
//        if(number / 10 == 0) return number;

        int sum = 0;

//        return number;

        while(number / 10 != 0){
             sum += number % 10;
            number = number / 10;
//            if(number / 10 == 0) sum += number;
        }
        sum += number;
        return sum;
    }
}
