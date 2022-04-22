package Level_2.Rercursion_and_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Words_K_Length_Words_2 {
    private static void generateWords(int cs, int ts, String ustr, HashSet<Character> used, String asf) {
        if (cs > ts){
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < ustr.length(); i++){
            char ch = ustr.charAt(i);
            if (!used.contains(ch)){
                used.add(ch);
                generateWords(cs + 1, ts, ustr, used, asf + ch);
                used.remove(ch);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (!unique.contains(ch)) {
                unique.add(ch);
                ustr += ch;
            }
        }
        generateWords(1, k, ustr, new HashSet<>(), "");
    }
}
