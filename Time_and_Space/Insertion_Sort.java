package Time_and_Space;

import java.util.Scanner;

public class Insertion_Sort {

    private static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++){
            int key = arr[i];
            int j = i -1;

            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    private static void insertionSortRecursive(int[] arr, int n) {
        if (n <= 1)
            return;

        insertionSortRecursive(arr, n - 1);

        // Insert last element at its correct position in sorted array
        int last = arr[n - 1];
        int  j = n - 2;

        while (j >= 0 && arr[j] > last){
            arr[j+1] = arr[j];
            j = j - 1;
        }

        arr[j + 1] = last;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void printArray(int[] arr) {
        for (int j : arr)
            System.out.print(j + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        insertionSort(arr);
//        insertionSortRecursive(arr, n);
        System.out.println("Sorted array");
        printArray(arr);
    }
}
