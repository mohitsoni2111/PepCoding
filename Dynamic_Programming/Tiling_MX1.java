package Dynamic_Programming;

import java.util.Scanner;

public class Tiling_MX1 {

    private static int tilingMX1(int m, int n) {
        if (n <= 0 || m <= 0) return -1;

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++)
            if (i < m) {
                dp[i] = i;
            }
            else if (i == m){
                dp[i] = 2;
            }
            else {
                dp[i] = dp[i - 1]+ dp[i - m];
            }
        return dp[n];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int ans = tilingMX1(m, n);
        System.out.println(ans);
    }
}
