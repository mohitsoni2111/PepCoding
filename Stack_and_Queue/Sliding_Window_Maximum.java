package Stack_and_Queue;

import java.util.Deque;
import java.util.LinkedList;

public class Sliding_Window_Maximum {

    private static void printKMax(int[] arr, int k) {
        Deque<Integer> deque = new LinkedList<>();

        // Process first k elements
        int i;
        for (i = 0; i < k; i++){
            // For every element, the previous smaller elements are useless so remove them from deque
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
                deque.removeLast();

            deque.addLast(i);
        }
        for (; i < arr.length; i++){
            // The element at the front of the queue is the largest element of previous window, so print it
            System.out.println(arr[deque.peek()] + " ");

            // Remove the elements which are out of this window
            while (!deque.isEmpty() && deque.peek() <= i - k)
                deque.removeFirst();

            // For every element, the previous smaller elements are useless so remove them from deque
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
                deque.removeLast();

            // Add current element at the rear of Qi
            deque.addLast(i);
        }
        // Print the maximum element of last window
        System.out.print(arr[deque.peek()]);
    }

    public static void main(String args[]) {
        int arr[] = { 5, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 3;
        printKMax(arr, k);
    }
}
