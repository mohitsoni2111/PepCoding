// https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
package Arrays;

public class Spiral_Traversal {
    /*
Input:  1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
Explanation: The output is matrix in spiral format.

Input:  1   2   3   4  5   6
        7   8   9  10  11  12
        13  14  15 16  17  18
Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
Explanation :The output is matrix in spiral format.
     */

    //
    public static void spiralTraversal(int[][] arr) {
        int rowStart = 0;
        int rowEnd = arr.length;
        int colStart = 0;
        int colEnd = arr[0].length;
        int i;

        while ( rowStart < rowEnd && colStart < colEnd){
            // Print first row from remaining rows
            for (i = colStart; i < colEnd; i++)
                System.out.print(arr[rowStart][i]);
            rowStart++;

            // Print last column of remaining elements
            for (i = rowStart; i < rowEnd; i++)
                System.out.print(arr[i][colEnd - 1]);
            colEnd--;

            // Print last row from remaining elements
            if (rowStart < rowEnd){
                for (i = colEnd - 1; i >= colStart; i--)
                    System.out.print(arr[rowEnd][i]);
                rowEnd--;
            }

            // Print the first column from the remaining columns
            if (colStart < colEnd){
                for (i = rowEnd - 1; i >= rowStart; i--)
                    System.out.print(arr[i][colStart]);
                colStart++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 5, 9 },
                { 2, 6, 10 },
                { 3, 7, 11 },
                { 4, 8, 12 } };

        spiralTraversal(arr);
    }
}
