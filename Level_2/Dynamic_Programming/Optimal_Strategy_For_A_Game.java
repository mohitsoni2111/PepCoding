package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Optimal_Strategy_For_A_Game {
    public static void optimalStrategy(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];

        for (int g = 0; g < dp.length; g++){
            for (int i = 0, j = g; j < dp[0].length; i++, j++){
                if (g == 0){
                    dp[i][j] = arr[i];
                }
                else if (g == 1){
                    dp[i][j] = Math.max(arr[i], arr[j]);
                }
                else {
                    int val1 = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
                    int val2 = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                    dp[i][j] = Math.max(val1, val2);
                }
            }
        }
        System.out.println(dp[0][dp.length - 1]);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scn.nextInt();
        }
        optimalStrategy(a);
    }
}
