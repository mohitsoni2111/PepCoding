package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Wildcard_Pattern_Matching {
    public static boolean solution(String str, String pattern) {
        int m = pattern.length();
        int n = str.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;

        for (int j = n - 1; j >= 0; j--){
            for (int i = m - 1; i >= 0; i--){
                
            }
        }



        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1,s2));
    }
}
