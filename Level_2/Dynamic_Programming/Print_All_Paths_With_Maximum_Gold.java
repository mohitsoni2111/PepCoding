package Level_2.Dynamic_Programming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class Print_All_Paths_With_Maximum_Gold {
    private static class Pair {
        String psf;
        int i;
        int j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str.split(" ")[j]);
            }
        }

        int[][] dp = new int[m][n];

        for (int j = n - 1; j >= 0; j--) {
            for (int i = m - 1; i >= 0; i--) {
                if (j == n - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == 0) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if (i == m - 1) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j + 1], Math.max(dp[i][j + 1], dp[i + 1][j + 1]));
                }
            }
        }

        int max = dp[0][0];
        for (int i = 1; i < m; i++){
            max = Math.max(max, dp[i][0]);
        }
        System.out.println(max);

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (dp[i][0] == max) {
                queue.add(new Pair(i + " ", i, 0));
            }
        }

        while (queue.size() > 0){
            Pair rem = queue.removeFirst();

            if (rem.j == arr[0].length - 1){
                System.out.println(rem.psf);
            }
            else if (rem.i == 0){
                int great = Math.max(dp[rem.i][rem.j + 1], dp[rem.i + 1][rem.j + 1]);

                if (great == dp[rem.i][rem.j + 1]){
                    queue.add(new Pair(rem.psf + "d2 ", rem.i, rem.j + 1));
                }
                if (great == dp[rem.i + 1][rem.j + 1]){
                    queue.add(new Pair(rem.psf + "d3 ", rem.i + 1, rem.j + 1));
                }
            }
            else if (rem.i == arr.length - 1){
                int great = Math.max(dp[rem.i][rem.j + 1], dp[rem.i - 1][rem.j + 1]);

                if (great == dp[rem.i - 1][rem.j + 1]){
                    queue.add(new Pair(rem.psf + "d1 ", rem.i - 1, rem.j + 1));
                }
                if (great == dp[rem.i][rem.j + 1]){
                    queue.add(new Pair(rem.psf + "d2 ", rem.i, rem.j + 1));
                }
            }
            else {
                int great = Math.max(dp[rem.i - 1][rem.j + 1], Math.max(dp[rem.i][rem.j + 1], dp[rem.i + 1][rem.j + 1]));

                if (great == dp[rem.i - 1][rem.j + 1]){
                    queue.add(new Pair(rem.psf + "d1 ", rem.i - 1, rem.j + 1));
                }
                if (great == dp[rem.i][rem.j + 1]){
                    queue.add(new Pair(rem.psf + "d2 ", rem.i, rem.j + 1));
                }
                if (great == dp[rem.i + 1][rem.j + 1]){
                    queue.add(new Pair(rem.psf + "d3 ", rem.i + 1, rem.j + 1));
                }
            }
        }

    }
}
