package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Longest_Repeating_Subsequence {
    public static int solution(String str){
        int[][] dp = new int[str.length() + 1][str.length() + 1];
        for (int i = dp.length - 2; i >= 0; i--){
            for (int j = dp[0].length - 2; j >= 0; j--){
                char c1 = str.charAt(i);
                char c2 = str.charAt(j);

                if (c1 == c2 && i != j){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
