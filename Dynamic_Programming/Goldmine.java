package Dynamic_Programming;
import java.util.Scanner;

public class Goldmine {

    private static int goldmine(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int j = n - 1; j >= 0; j--){
            for (int i = m - 1; i >= 0; i--){
                if (j == n - 1){
                    dp[i][j] = grid[i][j];
                }
                else if (i == 0){
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                }
                else if (i == m - 1){
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                }
                else {
                    dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j + 1], Math.max(dp[i][j + 1], dp[i + 1][j + 1]));
                }
            }
        }
        int max = dp[0][0];
        for (int i = 1; i < m; i++){
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int ans = goldmine(grid);
        System.out.println(ans);
    }
}
