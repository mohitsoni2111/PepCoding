package Recursion_and_Backtracking;

import java.util.ArrayList;

public class Subsequences_of_Strings_Print {
    private static void printSubSequences(String que, String ans) {
        if (que.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = que.charAt(0);
        String rest = que.substring(1);

        printSubSequences(rest, ans + ch);  // Yes
        printSubSequences(rest, ans + "");  // No
    }

    public static void main(String[] args) {
        String str = "abed";
        printSubSequences(str, "");
    }
}
