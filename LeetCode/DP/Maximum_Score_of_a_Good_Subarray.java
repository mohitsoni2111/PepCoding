package LeetCode.DP;

import java.util.Scanner;

public class Maximum_Score_of_a_Good_Subarray {

    public static int maximumScore(int[] nums, int k) {
        int[][] dp = new int[nums.length][nums.length];

        for (int g = 0; g < dp.length; g++){
            for (int i = 0,j = g; j < dp.length; j++){
//                if (g == 0 && )
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n; i++){
            nums[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(maximumScore(nums, k));
    }
}
