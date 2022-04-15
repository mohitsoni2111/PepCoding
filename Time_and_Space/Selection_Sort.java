package Time_and_Space;

import java.util.Scanner;

public class Selection_Sort {

    private static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++){
            int min_idx = i;

            for (int j = i + 1 ; j < n; j++){
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }

            swap(arr, i, min_idx);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        selectionSort(arr);
        System.out.println("Sorted array");
        printArray(arr);
    }

}
