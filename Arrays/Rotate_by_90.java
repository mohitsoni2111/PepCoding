package Arrays;

public class Rotate_by_90 {
    // Rotate square Matrix clockwise
    // Transpose -> reverse each row elements
    public static int[][] rotate90(int[][] matrix){
        if(matrix.length==0 || matrix[0].length==0 || matrix.length!=matrix[0].length) return new int[0][0];

        int m  = matrix.length;

        // Transpose
        for (int i = 0; i < m; i++){
            for (int j = i; j < m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reversing each row
        for (int i = 0; i < m; i++){
            int l = 0, r = m - 1;

            while (l <  r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        int arr[][] = { { 1, 5, 9 },
                        { 2, 6, 10 },
                        { 3, 7, 11 }};

        int[][] ans = rotate90(arr);

        for (int i = 0; i < ans.length; i++){
            for (int j = 0 ; j < ans[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
