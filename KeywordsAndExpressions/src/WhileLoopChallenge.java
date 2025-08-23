public class WhileLoopChallenge {

    public static void main(String[] args){

        int i = 5;
        int totalEven = 0;
        int totalOdd = 0;
        while(totalEven < 5){
            if (isEvenNumber(i)){
                System.out.println(i + " is an even number");
                totalEven++;
            }else {
                totalOdd++;
            }
            i++;
        }
        System.out.println("Total even number is : " + totalEven);
        System.out.println("Total odd number is : " + totalOdd);
    }

    public static boolean isEvenNumber(int number){

        return (number % 2 == 0) && (number >= 0);
    }
}
