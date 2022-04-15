package Dynamic_Programming;

import java.util.Scanner;

public class Target_Sum_Subset {

    private static boolean targetSumSubset(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = true;
                }
                else if (i == 0){
                    dp[i][j] = false;
                }
                else if (j == 0){
                    dp[i][j] = true;
                }
                else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                    else {
                        int val = arr[i - 1];
                        if (j >= val){
                            if (dp[i - 1][j - val]){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return dp[arr.length][target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int target = sc.nextInt();

        boolean ans = targetSumSubset(arr, target);
        System.out.println(ans);
    }
}


