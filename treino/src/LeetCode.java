public class LeetCode {
    public static int countSquares(int[][] matrix) {
       int totalCount = 0;
        int firstRow = 0;

       for ( int i = 0; i < matrix.length; i ++){

           for(int j = 0; j < matrix[i].length; j++){

               if(matrix[i][j] == 1){
                   firstRow++;
               }

               if(firstRow > 0 && j == matrix.length -1){
                   totalCount += firstRow;

               }

           }

       }


    }
}
