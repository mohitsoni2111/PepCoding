package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Maximum_Length_Of_Repeated_Subarray {
    public static int solution(int[] arr1, int[] arr2) {
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                if (arr1[i - 1] == arr2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0 ; i < n; i++) {
            arr1[i] = scn.nextInt();
        }

        int m = scn.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0 ; i < m; i++) {
            arr2[i] = scn.nextInt();
        }
        System.out.println(solution(arr1, arr2));
    }
}
