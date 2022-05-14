package Level_2.Dynamic_Programming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Print_All_Results_In_0_1_Knapsack {
    private static class Pair {
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] weights = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(str2.split(" ")[i]);
        }
        int target = Integer.parseInt(br.readLine());


        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                if (j >= weights[i - 1]){
                    int remW = j - weights[i - 1];
                    dp[i][j] = Math.max(dp[i - 1][remW] + values[i - 1], dp[i - 1][j]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][target]);

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(n, target, ""));

        while (queue.size() > 0){
            Pair rem = queue.removeFirst();

            if (rem.i == 0 || rem.j == 0){
                System.out.println(rem.psf);
            }
            else {
                if (rem.j > weights[rem.i - 1]){
                    int remW = rem.j - weights[rem.i - 1];
                    int include = dp[rem.i - 1][remW] + values[rem.i - 1];

                    if (dp[rem.i][rem.j] == include){
                        queue.add(new Pair(rem.i - 1, rem.j - weights[rem.i - 1], (rem.i - 1) + " " + rem.psf));
                    }
                }

                int exclude = dp[rem.i - 1][rem.j];
                if (dp[rem.i][rem.j] == exclude){
                    queue.add(new Pair(rem.i - 1, rem.j, rem.psf));
                }
            }
        }

    }
}
