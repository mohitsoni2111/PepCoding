package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Optimal_Binary_Search_Tree {
    private static void optimalbst(int[] keys, int[] frequency, int n) {
        int[][] dp = new int[n][n];
        int[] prefixSumArray = new int[n];
        prefixSumArray[0] = frequency[0];
        for (int y = 1; y < frequency.length; y++){
            prefixSumArray[y] = prefixSumArray[y - 1] + frequency[y];
        }

        for (int g = 0; g < dp.length; g++){
            for (int i = 0, j = g; j < dp.length; i++, j++){
                if (g == 0){
                    dp[i][j] = frequency[i];
                }
                else if (g == 1){
                    int f1 = frequency[i];
                    int f2 = frequency[j];
                    dp[i][j] = Math.min(f1 + 2 * f2, f2 + 2 * f1);
                }
                else {
                    int min = Integer.MAX_VALUE;
                    int freqSum = prefixSumArray[j] - (i == 0 ? 0 : prefixSumArray[i - 1]);

                    for (int k = i; k <= j; k++){
                        int left = k == i ? 0 : dp[i][k - 1];
                        int right = k == j ? 0 :dp[k + 1][j];
                        int total = left + right + freqSum;
                        min = Math.min(min, total);
                    }
                    dp[i][j] = min;
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] keys = new int[n];
        int[] frequency = new int[n];
        for(int i= 0 ;i < n ; i++) {
            keys[i] = scn.nextInt();
        }
        for(int i = 0 ; i < n; i++){
            frequency[i] = scn.nextInt();
        }
        optimalbst(keys,frequency,n);
    }
}
