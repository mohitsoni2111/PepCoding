package Dynamic_Programming;

import java.util.Scanner;

public class Partition_Into_Subsets {

    private static long partition(int n, int k){
        if (n == 0 || k == 0 || n < k) return -1;

        long[][] dp = new long[k+1][n+1];

        for (int t = 1; t <= k; t++){           // t = team, p = people
            for (int p = 1; p <= n; p++){
                if (p < t){
                    dp[t][p] = 0;
                }
                else if (p == t){
                    dp[t][p] = 1;
                }
                else {
                    dp[t][p] = dp[t - 1][p - 1] + dp[t][p - 1] * t;
                }
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long ans = partition(n, k);
        System.out.println(ans);
    }
}
