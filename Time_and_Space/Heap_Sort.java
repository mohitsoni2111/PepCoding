package Time_and_Space;

import java.util.Scanner;

public class Heap_Sort {

    private static void maxHeapify(int[] arr, int n, int i){
        int largest = i;    // Initialise largest as root
        int left = 2*i + 1;
        int right = 2*i + 2;

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]){
            largest = left;
        }

        // If right child is larger than root
        if (right < n && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            maxHeapify(arr, n, largest);
        }
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            maxHeapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            maxHeapify(arr, i, 0);
        }
    }
    static void printArray(int[] arr) {
        for (int j : arr)
            System.out.print(j + " ");
        System.out.println();
    }

    // Driver's code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        heapSort(arr);
        System.out.println("Sorted array");
        printArray(arr);
    }
}
