package Level_2.Arrays;

import java.util.Scanner;

public class Number_of_Subarrays_with_Bounded_Maximum {
    public static int numSubArrayBoundedMax(int[] nums, int left, int right) {
        int si = 0, ei = 0;
        int n = nums.length;

        int ans = 0;
        int prevCount = 0;
        while (ei < n){
            if (left <= nums[ei] && nums[ei] <= right){
                prevCount = ei - si + 1;
                ans += prevCount;
            } else if (nums[ei] < left){
                ans += prevCount;
            } else {
                si = ei + 1;
                prevCount = 0;
            }
            ei++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }

        int left = scn.nextInt();
        int right = scn.nextInt();

        int count = numSubArrayBoundedMax(nums, left, right);
        System.out.println(count);
    }
}
