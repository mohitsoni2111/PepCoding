package Stack_and_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Largest_Area_Histogram {

    private static int largestAreaHistogram(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        //we push -1 to the stack because for some elements there will be no previous
        //smaller element in the array, and we can store -1 as the index for previous smaller.
        stack.push(-1);
        int[] left_smaller = new int[arr.length];
        int[] right_smaller = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            left_smaller[i] = -1;
            right_smaller[i] = arr.length;
        }

        for (int i = 0; i < arr.length; i++){
            while (!stack.isEmpty() && stack.peek() != -1 && arr[i] < arr[stack.peek()]){
                right_smaller[stack.peek()] = i;
                stack.pop();
            }
            if (i > 0 && arr[i] == arr[i - 1]){
                left_smaller[i] = left_smaller[i -1];
            }
            else {
                left_smaller[i] = stack.peek();
            }

            stack.push(i);
        }

        int maxArea = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int width = right_smaller[i] - left_smaller[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args){
        int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println("Maximum area is " + largestAreaHistogram(hist));
    }
}
