package Time_and_Space;

import java.util.Scanner;

public class Merge_Two_Sorted_Array {

    private static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]){
                ans[k++] = arr1[i++];
            }
            else {
                ans[k++] = arr2[j++];
            }
        }
        while (i < arr1.length){
            ans[k++] = arr1[i++];
        }
        while (j < arr2.length){
            ans[k++] = arr2[j++];
        }

        return ans;
    }

    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++)
            arr1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++)
            arr2[i] = sc.nextInt();

//        int[] arr1 = {1, 3, 5, 7};
//        int[] arr2 = {2, 4, 6, 8};
        int[] ans = mergeTwoSortedArray(arr1, arr2);
        System.out.println("Sorted array");
        printArray(ans);
    }
}
