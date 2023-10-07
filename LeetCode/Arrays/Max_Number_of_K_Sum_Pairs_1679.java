package LeetCode.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Max_Number_of_K_Sum_Pairs_1679 {

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int count = 0;

        while (start < end){
            if(nums[start] + nums[end] < k){
                start++;
            } else if(nums[start] + nums[end] > k){
                end--;
            } else {
                count++;
                start++;
                end--;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(",");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int k = Integer.parseInt(br.readLine());

        int result = maxOperations(nums, k);

        System.out.println(result);
    }
}
