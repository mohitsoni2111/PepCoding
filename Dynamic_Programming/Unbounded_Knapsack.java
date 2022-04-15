package Dynamic_Programming;

import java.util.Scanner;

public class Unbounded_Knapsack {

    private static int unboundedKnapsack(int[] weights, int[] values, int target) {
        if (weights.length == 0 || values.length == 0 || target <= 0) return -1;

        int n = weights.length;
        int[] dp = new int[target + 1];
        dp[0] = 0;

        for (int bagC = 1; bagC < dp.length; bagC++){
            int max = 0;
            for (int i = 0; i < n; i++){
                if (weights[i] <= bagC){
                    int remBagC = bagC - weights[i];
                    int remBagV = dp[remBagC];
                    int totBagV = remBagV + values[i];

                    max = Math.max(max, totBagV);
                }
            }
            dp[bagC] = max;
        }
        return dp[target];
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

        int ans = unboundedKnapsack(weights, values, target);
        System.out.println(ans);
    }
}
