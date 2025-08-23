public class Sum3And5Challenge {

    public static void main(String[] args){

        int sum = 0 ;
        int totalNumber = 0;

        for (int i = 1 ;totalNumber  < 5 && i <= 1000; i++) {
            if(i % 3 == 0 && i % 5 == 0){
                sum += i;
                System.out.println(i);
                totalNumber ++;
            }

        }
        System.out.println("Total sum is : " + sum);
    }
}
