package LeetCode.DP;
import java.util.Arrays;

public class Coin_Change_322 {
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args){
        int[] coins = new int[]{2,5,10,1};
        int amount = 27;
        int res = coinChange(coins, amount);
        System.out.println(res);
    }
}
