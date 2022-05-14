package Level_2.Dynamic_Programming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Print_All_Paths_With_Target_Sum_Subset {
    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int target = Integer.parseInt(br.readLine());


        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = true;
                }
                else if (i == 0){
                    dp[i][j] = false;
                }
                else if (j == 0){
                    dp[i][j] = true;
                }
                else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    }
                    else {
                        int val = arr[i - 1];
                        if (j >= val){
                            if (dp[i - 1][j - val]){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[arr.length][target]);

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(n, target, ""));

        while (queue.size() > 0){
            Pair rem = queue.removeFirst();

            if (rem.i == 0 || rem.j ==0){
                System.out.println(rem.psf);
            }
            else {
                int val = arr[rem.i - 1];
                if (rem.j > val) {
                    boolean include = dp[rem.i - 1][rem.j - val];
                    if (include) {
                        queue.add(new Pair(rem.i - 1, rem.j - val, (rem.i - 1) + " " + rem.psf));
                    }
                }

                boolean exclude = dp[rem.i - 1][rem.j];
                if (exclude) {
                    queue.add(new Pair(rem.i - 1, rem.j, rem.psf));
                }
            }
        }
    }
}
