// https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

package Strings;

import java.util.Scanner;

// Backtracking
public class permutation_of_string {

    public static String swap(String str, int i, int j){
        char[] chr = str.toCharArray();
        char temp = chr[i];
        chr[i] = chr[j];
        chr[j] = temp;
        return String.valueOf(chr);
    }

    public static void permutationOfSting(String str, int left, int right){
        if (left == right)
            System.out.println(str);
        else {
            for(int i = left; i <= right; i++){
                str = swap(str, left, i);
                permutationOfSting(str, left+1, right);
                str = swap(str, left, i);                       // Backtracking
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        permutationOfSting(str, 0, str.length()-1);
    }
}
