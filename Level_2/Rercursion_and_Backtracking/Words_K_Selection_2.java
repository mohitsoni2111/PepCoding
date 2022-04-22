package Level_2.Rercursion_and_Backtracking;
import java.io.*;
import java.util.*;

public class Words_K_Selection_2 {
    public static void generateSelection(String ustr, int cs, int ts, int lc, String asf ) {
        if (cs > ts){
            System.out.println(asf);
            return;
        }

        for (int i = lc + 1; i < ustr.length(); i++){
            char ch = ustr.charAt(i);
            generateSelection(ustr, cs + 1, ts, i, asf + ch);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int k = scn.nextInt();

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (!unique.contains(ch)) {
                unique.add(ch);
                ustr += ch;
            }
        }

        generateSelection(ustr, 1, k, -1, "");
    }
}
