package Dynamic_Programming;

import java.util.Scanner;

public class Buy_And_Sell_Stock_K_Transaction_Allowed {

    private static long bassKTA(int[] prices, int k){
        int n = prices.length;
        int[][] dp = new int[k + 1][n];

        for (int t = 1; t <= k; t++){
            int max = Integer.MIN_VALUE;
            for (int d = 1; d < n; d++){
                max = Math.max(dp[t - 1][d - 1] - prices[d - 1], max);
                dp[t][d] = Math.max(dp[t][d - 1], max + prices[d]);
            }
        }
        return dp[k][n - 1];
    }

    // O(n^3)
    private static long bassKTA2(int[] prices, int k){
        int n = prices.length;
        int[][] dp = new int[k + 1][n];

        for (int t = 1; t <= k; t++){
            for (int d = 1; d < n; d++){
                int max = dp[t][d - 1];

                for (int pd = 0; pd < d; pd++){
                    int ptilltm1 = dp[t - 1][pd];
                    int pth = prices[d] - prices[pd];
                    max = Math.max(ptilltm1 + pth, max);
                }
                dp[t][d] = max;
            }
        }
        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();
        int k = sc.nextInt();

        long ans = bassKTA(prices, k);
//        long ans = bassKTA2(prices, k);
        System.out.println(ans);
    }
}
