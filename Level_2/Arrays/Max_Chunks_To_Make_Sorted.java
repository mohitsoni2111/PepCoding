package Level_2.Arrays;

import java.util.Scanner;

public class Max_Chunks_To_Make_Sorted {
    public static int maxChunksToSorted(int[] arr) {
        int max = arr[0];
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            if (max == i){
                count++;
            }
        }

        return (count == 0)? 1 : count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted(arr);
        System.out.println(res);
    }
}
