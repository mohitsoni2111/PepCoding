package Stack_and_Queue;

import java.util.Stack;

public class Sliding_Window_Maximum_1 {

    private static void slindingMax(int[] arr, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        stack.push(arr.length - 1);
        ans[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--){
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]){
                stack.pop();
            }
            if (stack.isEmpty())
                ans[i] = arr.length;
            else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        int j = 0;
        for (int i = 0; i < arr.length - k; i++){
            if (j < i)
                j = i;
            while (ans[j] > i + k){         // i+k -> window end point
                j = ans[j];
            }
            System.out.println(arr[j]);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 3;
        slindingMax(arr, k);
    }

}
