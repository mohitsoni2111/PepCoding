package Dynamic_Programming;

import java.util.Scanner;

public class Minimum_Cost_Path {

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--){
            int min = dp[m - 1][n - 1];
            for (int j = n - 1; j >= 0; j--){
                if (i == m - 1 && j == n - 1){
                    dp[i][j] = grid[i][j];
                }
                else if (i == m - 1){
                    dp[i][j] = dp[i][j + 1] + grid[i][j];
                }
                else if (j == n - 1){
                    dp[i][j] = dp[i + 1][j] + grid[i][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int ans = minPathSum(grid);
        System.out.println(ans);
    }
}
