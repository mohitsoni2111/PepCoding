package Arrays;

public class Zigzag_Traversal {

    static int[] zigzagTraversal(int matrix[][]){
        if(matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;

        int[] arr = new int[m*n];
        int i = 0;
        int row = 0, col = 0;
        boolean up = true;

        while (row < m && col < n){

            // If diagonal is going up
            if(up){
                while (row > 0 && col < n-1){
                    arr[i++] = matrix[row][col];
                    row--;
                    col++;
                }
                arr[i++] = matrix[row][col];
                if(col == n - 1){
                    row++;
                }
                else {
                    col++;
                }
            }

            // If diagonal is going down
            else {
                while (col > 0 && row < m - 1){
                    arr[i++] = matrix[row][col];
                    row++;
                    col--;
                }
                arr[i++] = matrix[row][col];
                if(row == n - 1){
                    col++;
                }
                else {
                    row++;
                }
            }
            up = !up;
        }
        return arr;
    }

    // Driver code
    public static void main(String[] args){
        int M[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
                { 17, 18, 19, 20 },
        };
        zigzagTraversal(M);
    }
}
