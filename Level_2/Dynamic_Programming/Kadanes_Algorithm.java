package Level_2.Dynamic_Programming;

import java.util.Scanner;

public class Kadanes_Algorithm {
    public static int solution(int[] arr) {
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

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
}
