package Level_2.Arrays;

import java.util.Scanner;

public class Max_Chunks_To_Make_Array_Sorted_2 {
    public static int maxChunksToSorted2(int[] arr) {
        int[] rightMin = new int[arr.length + 1];
        rightMin[arr.length] = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--){
            rightMin[i] = Math.min(arr[i], rightMin[i + 1]);
        }

        int leftMax = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            leftMax = Math.max(leftMax, arr[i]);
            if (leftMax <= rightMin[i + 1]){
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}
