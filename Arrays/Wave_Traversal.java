package Arrays;

public class Wave_Traversal {

    public static void waveTraversal(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < col; i++){
            if (i % 2 == 0){
                for (int j = 0; j < row; j++)
                    System.out.print(arr[j][i] + " ");
            }
            else {
                for (int j = row - 1; j >= 0; j--)
                    System.out.print(arr[j][i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 5, 9 },
                        { 2, 6, 10 },
                        { 3, 7, 11 },
                        { 4, 8, 12 } };

        waveTraversal(arr);
    }
}
