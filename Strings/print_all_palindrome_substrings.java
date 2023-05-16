package Strings;

import java.util.Scanner;

public class print_all_palindrome_substrings {

    public static boolean isPalindrome(String substring){
        int i = 0;
        int j = substring.length()-1;
        while (i <= j){
            char ci = substring.charAt(i);
            char cj = substring.charAt(j);
            if(ci != cj)
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void printPalindromeSubstrings(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            for (int j = i+1; j <= str.length(); j++){
                String substring = str.substring(i, j);
                if(isPalindrome(substring)) {
//                    count++;
                    System.out.println(substring);
                }
            }
        }
//        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printPalindromeSubstrings(str);
    }
}
