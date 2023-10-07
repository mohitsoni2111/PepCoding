package LeetCode.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Example 1:

Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.
Example 2:

Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.
Example 3:

Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 */
public class Increasing_Triplet_Subsequence_334 {

    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int n : nums){
            if (n <= first){
                first = n;
            } else if (n <= second){
                second = n;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        boolean result = increasingTriplet(nums);
        System.out.println(result);
    }
}
