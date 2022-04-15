package Dynamic_Programming;

import java.util.Scanner;

public class Buy_And_Sell_Stocks_Infinite_Transaction_Allowed {

    private static long bassITA(int[] prices){
        int buyingDate = 0;
        int sellingDate = 0;
        int profit = 0;

        for (int i = 1; i < prices.length; i++){
            if (prices[i] >= prices[i - 1]){
                sellingDate++;
            }
            else {
                profit += prices[sellingDate] - prices[buyingDate];
                buyingDate = sellingDate = i;
            }
        }
        profit += prices[sellingDate] - prices[buyingDate];
        return profit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        long ans = bassITA(prices);
        System.out.println(ans);
    }
}
