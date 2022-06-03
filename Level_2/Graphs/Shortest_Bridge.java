package Level_2.Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Shortest_Bridge {
    public static class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }   // Row, Col
    static int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    private static void dfs(int[][] A, int i, int j, LinkedList<Pair> queue, boolean[][] visited) {

        visited[i][j] = true;
        queue.addLast(new Pair(i, j));

        for (int k = 0; k < dirs.length; i++){
            int newRow = i + dirs[i][0];
            int newCol = j + dirs[i][1];

            if (newRow < 0 || newCol < 0 || newRow >= A.length || newCol >= A[0].length || A[newRow][newCol] == 0 || visited[newRow][newCol]){
                continue;
            }

            dfs(A, newRow, newCol, queue, visited);
        }
    }
    public static int shortestBridge(int[][] A) {

        LinkedList<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[A.length][A[0].length];
        boolean flag = false;

        for (int i = 0; i < A.length && !flag; i++){
            for (int j = 0; j < A[0].length && !flag; j++){
                if (A[i][j] == 1){
                    dfs(A, i, j, queue, visited);
                    flag = true;
                }
            }
        }

        int level = 0;
        while (queue.size() > 0){
            int size = queue.size();

            while (size-- > 0){
                Pair rem = queue.removeFirst();

                for (int i = 0; i < dirs.length; i++){
                    int newRow = rem.row + dirs[i][0];
                    int newCol = rem.col + dirs[i][1];

                    if (newRow < 0 || newCol < 0 || newRow >= A.length || newCol >= A[0].length || visited[newRow][newCol]){
                        continue;
                    }

                    if (A[newRow][newCol] == 1){
                        return level;
                    }

                    queue.addLast(new Pair(newRow, newCol));
                }
                level++;
            }
        }
        return -1;
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

        System.out.println(shortestBridge(arr));

    }
}
