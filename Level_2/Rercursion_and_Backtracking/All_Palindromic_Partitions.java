package Level_2.Rercursion_and_Backtracking;

import java.io.*;
import java.util.*;

public class All_Palindromic_Partitions {
    private static boolean ispalindrome(String str) {
        int leftIndex = 0;
        int rightIndex = str.length() - 1;
        while (leftIndex < rightIndex){
            char left = str.charAt(leftIndex);
            char right = str.charAt(rightIndex);
            if (left != right) return false;
            leftIndex++;
            rightIndex++;
        }
        return true;
    }

    public static void solution(String str, String asf) {
        if (str.length() == 0){
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < str.length(); i++){
            String prefix = str.substring(0, i + 1);
            String ros = str.substring(i + 1);
            if (ispalindrome(prefix)){
                solution(ros, asf + "(" + prefix + ")");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str, "");
    }
}
