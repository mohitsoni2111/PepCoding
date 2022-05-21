package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Minimum_Palindromic_Cut {
    public static int minPalindromicCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int g = 0; g < s.length(); g++){
            for (int i = 0, j = g; j < dp.length; i++, j++){
                boolean startEnd = s.charAt(i) == s.charAt(j);
                if (g == 0){
                    dp[i][j] = true;
                }
                else if (g == 1){
                    dp[i][j] = startEnd;
                }
                else {
                    dp[i][j] = startEnd && dp[i + 1][j - 1];
                }
            }
        }

        int[] storage = new int[s.length()];
        storage[0] = 0;

        for (int j = 1; j < storage.length; j++){
            if (dp[0][j]){
                storage[j] = 0;
            }
            else {
                int min = Integer.MAX_VALUE;
                for (int i = j; i >= 1; i--) {
                    if (dp[i][j]) {
                        min = Math.min(storage[i - 1], min);
                    }
                }
                storage[j] = min + 1;
            }
        }
        return storage[storage.length - 1];
    }

    // O(n^3)
    public static int minPalindromicCut2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int g = 0; g < s.length(); g++){
            for (int i = 0, j = g; j < dp.length; i++, j++){
                boolean startEnd = s.charAt(i) == s.charAt(j);
                if (g == 0){
                    dp[i][j] = true;
                }
                else if (g == 1){
                    dp[i][j] = startEnd;
                }
                else {
                    dp[i][j] = startEnd && dp[i + 1][j - 1];
                }
            }
        }

        int[][] storage = new int[s.length()][s.length()];
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                boolean startEnd = s.charAt(i) == s.charAt(j);
                if (g == 0){
                    storage[i][j] = 0;
                }
                else if (g == 1){
                    if (startEnd){
                        storage[i][j] = 0;
                    }
                    else {
                        storage[i][j] = 1;
                    }
                }
                else {
                    if (dp[i][j]){
                        storage[i][j] = 0;
                    }
                    else {
                        int min = Integer.MAX_VALUE;
                        for (int k = i; k < j; k++){
                            int left = storage[i][k];
                            int right = storage[k + 1][j];
                            min = Math.min(left + right + 1, min);
                        }
                        storage[i][j] = min;
                    }
                }
            }
        }
        return storage[0][s.length() - 1];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(minPalindromicCut(str));
    }
}
