public class LargestPrime {

    public static void main(String[] args){



    }

    public static int getLargestPrime(int number){
        if(number <= 1 ) return -1;

        int largestPrime = 0;

        for (int i = 1; i < number; i++){

            if(number % i == 0){

                largestPrime = i;

            }
        }
        return largestPrime;
    }
}
