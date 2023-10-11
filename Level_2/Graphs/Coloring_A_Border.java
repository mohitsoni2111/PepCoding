package Level_2.Graphs;

import java.io.IOException;

public class Coloring_A_Border {
    private void dfs(int[][] grid, int i, int j, int color, boolean[][] visited, int target, int n, int m) {
        if (i > n-1 || i < 0 || j > m-1 || j < 0 || grid[i][j] != color || visited[i][j])
            return;

        visited[i][j] = true;
        boolean border = false;

        if (i == 0 || j == 0 || i == n-1 || j == m-1 ||
                grid[i+1][j] != color ||
                grid[i-1][j] != color ||
                grid[i][j-1] != color ||
                grid[i][j+1] != color){
            border = true;
        }
        dfs(grid, i+1, j, color, visited, target, n, m);
        dfs(grid, i-1, j, color, visited, target, n, m);
        dfs(grid, i, j+1, color, visited, target, n, m);
        dfs(grid, i, j-1, color, visited, target, n, m);

        if (border){
            grid[i][j] = target;
        }
    }

    public int[][] colorBorder(int[][] grid, int i, int j, int color) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        dfs(grid, i, j, grid[i][j], visited, color, n, m);

        return grid;
    }


}

