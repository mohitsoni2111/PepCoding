package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Maximum_Sum_Subarray_With_At_Least_K_Elements {
    public static int solution(int[] arr, int k) {
        int ans = Integer.MIN_VALUE;

        int csum = arr[0];
        int[] maxSum = new int[arr.length];
        maxSum[0] = csum;
        for (int i = 1; i < arr.length; i++){
            if (csum > 0){
                csum += arr[i];
            }
            else {
                csum = arr[i];
            }
            maxSum[i] = csum;
        }

        int exactK = 0;
        for (int i = 0; i < k; i++){
            exactK += arr[i];
        }
        if (exactK > ans){
            ans = exactK;
        }

        for (int i = k; i < arr.length; i++){
            exactK += arr[i] - arr[i - k];
            if (exactK > ans){
                ans = exactK;
            }
            int moreThanK = maxSum[i - k] + exactK;
            if (moreThanK > ans){
                ans = moreThanK;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }
}
