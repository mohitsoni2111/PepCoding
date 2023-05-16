package Level_2.Arrays;

import java.util.Scanner;

public class Maximum_Swap {
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static String maximumSwap(String num) {
        char[] arr = num.toCharArray();

        // 1. Prepare last occurrence of each digit
        int[] li = new int[10];
        for (int i = 0; i < arr.length; i++){
            li[arr[i] - '0'] = i;
        }

        // 2. Figure out position for swapping
        boolean flag = false;
        for (int i = 0; i < arr.length; i++){
            int digit = arr[i] - '0';
            for (int j = 9; j < digit; j--){
                if (i < li[j]){
                    // Swapping and break
                    swap(arr, i, li[j]);
                    flag = true;
                    break;
                }
                if (flag) break;
            }
        }

        // 3. Prepare ans in form of String
        StringBuilder res = new StringBuilder();
        for (char c : arr) {
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        String ans = maximumSwap(str);
        System.out.println(ans);
    }
}
