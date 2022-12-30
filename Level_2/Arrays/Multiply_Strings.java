package Level_2.Arrays;

import java.util.Scanner;

public class Multiply_Strings {
    public static String multiplication(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int l1 = num1.length();
        int l2 = num2.length();
        int[] res = new int[l1 + l2];

        int i = l2 - 1;
        int pf = 0; // power factor
        while (i >= 0){
            int iVal = num2.charAt(i) - '0';
            i--;

            int j = l1 - 1;
            int k = res.length - 1 - pf;
            int carry = 0;

            while (j >= 0 || carry != 0){
                int jVal = j >= 0 ? num1.charAt(j) - '0' : 0;
                j--;

                int prod = iVal * jVal + carry + res[k];

                res[k] = prod % 10;
                carry = prod / 10;
                k--;
            }
            pf++;
        }

        // Management of leading zeros
        StringBuilder str = new StringBuilder();
        boolean flag = false;
        for (int val : res){
            if (val != 0 || flag) {
                flag = true;
                str.append(val);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str1 = scn.nextLine();
        String str2 = scn.nextLine();

        String res = multiplication(str1, str2);
        System.out.println(res);
    }
}
