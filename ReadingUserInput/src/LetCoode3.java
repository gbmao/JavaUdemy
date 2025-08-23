public class LetCoode3 {
    public static void main(String[] args) {

        System.out.println(largestGoodInteger("3200014888"));

    }

    public static String largestGoodInteger(String num) {


        String result = "";
        String result2 = "";
        char[] myArray = num.toCharArray();
        int count = 0;
        for(int i = 1; i < myArray.length; i++){

            if(myArray[i] == myArray[i - 1]){

                count++;

                if(count == 2){

                     result = "" + myArray[i ] + myArray[i ] + myArray[i];

                     int resultado = result.compareTo(result2);

                     if(resultado > 0){

                         result2 = result;
                     }

                }

            }else {
                count = 0;
            }
//                    return  result;

        }
        return result2;




    }
}


class Solution {
    public String largestGoodInteger(String num) {
        String[] numbers={"999","888","777","666","555","444","333","222","111","000"};
        for(String i:numbers){
            if(num.contains(i)){
                return i;
            }
        }
        return "";

    }
}
