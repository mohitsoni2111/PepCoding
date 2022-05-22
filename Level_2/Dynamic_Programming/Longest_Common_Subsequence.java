package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Longest_Common_Subsequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str1 = scn.nextLine();
        String str2 = scn.nextLine();

        int[][] dp = new int[str1.length()][str2.length()];
        for (int i = dp.length - 2; i >=0; i--){
            for (int j = dp[0].length - 2; j >= 0; j--){
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(j);

                if (c1 == c2){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
