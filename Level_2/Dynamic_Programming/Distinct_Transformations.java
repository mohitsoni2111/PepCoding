package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Distinct_Transformations {
    public static int solutionRecursion(String s, String t, int si, int ti){
        if (ti == t.length()) {
            return 1;
        } else if (si == s.length()){
            return 0;
        }

        char c1 = s.charAt(si);
        char c2 = t.charAt(ti);

        int totalWays = 0;
        if (c1 != c2){
            totalWays = solutionRecursion(s, t, si + 1, ti);
        } else {
            int totalWays1 = solutionRecursion(s, t, si + 1, ti);
            int totalWays2 = solutionRecursion(s, t, si + 1, ti + 1);
            totalWays = totalWays1 + totalWays2;
        }

        return totalWays;
    }
    public static int solutionMemoization(String s, String t, int si, int ti, int [][] dp){
        if (ti == t.length()) {
            return 1;
        } else if (si == s.length()){
            return 0;
        }

        if (dp[si][si] != -1){
            return dp[si][ti];
        }

        char c1 = s.charAt(si);
        char c2 = t.charAt(ti);

        int totalWays = 0;
        if (c1 != c2){
            totalWays = solutionMemoization(s, t, si + 1, ti, dp);
        } else {
            int totalWays1 = solutionMemoization(s, t, si + 1, ti, dp);
            int totalWays2 = solutionMemoization(s, t, si + 1, ti + 1, dp);
            totalWays = totalWays1 + totalWays2;
        }

        dp[si][ti] = totalWays;
        return totalWays;
    }

    public static int solution(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];

        for (int i = dp.length - 1; i >= 0; i--){
            for (int  j = dp[0].length - 1; j >= 0; j--){
                if (i == dp.length - 1) {
                    dp[i][j] = 1;
                } else if (j == dp[0].length) {
                    dp[i][j] = 0;
                } else {
                    char c1 = t.charAt(i);
                    char c2 = s.charAt(j);

                    if (c1 != c2){
                        dp[i][j] = dp[i][j + 1];
                    } else {
                        dp[i][j] = dp[i][j + 1] + dp[i + 1][j + 1];
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

        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
//        System.out.println(solutionRecursion(s1, s2, 0, 0));
//        System.out.println(solutionMemoization(s1, s2, 0, 0, dp));
        System.out.println(solution(s1, s2));
    }
}
