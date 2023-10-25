package Level_2.Arrays;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Next_Greater_Element_II {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % n);
        }
        return res;
    }
    public static int[] nextGreaterElements2(int[] nums){
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 2; i >= 0; i--){
            // - *
            while (!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            stack.push(nums[i]);
        }

        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--){
            // - * +
            while (!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            res[i] = stack.size() == 0? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = scn.nextInt();
        }
        int[] res = nextGreaterElements(nums);

        for (int num : res)
            System.out.println(num);
    }
}
