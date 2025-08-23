public class LeetCode {

    public static void main(String[] args){
        int[] numbers = {1, 1, 2};
        removeDuplicates(numbers);

        String name = "Oi";



    }
    public static int removeDuplicates(int[] nums) {

        int[] numbers = new int[nums.length];
        numbers[0] = nums[0];
        int count = 0;
        int lastNumber = nums[0];
        //iterate
        for(int i = 1; i < nums.length; i++){
            // check if equal if not, insetr ina new array?

            if(nums[i] != lastNumber){
                count++;
                numbers[count] = nums[i];
                lastNumber = nums[i];
            }

        }

        for(int i = 0 ; i < nums.length; i++){

            nums[i] = numbers[i];
        }

        return count;
        //
    }
}
