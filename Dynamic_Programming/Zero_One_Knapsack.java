package Dynamic_Programming;
import java.util.Scanner;

public class Zero_One_Knapsack {

    private static int zeroOneKnapsack(int[] weights, int[] values, int target) {
        if (weights.length == 0 || values.length == 0 || target <= 0) return -1;

        int n = weights.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                if (j >= weights[i - 1]){
                    int remW = j - weights[i - 1];
                    dp[i][j] = Math.max(dp[i - 1][remW] + values[i - 1], dp[i - 1][j]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++)
            weights[i] = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++)
            values[i] = sc.nextInt();
        int target = sc.nextInt();

        int ans = zeroOneKnapsack(weights, values, target);
        System.out.println(ans);
    }
}
