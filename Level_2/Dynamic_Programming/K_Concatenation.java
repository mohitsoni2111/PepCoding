package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class K_Concatenation {
    public static int kadanes(int[] arr){
        int currentSum = arr[0];
        int overallSum = arr[0];

        for (int i = 1; i < arr.length; i++){
            if (currentSum >= 0){
                currentSum += arr[i];
            }
            else {
                currentSum = arr[i];
            }

            if (currentSum > overallSum){
                overallSum = currentSum;
            }
        }
        return overallSum;
    }
    public static int kadanes2(int[] arr){
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++){
            newArr[i + arr.length] = arr[i];
        }

        return kadanes(newArr);
    }

    public static long solution(int[] arr, int k, long sum) {
        if (k == 1){
            return kadanes(arr);
        }
        else if (sum < 0) {
            return kadanes2(arr);
        }
        else {
            return kadanes2(arr) + (k - 2) * sum;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
            sum += arr[i];
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k, sum));
    }
}
