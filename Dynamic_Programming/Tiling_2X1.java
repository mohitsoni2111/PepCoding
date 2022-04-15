package Dynamic_Programming;

import java.util.Scanner;

public class Tiling_2X1 {

    private static int tiling2X1(int n) {
        if (n <= 0) return -1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = tiling2X1(n);
        System.out.println(ans);
    }
}
