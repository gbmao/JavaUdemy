public class PrimeNumber {
    public static void main(String[] args) {
//        System.out.println("0 is " + (isPrime(0) ? "" : "NOT " ) + "a prime number");
            int primeCount = 0;

        for (int i = 653; i < 1000; i++) {
            if(primeCount >= 3) break;
            if(isPrime(i)){
                System.out.println(i + " is a prime number");
                primeCount++;
            }else{
                System.out.println(i + " Not a prime number");
            }
        }
    }

    public static boolean isPrime(int wholeNumber){
        if (wholeNumber <= 2){
            return (wholeNumber == 2);
        }

        for(int divisor = 2; divisor < wholeNumber; divisor++){
            if(wholeNumber % divisor == 0){
                return false;
            }
        }

        return true;
    }


}
