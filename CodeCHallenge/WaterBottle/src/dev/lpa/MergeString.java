package dev.lpa;

public class MergeString {
    public static void main(String[] args) {

        System.out.println(mergeAlternately("ab","pqrs"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int size = Math.max(word1.length(), word2.length());

        var array1 = word1.toCharArray();
        var array2 = word2.toCharArray();



        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {

            try {
                sb.append(array1[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                sb.append(" ");
            }

            try {
                sb.append(array2[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                sb.append(" ");
            }


        }




        return sb.toString();
    }
}
