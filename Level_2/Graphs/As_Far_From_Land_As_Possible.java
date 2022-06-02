package Level_2.Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class As_Far_From_Land_As_Possible {
    public static class Pair{
        int row;
        int col;

        Pair (int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static int maxDistance(int[][] grid) {

        LinkedList<Pair> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    queue.addLast(new Pair(i, j));
                }
            }
        }

        if (queue.size() == 0 || queue.size() == grid.length * grid[0].length) {
            return -1;
        }

        int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int level = -1;
        while (queue.size() > 0){
            level++;

            int size = queue.size();
            while (size-- > 0){
                Pair rem = queue.removeFirst();

                for (int i = 0; i < dirs.length; i++){
                    int newRow = rem.row + dirs[i][0];
                    int newCol = rem.col + dirs[i][1];

                    if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] == 1){
                        continue;
                    }

                    queue.addLast(new Pair(newRow, newCol));
                    grid[newRow][newCol] = 1;
                }
            }
        }
        return level;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(maxDistance(arr));

    }
}
