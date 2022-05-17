package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Maximum_Sum_Increasing_Subsequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        int overallMax = Integer.MIN_VALUE;
        int[] dp = new int[n];

        for (int i = 0; i < dp.length; i++){
            Integer max = null;
            for (int j = 0; j < i; j++){
                if (arr[i] >= arr[j]){
                    if (max == null){
                        max = dp[i]
                    }
                    else if (dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            if (max == null){
                dp[i] = arr[i];
            }
            else {
                dp[i] = max + arr[i];
            }

            if (dp[i] > overallMax){
                overallMax = dp[i];
            }
        }
        System.out.println(overallMax);
    }
}
