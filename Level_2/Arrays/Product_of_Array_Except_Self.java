package Level_2.Arrays;

import java.util.Scanner;

public class Product_of_Array_Except_Self {
    public static int[] productExceptSelf(int[] nums) {
        int[] right = new int[nums.length];

        int prod = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            prod *= nums[i];
            right[i] = prod;
        }

        prod = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++){
            int lp = prod;
            int rp = right[i + 1];

            res[i] = lp * rp;

            prod *= nums[i];
        }
        res[nums.length - 1] = prod;
        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] res = productExceptSelf(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
