package Level_2.Rercursion_and_Backtracking;

import java.util.*;

public class Word_Break_I {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashSet<String> dict = new HashSet<>();
        for(int i = 0  ; i  < n; i++){
            dict.add(scn.next());
        }
        String sentence = scn.next();
        wordBreak(sentence,"", dict);
    }

    public static void wordBreak(String str, String ans, HashSet<String> dict){
        // write your code here
    }
}
