package Level_2.Arrays;

public class Max_Area_of_Island {
    int[] di = {-1, 0, 1, 0};
    int[] dj = {0, -1, 0, 1};
    private int findAreaOfIsland(int[][] grid, boolean[][] visited, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;

        if (i >= n || j >= m || i < 0 || j < 0) return 0;
        if (grid[i][j] == 0 || visited[i][j]) return 0;
        int nextAns = 0;
        visited[i][j] = true;
        for (int d = 0; d < 4; d++){
            nextAns += findAreaOfIsland(grid, visited, i + di[d], j + dj[d]);
        }
        return nextAns + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    ans = Math.max(ans, findAreaOfIsland(grid, visited, i , j));
                }
            }
        }
        return ans;
    }
}
