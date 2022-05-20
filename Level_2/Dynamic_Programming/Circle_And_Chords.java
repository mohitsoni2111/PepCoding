package Level_2.Dynamic_Programming;

import java.util.Scanner;

// Same as Catalan Number
public class Circle_And_Chords {
    public static long NumberOfChords(int n){
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++){
            int left = 0;
            int right = i - 1;
            while (left <= i - 1){
                dp[i] += dp[left] * dp[right];
                left++;
                right--;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NumberOfChords(n));
    }
}
