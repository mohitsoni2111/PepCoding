package Arrays;

public class Diagonal_Traversal {
    static int[] diagonalTraversal(int matrix[][]){
        if(matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;

        int[] upToDown = new int[m*n];
        int x = 0;

        // First Half
        for (int i = 0; i < n; ++i) {
            for (int j = i; j >= 0 && i - j < m; --j) {
                upToDown[x++] = matrix[i - j][j];
            }
        }
        // Second Half
        for (int i = 1; i < m; ++i) {
            for (int j = n - 1, k = i; j >= 0 && k < m; --j, k++) {
                upToDown[x++] = matrix[k][j];
            }
        }
        for (x = 0; x < upToDown.length; x++){
            System.out.print(upToDown[x] + " ");
        }
        return upToDown;
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

        // [1 5 2 9 6 3 13 10 7 4 17 14 11 8 18 15 12 19 16 20]
        diagonalTraversal(M);
    }
}
