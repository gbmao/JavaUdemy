public class LeetCode2 {
    public static void main(String[] args) {

        System.out.println(strStr("mississippi", "issipi"));
    }

    public static int strStr(String haystack, String needle) {

        //i needle
        char[] needleArray = needle.toCharArray();
        char[] haystackArray = haystack.toCharArray();
        int ocurrence = 0;
        int count = 0;

        if(needleArray.length > haystackArray.length) return -1;


        for (int i = 0; i < haystackArray.length; i++) {

            if(haystackArray[i] == needleArray[0]){

                for (int j = i; j < haystackArray.length; j++) {

                    if(needleArray[count] == haystackArray[j]){

                        count++;
                        if(count == needleArray.length ) return i;
                    }else {

                        count = 0;
                        break;
                    }

                }
            }

        }



        return -1;

    }
}
