package Dynamic_Programming;

import java.util.Scanner;

public class Coin_Change_Permutation {

    private static int coinChangePermutation(int[] coins, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i < target; i++){
            for (int coin : coins){
                if (i >= coin){
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();

        int target = sc.nextInt();
        int ans = coinChangePermutation(coins, target);
        System.out.println(ans);
    }
}
