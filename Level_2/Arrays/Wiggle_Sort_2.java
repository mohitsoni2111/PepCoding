package Level_2.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Wiggle_Sort_2 {
    public static void wiggleSort2(int[] nums) {
        //step 1 : sort the array{Time- O(nlogn)}
        Arrays.sort(nums);

        //step 2: make an extra array and rearrange it{Space - O(n)}
        int n = nums.length;
        int[] arr = new int[n];

        int i = 1;
        int j = n-1;
        while(i < n){
            arr[i] = nums[j];
            i += 2;
            j--;
        }
        i = 0;
        while(i < n){
            arr[i] = nums[j];
            i += 2;
            j--;
        }

        //step 3: fill input array from arr
        for(i = 0; i < n; i++){
            nums[i] = arr[i];
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        wiggleSort2(arr);
    /*
    -if index is even then smaller than next,
    -if index is odd then greater than next element,
    -to check any correct order, we will not print array, we will check inequality
    -if print false, that means wrong answer, if true than correct answer.
    */
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0 && arr[i] >= arr[i + 1]) {
                System.out.println(false);
                return;
            } else if (i % 2 == 1 && arr[i] <= arr[i + 1]) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
