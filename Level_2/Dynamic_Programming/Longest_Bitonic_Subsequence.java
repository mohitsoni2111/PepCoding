package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Longest_Bitonic_Subsequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        int[] lis = new int[n];
        for (int i = 0; i < n; i++){
            int max = 0;
            for (int j = 0; j < i; j++){
                if (arr[j] <= arr[i]){
                    max = Math.max(max, lis[j]);
                }
            }
            lis[i] = max + 1;
        }

        int[] lds = new int[n];
        for (int i = arr.length - 1; i >= 0; i--){
            int max = 0;
            for (int j = arr.length - 1; j > i; j--){
                if (arr[j] <= arr[i]){
                    max = Math.max(max, lds[j]);
                }
            }
            lds[i] = max + 1;
        }

        int overallMax = 0;
        for (int i = 0; i < arr.length; i++){
            overallMax = Math.max(lis[i] + lds[i] - 1, overallMax);
        }
        System.out.println(overallMax);
    }
}
