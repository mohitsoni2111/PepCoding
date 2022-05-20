package Level_2.Dynamic_Programming;
import java.util.*;

public class Maximum_Non_overlapping_Bridges {
    public static class Bridge implements Comparable<Bridge>{
        int n;
        int s;
        Bridge(int n, int s){
            this.n = n;
            this.s = s;
        }
        public int compareTo(Bridge o){
            if (this.n != o.n){
                return this.n - o.n;
            }
            else {
                return this.s - o.n;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        Bridge[] bridges = new Bridge[n];
        for (int i = 0; i < n; i++){
            String line = scn.nextLine();
            String[] parts = line.split(" ");
            int nr = Integer.parseInt(parts[0]);
            int s = Integer.parseInt(parts[1]);
            bridges[i] = new Bridge(nr, s);
        }

        Arrays.sort(bridges);
        int[] dp = new int[n];
        int overallMax = 0;
        for (int i = 0; i < dp.length; i++){
            int max = 0;
            for (int j = 0; j < i; j++){
                if (bridges[j].s <= bridges[i].s){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            overallMax = Math.max(overallMax, dp[i]);
        }
        System.out.println(overallMax);
    }
}
