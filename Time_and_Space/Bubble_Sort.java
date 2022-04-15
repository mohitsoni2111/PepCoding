package Time_and_Space;

import java.util.Scanner;

public class Bubble_Sort {
    static int noOfSwaps = 0;
    static int noOfPasses = 0;

    private static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++){
            boolean swapped = false;
            noOfPasses += 1;

            for (int j = 0; j < n - i - 1; j++){
                if (arr[j] > arr[j+1]){
                    swap(arr, j , j + 1);
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        noOfSwaps += 1;
    }

    private static void printArray(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static void bubbleSortRecursion(int[] arr, int n){
        if (n == 1)
            return;

        for (int i = 0 ; i < n - 1; i++){
            if (arr[i] > arr[i+1]){
                swap(arr, i, i + 1);
            }

            bubbleSortRecursion(arr, n - 1);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        bubbleSort(arr);
//        bubbleSortRecursion(arr, n);
        System.out.println("Sorted array");
        printArray(arr);
        System.out.println("noOfPasses : " + noOfPasses);
        System.out.println("noOfSwaps : " + noOfSwaps);
    }

}
