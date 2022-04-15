package Dynamic_Programming;

import java.util.Scanner;

public class Buy_And_Sell_Stock_Two_Transaction_Allowed {

    private static long bassTTA(int[] prices){
        // Left -> Right Traversal
        int profitIfSoldToday = 0;
        int leastSoFar = prices[0];
        int[] dpL = new int[prices.length]; //dpMaxProfitIfSoldUpToday

        for (int i = 1; i < prices.length; i++){
            leastSoFar = Math.min(leastSoFar, prices[i]);
            profitIfSoldToday = prices[i] - leastSoFar;
            dpL[i] = Math.max(profitIfSoldToday, dpL[i - 1]);
        }

        // Right -> Left Traversal
        int profitIfBoughtToday = 0;
        int maxAfterToday = prices[prices.length - 1];
        int[] dpR = new int[prices.length];    // dpMaxProfitOnTheRight

        for (int i = prices.length - 2; i >= 0; i--){
            maxAfterToday = Math.max(maxAfterToday, prices[i]);
            profitIfBoughtToday = maxAfterToday - prices[i];
            dpR[i] = Math.max(profitIfBoughtToday, dpR[i + 1]);
        }

        int overallProfit = 0;
        for (int i = 0; i < prices.length; i++){
            overallProfit = Math.max(dpL[i] + dpR[i], overallProfit);
        }
        return overallProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        long ans = bassTTA(prices);
        System.out.println(ans);
    }
}
