package Level_2.Graphs;

import java.io.IOException;

public class Coloring_A_Border {
    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public void dfs(int[][] grid, int row, int col, int color){
        grid[row][col] = -color;
        int count = 0;

        for (int i = 0; i < 4; i++){
            int newRow = row + dirs[i][0];
            int newCol = col + dirs[i][1];

            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || Math.abs(grid[newRow][newCol]) != color) {
                continue;
            }

            count++;

            if (grid[newRow][newCol] == color) {
                dfs(grid, newRow, newCol, color);
            }
        }
        if (count == 4) {
            grid[row][col] = color;
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {

        dfs(grid, row, col, grid[row][col]);

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] < 0){
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
}

