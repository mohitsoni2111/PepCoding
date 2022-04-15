package Stack_and_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Next_greater_element_on_right {

    static int[] nextGreaterRight(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1);

        ans[arr.length - 1] = -1;

        for(int i = arr.length - 2; i >= 0; i--){
            while (!stack.isEmpty() && arr[i] >= stack.peek()){
                stack.pop();
            }
            if(stack.size() == 0)
                ans[i] = -1;
            else
                ans[i] = stack.peek();

            stack.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int[] arr_new = nextGreaterRight(arr);
        for (int i=0; i<n; i++){
            System.out.print(arr_new[i]+ " ");
        }
    }
}
