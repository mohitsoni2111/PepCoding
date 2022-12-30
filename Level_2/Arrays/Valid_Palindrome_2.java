package Level_2.Arrays;

import java.util.Scanner;

public class Valid_Palindrome_2 {
    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            } else {
                // Skip from left or right one ch
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        boolean res = validPalindrome(str);
        System.out.println(res);
    }
}
