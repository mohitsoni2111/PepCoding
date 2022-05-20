package Level_2.Dynamic_Programming;
import java.lang.reflect.Array;
import java.util.*;

public class Russian_Doll_Envelopes {
    public static class Envelope implements Comparable<Envelope>{
        int w;
        int h;
        Envelope(int w ,int h){
            this.w = w;
            this.h = h;
        }
        public int compareTo(Envelope o){
            return this.w - o.w;
        }
    }
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        Envelope[] envelops = new Envelope[n];
        for (int i = 0; i < n; i++){
            String line = scn.nextLine();
            String[] parts = line.split(" ");
            int w = Integer.parseInt(parts[0]);
            int h = Integer.parseInt(parts[1]);
            envelops[i] = new Envelope(w, h);
        }

        Arrays.sort(envelops);
        int[] dp = new int[n];
        int overallMax = 0;
        for (int i = 0; i < dp.length; i++){
            int max = 0;
            for (int j = 0; j < i; j++){
                if (envelops[j].h < envelops[i].h && envelops[j].w < envelops[i].w){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            overallMax = Math.max(overallMax, dp[i]);
        }
        System.out.println(overallMax);
    }
}
