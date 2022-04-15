package Dynamic_Programming;

import java.util.Scanner;

public class Coin_Change_Combination {

    private static int coinChangeCombination(int[] arr, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < arr.length; i++){
            for (int j = arr[i]; j < dp.length; j++){
                dp[j] += dp[j - arr[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int amount = sc.nextInt();
        int ans = coinChangeCombination(arr, amount);
        System.out.println(ans);
    }
}
