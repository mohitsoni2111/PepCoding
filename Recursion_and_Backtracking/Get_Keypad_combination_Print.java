package Recursion_and_Backtracking;

public class Get_Keypad_combination_Print {

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    private static void printKPC(String que, String ans) {
        if (que.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = que.charAt(0);        // 6
        String rest = que.substring(1);  // 78

        String codeForCh = codes[ch - '0'];         // '0' -> 48 , '6' -> 54, therefore '6'-'0' = 6
        for (int i = 0; i < codeForCh.length(); i++){
            char chcode = codeForCh.charAt(i);
            printKPC(rest, ans + chcode);
        }
    }

    public static void main(String[] args) {
        String que = "678";
        printKPC(que, "");
    }
}
