public class Leetcode {
    public static long zeroFilledSubarray(int[] nums) {

        long maxZero = 0;
        long result = 0;

        //1 for loop
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {


                maxZero++;
                result += maxZero;

//            }else if(maxZero > 0){
//
//                for (long j = 1 ; j <= maxZero; j++ ){
//                    if(j == 1) {
//                        result += maxZero;
//                    } else {
//                        result += maxZero - (j -1);
//                    }
//                }
//
//                maxZero = 0;
//
//            }
//            if(i == nums.length - 1 && maxZero> 0){
//                for (long j = 1 ; j <= maxZero; j++ ){
//                    if(j == 1) {
//                        result += maxZero;
//                    } else {
//                        result += maxZero - (j -1);
//                    }
//                }
//
//                maxZero = 0;
            } else {
                maxZero = 0;
            }
            }
            return result;
        }
    }
