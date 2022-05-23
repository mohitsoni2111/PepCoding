package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Count_Palindromic_Substrings {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();


        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int g = 0; g < n; g++){
            for (int i = 0, j = g; j < n; i++, j++){
                boolean startEnd = str.charAt(i) == str.charAt(j);
                if (g == 0){
                    dp[i][j] = true;
                }
                else if (g == 1) {
                    dp[i][j] = startEnd;
                }
                else {
                    dp[i][j] = startEnd && dp[i + 1][j - 1];
                }
                if (dp[i][j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
