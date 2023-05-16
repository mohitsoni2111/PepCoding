package Dynamic_Programming;

import java.util.Scanner;

public class Buy_And_Sell_Stocks_With_Transaction_Fees_Infinite_Transaction_Allowed {
    private static long bassWTFITA(int[] prices, int fee){
        int oldBuyStateProfit = -prices[0];
        int oldSellStateProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int newBuyStateProfit = 0;
            int newSellStateProfit = 0;

            newBuyStateProfit = Math.max(oldSellStateProfit - prices[i], oldBuyStateProfit);
            newSellStateProfit = Math.max(oldBuyStateProfit + prices[i] - fee, oldSellStateProfit);

            oldBuyStateProfit = newBuyStateProfit;
            oldSellStateProfit = newSellStateProfit;
        }
        return oldSellStateProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();
        int fee = sc.nextInt();

        long ans = bassWTFITA(prices, fee);
        System.out.println(ans);
    }
}
