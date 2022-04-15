package Dynamic_Programming;

import java.util.Scanner;

public class Paint_House_2 {

    private static long paintHouse2(int[][] arr) {
        int n = arr.length;
        int[][] dp = new int[arr.length][arr[0].length];

        int least = Integer.MAX_VALUE;
        int sLeast = Integer.MAX_VALUE;
        for (int j = 0; j < dp[0].length; j++){
            dp[0][j] = arr[0][j];

            if (arr[0][j] <= least){
                sLeast = least;
                least = arr[0][j];
            }
            else if (arr[0][j] <= sLeast){
                sLeast = arr[0][j];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            int nLeast = Integer.MAX_VALUE;
            int nsLeast = Integer.MAX_VALUE;
            for (int j = 0; j < dp[0].length; j++) {
                if (least == dp[i - 1][j]) {
                    dp[i][j] = sLeast + arr[i][j];
                }
                else {
                    dp[i][j] = least + arr[i][j];
                }

                if (dp[i][j] <= nLeast){
                    nsLeast = nLeast;
                    nLeast = dp[i][j];
                }
                else if (dp[i][j] <= nsLeast){
                    nsLeast = dp[i][j];
                }
            }
            least = nLeast;
            sLeast = nsLeast;
        }
        return least;
    }

    private static long paintHouse3(int[][] arr) {
        int n = arr.length;
        int[][] dp = new int[arr.length][arr[0].length];

        for (int j = 0; j < dp[0].length; j++){
            dp[0][j] = arr[0][j];
        }
        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                int min = Integer.MAX_VALUE;

                for (int k = 0; k < dp[0].length; k++){
                    if(k != j){
                        min = Math.min(min, dp[i - 1][k]);
                    }
                }
                dp[i][j] = arr[i][j] + min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < dp[0].length; k++){
            min = Math.min(min, dp[n - 1][k]);
        }

        return min;
    }   // O(n^3)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[0].length; j++)
                arr[i][j] = sc.nextInt();

        long ans = paintHouse2(arr);
//        long ans = paintHouse3(arr);
        System.out.println(ans);
    }
}
