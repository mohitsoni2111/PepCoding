package Level_2.Dynamic_Programming;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Print_All_Longest_Increasing_Subsequences{
    public static class Pair {
        int l;
        int i;
        int v;
        String psf;

        Pair(int l, int i, int v, String psf){
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }
    public static void solution(int[] arr){
        int[] dp = new int[arr.length];
        int overallMax = 0;

        for (int i = 0; i < dp.length; i++){
            int max = 0;
            for (int j = 0; j < i; j++){
                if (arr[i] >= arr[j]){
                    dp[i] = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            overallMax = Math.max(overallMax, dp[i]);
        }
        System.out.println(overallMax);


        ArrayDeque<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < dp.length; i++) {
            if (overallMax == dp[i]){
                queue.add(new Pair(overallMax, i, arr[i], arr[i] + " "));
            }
        }

        while (queue.size() > 0){
            Pair rem = queue.removeFirst();

            if (rem.l == 1){
                System.out.println(rem.psf);
            }

            for (int j = rem.i - 1; j >= 0; j--){
                if (dp[j] == rem.i - 1 && arr[j] <= rem.v){
                    queue.add(new Pair(dp[j], j, arr[j], arr[j] + "-> " + rem.psf));
                }
            }
        }
    }

    public static void main(String []args){
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = scn.nextInt();
            }
            solution(arr);
            scn.close();
        }
}
