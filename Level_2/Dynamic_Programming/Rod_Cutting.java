package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Rod_Cutting {
    public static int solution(int[] prices) {
        int[] newPrices = new int[prices.length + 1];
        for (int i = 0; i < prices.length; i++){
            newPrices[i + 1] = prices[i];
        }

        int[] dp = new int[newPrices.length];
        dp[0] = 0;
        dp[1] = newPrices[1];

        for (int i = 2; i < dp.length; i++){
            dp[i] = newPrices[i];

            int leftIndex = 1;
            int rightIndex = i - 1;
            while (leftIndex <= rightIndex){
                dp[i] = Math.max(dp[leftIndex] + dp[rightIndex], dp[i]);
                leftIndex++;
                rightIndex--;
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(solution(prices));
    }
}
