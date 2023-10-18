package Level_2.Arrays;

import java.util.Scanner;

public class Next_Greater_Element_I {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        return null;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] num1 = new int[n];
        for (int i = 0; i < n; i++){
            num1[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] num2 = new int[n];
        for (int i = 0; i < m; i++){
            num2[i] = scn.nextInt();
        }
        int[] res = nextGreaterElement(num1, num2);

        for (int num : res)
            System.out.println(num);
    }
}
