package Level_2.Dynamic_Programming;

import java.util.HashSet;

public class Distinct_Echo_Substrings {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        HashSet<String> set = new HashSet<>();

        for (int len = 1; len <= n/2; len++){
            int count = 0;
            for (int l = 0, r = len; r < n; l++, r++){
                if (text.charAt(l) == text.charAt(r)){
                    count++;
                } else {
                    count = 0;
                }
                if (count == len){
                    String str = text.substring(l, r);
                    set.add(str);
                    count--; // First Char remove
                }
            }
        }
        return set.size();
    }
}
