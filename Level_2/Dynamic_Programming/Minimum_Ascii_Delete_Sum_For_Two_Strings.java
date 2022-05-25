package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Minimum_Ascii_Delete_Sum_For_Two_Strings {
    public static int solution(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = dp.length - 1; i >= 0; i--){
            for (int j = dp[0].length - 1; j >= 0; j--){
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                if (i == dp.length - 1 && j == dp[0].length - 1){
                    dp[i][j] = 0;
                }
                else if (i == dp.length - 1){
                    dp[i][j] = c2 + dp[i][j + 1];
                }
                else if (j == dp[0].length - 1){
                    dp[i][j] = c1 + dp[i + 1][j];
                }
                else {
                    if (c1 == c2){
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                    else {
                        dp[i][j] = Math.min(dp[i][j + 1] + c2, dp[i + 1][j] + c1);
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }
}
