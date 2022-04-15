package Stack_and_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Stock_span {
    public static int[] stockSpan(int[] arr){
        if (arr.length == 0) return null;

        int[] span = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;

        for (int i = 1; i < arr.length - 1; i++){
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]){
                stack.pop();
            }

            if (stack.size() == 0) {
                span[i] = i + 1;
            }
            else {
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return span;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int[] arr_new = stockSpan(arr);
        for (int i=0; i<n; i++){
            System.out.print(arr_new[i] + " ");
        }
    }
}
