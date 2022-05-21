package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Minimum_Score_Of_Triangulation {
    public static int minScoreTriangulation(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];

        for (int g = 0; g < dp.length; g++){

            for (int i = 0, j = g; j < dp.length; i++, j++){
                if (g == 0 || g == 1){
                    dp[i][j] = 0;
                }
                else if (g == 2){
                    dp[i][j] = arr[i] * arr[i + 1] * arr[i + 2];
                }
                else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++){
                        int iTriangle = arr[i] * arr[j] * arr[k];
                        int left = dp[i][k];
                        int right = dp[k][j];
                        int total = iTriangle + left + right;
                        min = Math.min(min, total);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][dp[0].length - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(minScoreTriangulation(arr));
    }
}
