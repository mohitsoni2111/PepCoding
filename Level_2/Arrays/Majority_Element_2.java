package Level_2.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Majority_Element_2 {
    public static List<Integer> majorityElement(int[] nums) {
        int val1 = nums[0];
        int count1 = 1;

        int val2 = nums[0];
        int count2 = 0;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] == val1){
                count1++;
            } else if (nums[i] == val2) {
                count2++;
            } else {
                if (count1 == 0){
                    val1 = nums[i];
                    count1 = 1;
                } else if (count2 == 0) {
                    val2 = nums[i];
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        List<Integer> result = new ArrayList<>();

        if (isGreaterThanNBy3(nums, val1)){
            result. add(val1);
        }
        if (val1 != val2 && isGreaterThanNBy3(nums, val2)){
            result. add(val2);
        }
        return result;
    }

    public static boolean isGreaterThanNBy3(int[] nums, int val) {
        int count = 0;
        for (int num : nums){
            if (val == num){
                count++;
            }
        }
        return count > nums.length/3;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        List<Integer> res = majorityElement(arr);
        System.out.println(res);
    }
}
