package Level_2.Dynamic_Programming;

import java.util.HashMap;
import java.util.Scanner;

public class Count_Of_Distinct_Palindromic_Subsequences {
    public static int solution(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        int[] prev = new int[n];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            prev[i] = map.getOrDefault(ch, -1);
            map.put(ch, i);
        }

        int[] next = new int[n];
        map.clear();
        for (int i = n - 1; i >= 0; i--){
            char ch = str.charAt(i);
            next[i] = map.getOrDefault(ch, -1);
            map.put(ch, i);
        }

        for (int g = 0; g < n; g++){
            for (int i = 0, j = g; j < n; i++, j++){
                if (g == 0){
                    dp[i][j] = 1;
                }
                else if (g == 1){
                    dp[i][j] = 2;
                }
                else {
                    char sc = str.charAt(i);
                    char ec = str.charAt(j);

                    if (sc != ec){
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }
                    else {
                        int nxt = next[i];
                        int pre = prev[j];

                        if (nxt > pre){
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                        }
                        else if (nxt == pre){
                            dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                        }
                        else {
                            dp[i][j] = 2 * dp[i + 1][j - 1] - dp[nxt + 1][pre - 1];
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }
}
