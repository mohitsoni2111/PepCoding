package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Number_Of_Ways_Of_Triangulation {
    public static int solution(int n){
        n = n - 2;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 0; i < dp.length; i++){
            int left = i - 1;
            int right = 0;
            while (left >= 0){
                dp[i] += dp[left] * dp[right];
                left--;
                right++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }
}
