package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Count_Palindromic_Subsequences {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();


        int n = str.length();
        int[][] dp = new int[n][n];

        for (int g = 0; g < n; g++){
            for (int i = 0, j = g; j < n; i++, j++){
                boolean startEnd = str.charAt(i) == str.charAt(j);
                if (g == 0){
                    dp[i][j] = 1;
                }
                else if (g == 1) {
                    dp[i][j] = startEnd ? 3 : 2;
                }
                else {
                    if (startEnd){
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                    }
                    else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }
}
