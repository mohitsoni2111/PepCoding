package Level_2.Arrays;

import java.util.Scanner;

public class Add_Strings {
    public static String addStrings(String num1, String num2) {
        String res = "";

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0){
            int iVal = i >=0 ? num1.charAt(i) - '0' : 0;
            int jVal = j >=0 ? num2.charAt(j) - '0' : 0;
            i--;
            j--;

            int sum = iVal + jVal + carry;
            res = (sum % 10) + res;
            carry = sum / 10;
        }
        return res;

        /*
        StringBuilder res = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0){
            int iVal = i >=0 ? num1.charAt(i) - '0' : 0;
            int jVal = j >=0 ? num2.charAt(j) - '0' : 0;
            i--;
            j--;

            int sum = iVal + jVal + carry;
            res.insert(0, (sum % 10));
            carry = sum / 10;
        }
        return res.toString();
         */
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String n1 = scn.nextLine();
        String n2 = scn.nextLine();

        String res = addStrings(n1, n2);
        System.out.println(res);
    }
}
