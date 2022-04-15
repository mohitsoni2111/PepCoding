package Recursion_and_Backtracking;

import java.util.Scanner;

public class Target_sum_subset {

    private static void printTargetSumSubset(int[] arr, int index, String set, int sumOfSet, int target) {
        if (index == arr.length){
            if (sumOfSet == target){
                System.out.println(set + " ");
            }
            return;
        }

        printTargetSumSubset(arr, index + 1, set + arr[index] + ", ", sumOfSet + arr[index], target);
        printTargetSumSubset(arr, index + 1, set, sumOfSet, target);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();
        printTargetSumSubset(arr, 0, "", 0, target);
    }
}
