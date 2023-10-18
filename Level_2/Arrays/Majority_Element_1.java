package Level_2.Arrays;

import java.util.Scanner;

public class Majority_Element_1 {
    public static int validCandidate(int[] nums){
        int val = nums[0];
        int count = 0;

        for (int num : nums){
            if (num == val) count++;
            else count--;

            if(count == 0){
                val = num;
                count = 1;
            }
        }
        return val;
    }

    public static int majorityElement2(int[] nums) {
        int value = validCandidate(nums);

        int count = 0;
        for(int num : nums){
            if(num == value){
                count++;
            }
        }

        if(count > nums.length/2) return value;
        else return -1;
    }

    public static int majorityElement(int[] nums){
        int candidateElement = nums[0];
        int counter = 1;

        for (int i = 1; i < nums.length; i++){
            if (nums[i] == candidateElement) {
                counter++;
            } else {
              counter--;
              if (counter == 0){
                  candidateElement = nums[i];
                  counter = 1;
              }
            }
        }
        return candidateElement;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int ans = majorityElement(arr);
        System.out.print(ans);
    }
}
