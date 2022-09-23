package Time_and_Space;

import java.util.Scanner;

public class Merge_Sort {

    private static void merge(int[] arr, int left, int mid, int right) {

        // Find the size of two sub arrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        // Initial index of merged sub array
        int k = left;

        while (i < L.length && j < R.length){
            if (L[i] < R[j]){
                arr[k++] = L[i++];
            }
            else {
                arr[k++] = R[j++];
            }
        }
        while (i < L.length){
            arr[k++] = L[i++];
        }
        while (j < R.length){
            arr[k++] = R[j++];
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right){
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
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

        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array");
        printArray(arr);
    }
}
