package Dynamic_Programming;

import java.util.Scanner;

public class Buy_And_Sell_Stock_With_Cooldown_Infinite_Transaction_Allowed {

    private static long bassWCITA(int[] prices){
        int oldBuyStateProfit = -prices[0];
        int oldSellStateProfit = 0;
        int oldCooldownStateProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int newBuyStateProfit = 0;
            int newSellStateProfit = 0;
            int newCooldownStateProfit = 0;

            newBuyStateProfit = Math.max(oldCooldownStateProfit - prices[i], oldBuyStateProfit);
            newSellStateProfit = Math.max(oldBuyStateProfit + prices[i], oldSellStateProfit);
            newCooldownStateProfit = Math.max(oldSellStateProfit, oldCooldownStateProfit);

            oldBuyStateProfit = newBuyStateProfit;
            oldSellStateProfit = newSellStateProfit;
            oldCooldownStateProfit = newCooldownStateProfit;
        }
        return oldSellStateProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        long ans = bassWCITA(prices);
        System.out.println(ans);
    }
}
