package Level_2.Dynamic_Programming;
import java.util.HashMap;
import java.util.Scanner;

public class Highway_Billboard {
    // O(x^2)
    public static int solution(int m , int[] x, int[] rev, int t) {
        int[] dp = new int[x.length];
        int ans = 0;

        dp[0] = rev[0];

        for (int i = 1; i < x.length; i++){
            int max = 0;
            for (int j = 0; j < i; j++){
                int dist = x[i] - x[j];
                if (dist > t){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + rev[i];
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
    // O(m)
    public static int solution2(int m , int[] x, int[] rev, int t) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < x.length; i++){
            map.put(x[i], rev[i]);
        }

        int[] dp = new int[m + 1];
        for (int i = 1; i <= m; i++){
            if (!map.containsKey(i)){
                dp[i] = dp[i - 1];
            }
            else{
                int boardNotInstalled = dp[i - 1];
                int boardInstalled = map.get(i);
                if (i > t + 1){
                    boardInstalled += dp[i - t - 1];
                }
                dp[i] = Math.max(boardNotInstalled, boardInstalled);
            }
        }
        return dp[m];
    }

    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}
