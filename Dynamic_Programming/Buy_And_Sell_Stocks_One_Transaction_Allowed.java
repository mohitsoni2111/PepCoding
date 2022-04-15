package Dynamic_Programming;

import java.util.Scanner;

public class Buy_And_Sell_Stocks_One_Transaction_Allowed {

    private static long bassOTA(int[] prices){
        int leastSoFar = Integer.MAX_VALUE;
        int overallProfit = 0;
        int profitIfSoldToday = 0;

        for (int price : prices) {
            leastSoFar = Math.min(leastSoFar, price);
            profitIfSoldToday = price - leastSoFar;
            overallProfit = Math.max(overallProfit, profitIfSoldToday);
        }
        return overallProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        long ans = bassOTA(prices);
        System.out.println(ans);
    }
}
