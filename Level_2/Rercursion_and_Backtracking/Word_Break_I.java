package Level_2.Rercursion_and_Backtracking;

import java.util.*;

public class Word_Break_I {
    public static void wordBreak(String str, String ans, HashSet<String> dict){
        if (str.length() == 0){
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++){
            String leftPart = str.substring(0 ,i + 1);
            if (dict.contains(leftPart)){
                String rightPart = str.substring(i + 1);
                wordBreak(rightPart, leftPart + " ", dict);
            }
        }
    }

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
}
