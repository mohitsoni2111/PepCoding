package LeetCode.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Merge_Strings_Alternately_1768 {

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < word1.length() || i < word2.length()){
            if (i < word1.length()){
                stringBuilder.append(word1.charAt(i));
            }
            if (i < word2.length()){
                stringBuilder.append(word2.charAt(i));
            }
            i++;
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word1 = br.readLine();
        String word2 = br.readLine();
        String result = mergeAlternately(word1, word2);
        System.out.println(result);
    }
}
