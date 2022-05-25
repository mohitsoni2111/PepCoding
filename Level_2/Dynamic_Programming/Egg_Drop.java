package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Egg_Drop {
    public static int eggDrop(int n, int k){
        int [][] dp = new int[n + 1][k + 1];

        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                if (i == 1){
                    dp[i][j] = j;
                }
                else if (j == 1){
                    dp[i][j] = 1;
                }
                else {
                    int min = Integer.MAX_VALUE;
                    for (int x = j - 1, y = 0; x >= 0; x--, y++){
                        int val1 = dp[i][x];            // egg survives
                        int val2 = dp[i - 1][y];        // egg breaks
                        int val = Math.max(val1, val2);
                        min = Math.min(min, val);
                    }
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[n][k];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //n -> number of eggs and k -> number of floors
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(eggDrop(n,k));
    }
}
