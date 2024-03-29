package LeetCode.DP;

import java.util.Arrays;
import java.util.Scanner;

public class Painting_the_Walls_2742 {
    static int[][] memo;
    static int n;
    public static int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        memo = new int[n][n + 1];
        return dp(0, n, cost, time);
    }

    public static int dp(int i, int remain, int[] cost, int[] time) {
        if (remain <= 0) {
            return 0;
        }

        if (i == n) {
            return (int) 1e9;
        }

        if (memo[i][remain] != 0) {
            return memo[i][remain];
        }

        int paint = cost[i] + dp(i + 1, remain - 1 - time[i], cost, time);
        int dontPaint = dp(i + 1, remain, cost, time);
        memo[i][remain] = Math.min(paint, dontPaint);
        return memo[i][remain];
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] cost = {1,2,3,2};
        int[] time = {1,2,3,2};
        int result = paintWalls(cost, time);
        System.out.println(result);
    }
}
