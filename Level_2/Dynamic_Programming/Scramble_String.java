package Level_2.Dynamic_Programming;
import java.util.Scanner;

public class Scramble_String {
    public static boolean isScrambleRecursion(String s1, String s2) {
        if (s1.equals(s2)){
            return true;
        }

        for (int i = 1; i < s1.length(); i++){
            if ((isScrambleRecursion(s1.substring(0, i), s2.substring(0, i)) &&
                    isScrambleRecursion(s1.substring(i), s2.substring(i)))
                    ||
                (isScrambleRecursion(s1.substring(0, i), s2.substring(s2.length() - i)) &&
                        isScrambleRecursion(s1.substring(i), s2.substring(0, s2.length() - i)))){
                    return true;
            }
        }
        return false;
    }
    private static boolean isScramble2(String s1, String s2, int si1, int ei1, int si2, int ei2) {
        if (s1.substring(si1, ei1 + 1).equals(s2.substring(si2, ei2 + 1))){
            return true;
        }

        for (int i = 0; i < ei1 - si1; i++){
            if ((isScramble2(s1, s2, si1, si1 + i, si2, si2 + i) &&
                    isScramble2(s1, s2, si1 + i + 1, ei1, si2 + i + 1, ei2))
                    ||
                    (isScramble2(s1, s2, si1, si1 + i, ei2 - i, ei2) &&
                            isScramble2(s1, s2, si1 + i + 1, ei1, si2, ei2 - i - 1))){
                return true;
            }
        }
        return false;
    }
    private static boolean isScrambleMemoization(String s1, String s2, int si1, int si2, int len, Boolean[][][] dp) {
        if (s1.substring(si1, si1 + len).equals(s2.substring(si2, si2 + len))){
            return true;
        }

        if (dp[si1][si2][len] != null){
            return dp[si1][si2][len];
        }

        for (int k = 1; k < len; k++){
            if ((isScrambleMemoization(s1, s2, si1, si2, k, dp) &&
                    isScrambleMemoization(s1, s2, si1 + k, si2 + k, len - k, dp))
                    ||
                    (isScrambleMemoization(s1, s2, si1, si2 + len - k, k, dp) &&
                            isScrambleMemoization(s1, s2, si1 + k, si2, len - k, dp))){
                dp[si1][si2][len] = true;
                return true;
            }
        }
        dp[si1][si2][len] = false;
        return false;
    }
    private static boolean isScrambleTab(String s1, String s2) {
        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];

        for (int len = 1; len <= n; len++){
            for (int i = 0; i <= n - len; i++){
                for (int j = 0; j <= n - len; j++){
                    if (len == 1){
                        dp[i][j][len] = (s1.charAt(i) == s2.charAt(j));
                    }
                    else {
                        for (int k = 1; k < len && !dp[i][j][len]; k++){
                            dp[i][j][len] = (dp[i][j][k] && dp[i + k][j + k][len - k]) ||
                                    (dp[i][j + len - k][k] && dp[i + k][j][len - k]);
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        int n = s1.length();
//        System.out.println(isScrambleTab2(s1,s2, 0, s1.length() - 1, 0, s2.length() - 1));
//        System.out.println(isScrambleTabMemoization(s1,s2, 0, 0, n, new Boolean[n][n][n + 1]));
        System.out.println(isScrambleTab(s1, s2));
    }
}
