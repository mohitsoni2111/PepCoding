package Level_2.Arrays;

public class Transpose_Matrix {
    public static int[][] transpose(int[][] matrix) {
        int[][] transposedArray = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix[0].length; i++){
            for (int j = 0; j < matrix.length; j++){
                transposedArray[i][j] = matrix[j][i];
            }
        }
        return transposedArray;
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] transposed = transpose(matrix);
        for (int[] ints : transposed) {
            for (int j = 0; j < transposed[0].length; j++) {
                System.out.println(ints[j]);
            }
            System.out.println();
        }
    }
}
