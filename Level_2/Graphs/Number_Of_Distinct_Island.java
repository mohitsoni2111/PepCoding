package Level_2.Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Number_Of_Distinct_Island {
    public static void dfs(int[][] arr, int i, int j, StringBuilder sb, String dir){
        if(i<0 || i==arr.length || j<0 || j==arr[0].length || arr[i][j]==0) return;

        sb.append(dir);
        arr[i][j] = 0;
        dfs(arr, i-1, j, sb, "u");
        dfs(arr, i+1, j, sb, "d");
        dfs(arr, i, j-1, sb, "l");
        dfs(arr, i, j+1, sb, "r");
        sb.append("b"); // back
    }

    public static int numDistinctIslands(int[][] arr) {
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==1){
                    StringBuilder psf = new StringBuilder();
                    dfs(arr, i, j, psf, "o");

                    set.add(psf.toString());
                }
            }
        }
        return set.size();
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

        System.out.println(numDistinctIslands(arr));

    }
}
