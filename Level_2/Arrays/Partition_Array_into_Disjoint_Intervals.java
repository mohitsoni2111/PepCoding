package Level_2.Arrays;

import java.util.Scanner;

public class Partition_Array_into_Disjoint_Intervals {
    public static int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int greater = nums[0];
        int ans = 0;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] > greater){
                greater = nums[i];
            } else if (nums[i] < leftMax){
                leftMax = greater;
                ans = i;
            }
        }

        return ans + 1;
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }

        int len = partitionDisjoint(nums);
        System.out.println(len);
    }
}
