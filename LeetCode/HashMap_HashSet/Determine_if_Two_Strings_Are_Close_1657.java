package LeetCode.HashMap_HashSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Determine_if_Two_Strings_Are_Close_1657 {

    public static boolean closeStrings(String word1, String word2) {
        // count the English letters
        int n = 26;
        int[] arr1 = new int[n], arr2 = new int[n];
        for (char ch : word1.toCharArray())
            arr1[ch - 'a']++;
        for (char ch : word2.toCharArray())
            arr2[ch - 'a']++;

        // if one has a letter which another one doesn't have, dont exist
        for (int i = 0; i < n; i++) {
            if (arr1[i] == arr2[i]) {
                continue;
            }
            if (arr1[i] == 0 || arr2[i] == 0) {
                return false;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word1 = br.readLine();
        String word2 = br.readLine();
        boolean result = closeStrings(word1, word2);
        System.out.println(result);
    }
}
