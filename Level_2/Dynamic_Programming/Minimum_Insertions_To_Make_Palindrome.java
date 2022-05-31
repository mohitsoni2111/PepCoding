package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Minimum_Insertions_To_Make_Palindrome {
    public static int solution(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int g = 0; g < dp.length; g++){
            for (int i = 0, j = g; j < dp[0].length; i++, j++){
                boolean startEnd = str.charAt(i) == str.charAt(j);
                if (g == 0){
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = startEnd ? 2 : 1;
                } else {
                    if (startEnd){
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
        }
        return str.length() - dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
