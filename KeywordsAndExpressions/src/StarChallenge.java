public class StarChallenge {
    public static void main(String[] args) {

        printSquareStar(5);
    }

    public static void printSquareStar(int number){
        if(number < 5){
            System.out.println("Invalid Value");
        }else{

            for(int row = 0; row < number; row++ ){

                for(int column = 0; column < number; column++ ){

                    //first or last row
                    if(row == 0 || row == number -1){

                        System.out.print("*");

                    }else

                        // first ir last column
                        if(column == 0 || column == number -1){
                            System.out.print("*");

                        }else
                            // when the row number == column number

                            if(row == column){
                                System.out.print("*");
                            }else

                            if(column == ((number - 2) - row + 1 ) ){
                                System.out.print("*");
                            }else{

                                System.out.print(" ");
                            }


                }
                System.out.println();
            }



        }



    }

}
