package Level_2.Arrays;

import java.util.Scanner;

public class Sort_Array_By_Parity {
    public static void sortArrayByParity(int[] nums) {
        int i = 0; // First unsolved
        int j = 0; // First odd

        while (i < nums.length){
            if (nums[i] % 2 == 0){
                // even -> swap, i++, j++
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j++;
            } else {
                // odd -> i++
                i++;
            }
        }
    }

    //// ~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        sortArrayByParity(arr);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
