package Level_2.Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Rotting_Oranges {
    public static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }   // Row, Col
    public static int orangesRotting2(int[][] grid) {
        LinkedList<Pair> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 2){
                    queue.addLast(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int level = -1;
        while (queue.size() > 0){
            int size = queue.size();
            level++;
            while (size-- > 0){
                Pair rem = queue.removeFirst();

                for (int i = 0; i < dirs.length; i++){
                    int newRow = rem.row + dirs[i][0];
                    int newCol = rem.col + dirs[i][1];

                    if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] == 1){
                        queue.addLast(new Pair(newRow, newCol));
                        grid[newRow][newCol] = 0;
                        fresh--;
                    }
                }
            }
        }

        if (fresh == 0) {
            return level;
        } else {
            return -1;
        }
    }

    private static void dfs(int[][] grid, int i, int j, int minutes) {
        if (i<0 || i>= grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0 ||
                (grid[i][j] > 1 && grid[i][j] < minutes)) return;

        grid[i][j] = minutes;
        dfs(grid, i+1, j, minutes + 1);
        dfs(grid, i-1, j, minutes + 1);
        dfs(grid, i, j+1, minutes + 1);
        dfs(grid, i, j-1, minutes + 1);
    }
    public static int orangesRotting(int[][] grid){
        if (grid == null || grid.length == 0) return -1;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 2){
                    dfs(grid, i, j, 2);
                }
            }
        }

        int minutes = 2;
        for (int[] row : grid){
            for (int cell : row){
                if (cell == 1) {
                    return -1;
                }
                minutes = Math.max(minutes, cell);
            }
        }
        return minutes-2;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(orangesRotting(arr));

    }
}
