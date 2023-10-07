package LeetCode.HashMap_HashSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Find_the_Difference_of_Two_Arrays_2215 {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();




        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(",");
        int[] num1 = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            num1[i] = Integer.parseInt(input[i]);
        }
        int[] num2 = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            num2[i] = Integer.parseInt(input[i]);
        }

        List<List<Integer>> result = findDifference(num1, num2);

        for (int i = 0; i < input.length; i++) {
            System.out.println(result);
        }
    }
}
