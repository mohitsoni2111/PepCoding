package Level_2.Arrays;

public class Rotate_Image {

    public static void transpose(int[][] matrix, int n){
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        transpose(matrix, n);

        for (int i = 0; i < n; i++){
            int l = 0, r = n - 1;

            while (l < r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }

        return matrix;
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] rotated = rotate(matrix);
        for (int[] ints : rotated) {
            for (int j = 0; j < rotated[0].length; j++) {
                System.out.println(ints[j]);
            }
            System.out.println();
        }
    }
}
