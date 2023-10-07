package Level_2.Arrays;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class demo {
    public static long getMaximumPower(List<Integer> nums) {
        Collections.sort(nums);

        int n = nums.size();
        int[] dp = new int[n];

        // Initialize the dp array with the values from the sorted list
        for (int i = 0; i < n; i++) {
            dp[i] = nums.get(i);
        }

        // Iterate through the sorted list and calculate maximum sum
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If the absolute difference between elements is greater than 1,
                // consider adding the current element to the previous maximum sum
                if (Math.abs(nums.get(i) - nums.get(j)) > 1) {
                    dp[i] = Math.max(dp[i], dp[j] + nums.get(i));
                }
            }
        }

        // Find the maximum sum in the dp array
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        List<Integer> power = new ArrayList<>();
        power.add(1);
        power.add(1);
        power.add(1);
        power.add(2);
//        power.add(5);

        long result = demo.getMaximumPower(power);
        System.out.println(result);
    }
}
