package Level_2.Arrays;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Next_Greater_Element_I {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stack.empty() && num > stack.peek())
                map.put(stack.pop(), num);
            stack.push(num);
        }

        while (!stack.empty())
            map.put(stack.pop(), -1);

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] num1 = new int[n];
        for (int i = 0; i < n; i++){
            num1[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] num2 = new int[n];
        for (int i = 0; i < m; i++){
            num2[i] = scn.nextInt();
        }
        int[] res = nextGreaterElement(num1, num2);

        for (int num : res)
            System.out.println(num);
    }
}
