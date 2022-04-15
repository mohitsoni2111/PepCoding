package Arrays;

// The no. which is min in row but max in col
public class Saddle_Point {
    private static boolean findSaddlePoint(int[][] arr) {
        if(arr.length==0 || arr[0].length==0) return false;

        for (int i = 0; i < arr.length; i++){
            int min = arr[i][0];
            int col_index = 0;

            for (int j = 1; j < arr[0].length; j++){
                if(arr[i][j] < min){
                    min = arr[i][j];
                    col_index = j;
                }
            }

            int k;
            for (k = 0; k < arr[0].length; k++){
                if (min < arr[k][col_index])
                    break;
            }

            if (k == arr[0].length)
                return true;
        }
        return false;
    }

    // Driver method
    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        if (findSaddlePoint(mat) == false)
            System.out.println("No Saddle Point ");
    }
}
