package LeetCode.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Product_of_Array_Except_Self_238 {

    public static int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                if (!(i==j)){
                    result[i] *= nums[j];
                }
            }
        }

        return result;
    }

    public static int[] productExceptSelf1(int[] nums){
        int n = nums.length;
        int[] pre = new int[n];
        int[] suff = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for (int i = 1; i < n; i++){
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--){
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int [] ans = new int[n];
        for (int i = 0; i < n; i++){
            ans[i] = pre[i] * suff[i];
        }

        return ans;
    }
    public static int[] productExceptSelf3(int[] nums){
        int n  = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int curr = 1;
        for (int i = 0; i < n; i++){
            ans[i] *= curr;
            curr *= nums[i];
        }

        curr = 1;
        for (int i = n - 1; i >= 0; i--){
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int[] result = productExceptSelf3(nums);

        for (int i = 0; i < input.length; i++) {
            System.out.println(result[i]);
        }
    }
}
