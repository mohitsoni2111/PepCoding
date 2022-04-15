package Arrays;

public class Reverse_wave_Traversal {

    public static void reverseWaveTraversal(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        for (int i = col - 1; i >= 0; i--){
            if (i % 2 != 0){
                for (int j = row - 1; j >= 0; j--)
                    System.out.print(arr[j][i] + " ");
            }
            else {
                for (int j = 0; j < row; j++)
                    System.out.print(arr[j][i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 5, 9 },
                        { 2, 6, 10 },
                        { 3, 7, 11 },
                        { 4, 8, 12 } };

        reverseWaveTraversal(arr);
    }
}
