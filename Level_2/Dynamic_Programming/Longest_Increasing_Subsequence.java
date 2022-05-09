package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Longest_Increasing_Subsequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int overallMax = 0;
        int[] dp = new int[n];

        for (int i = 0; i < dp.length; i++){
            int max = 0;
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            overallMax = Math.max(overallMax, dp[i]);
        }

        System.out.println(overallMax);
    }
}
