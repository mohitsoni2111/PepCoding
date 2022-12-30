package Level_2.Arrays;

import java.util.Scanner;

public class Wiggle_Sort_1 {

    public static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }
    public static void wiggleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++){
            if (i % 2 == 0){
                if (arr[i] > arr[i + 1]){
                    swap(arr, i , i + 1);
                }
            } else {
                if (arr[i] < arr[i + 1]){
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        wiggleSort(arr);

        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
