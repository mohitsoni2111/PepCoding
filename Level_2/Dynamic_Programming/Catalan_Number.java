package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Catalan_Number {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++){
            for (int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        System.out.println(dp[n]);

        /*
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            int left = 0;
            int right = i - 1;

            while(left <= i - 1){
                dp[i] += dp[left] * dp[right];
                left++;
                right--;
            }
        }
        System.out.println(dp[n]);
         */
    }
}
